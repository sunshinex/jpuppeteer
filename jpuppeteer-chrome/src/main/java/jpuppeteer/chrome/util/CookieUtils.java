package jpuppeteer.chrome.util;

import com.google.common.collect.Lists;
import jpuppeteer.api.browser.Cookie;
import jpuppeteer.api.browser.Header;
import jpuppeteer.cdp.cdp.entity.network.CookieParam;
import jpuppeteer.cdp.cdp.entity.network.SetCookiesRequest;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.io.UnsupportedEncodingException;
import java.lang.ref.SoftReference;
import java.net.URL;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class CookieUtils {

    /**
     * Date format pattern used to parse HTTP date headers in RFC 1123 format.
     */
    public static final String PATTERN_RFC1123 = "EEE, dd MMM yyyy HH:mm:ss zzz";

    /**
     * Date format pattern used to parse HTTP date headers in RFC 1036 format.
     */
    public static final String PATTERN_RFC1036 = "EEE, dd-MMM-yy HH:mm:ss zzz";

    /**
     * Date format pattern used to parse HTTP date headers in ANSI C
     * {@code asctime()} format.
     */
    public static final String PATTERN_ASCTIME = "EEE MMM d HH:mm:ss yyyy";

    private static final String[] DEFAULT_PATTERNS = new String[] {
            PATTERN_RFC1123,
            PATTERN_RFC1036,
            PATTERN_ASCTIME
    };

    private static final Date DEFAULT_TWO_DIGIT_YEAR_START;

    public static final TimeZone GMT = TimeZone.getTimeZone("GMT");

    static {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(GMT);
        calendar.set(2000, Calendar.JANUARY, 1, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        DEFAULT_TWO_DIGIT_YEAR_START = calendar.getTime();
    }

    public static final String SET_COOKIE = "set-cookie";

    private static final String SEPARATOR = ";";

    private static final String EQUAL = "=";

    private static final String HTTPS = "https";

    public static final String DOMAIN_ATTR     = "domain";
    public static final String PATH_ATTR       = "path";
    public static final String MAX_AGE_ATTR    = "max-age";
    public static final String EXPIRES_ATTR    = "expires";
    public static final String SECURE_ATTR     = "secure";
    public static final String HTTPONLY_ATTR     = "httpOnly";

    private static final String[] DATE_FORMATS = new String[]{
            "EEE, dd MMM yyyy HH:mm:ss zzz",
            "EEE, dd-MMM-yy HH:mm:ss zzz",
            "EEE MMM d HH:mm:ss yyyy",
            "EEE, dd-MMM-yyyy HH:mm:ss z",
            "EEE, dd-MMM-yyyy HH-mm-ss z",
            "EEE, dd MMM yy HH:mm:ss z",
            "EEE dd-MMM-yyyy HH:mm:ss z",
            "EEE dd MMM yyyy HH:mm:ss z",
            "EEE dd-MMM-yyyy HH-mm-ss z",
            "EEE dd-MMM-yy HH:mm:ss z",
            "EEE dd MMM yy HH:mm:ss z",
            "EEE,dd-MMM-yy HH:mm:ss z",
            "EEE,dd-MMM-yyyy HH:mm:ss z",
            "EEE, dd-MM-yyyy HH:mm:ss z",
    };

    public static SetCookiesRequest create(Cookie... cookies) {
        SetCookiesRequest request = new SetCookiesRequest();
        List<CookieParam> cookieParams = Lists.newArrayListWithCapacity(cookies.length);
        for(Cookie cookie : cookies) {
            CookieParam cookieParam = new CookieParam();
            cookieParam.setName(cookie.getName());
            cookieParam.setValue(cookie.getValue());
            cookieParam.setDomain(cookie.getDomain());
            cookieParam.setPath(cookie.getPath());
            //
            cookieParam.setExpires(Long.valueOf(cookie.getExpires().getTime() / 1000).doubleValue());
            cookieParam.setSecure(cookie.isSecure());
            cookieParam.setHttpOnly(cookie.isHttpOnly());
            cookieParam.setSameSite(cookie.getSameSite());
            cookieParam.setUrl(cookie.getUrl());
            cookieParams.add(cookieParam);
        }
        request.setCookies(cookieParams);
        return request;
    }

    public static Cookie copyOf(jpuppeteer.cdp.cdp.entity.network.Cookie cookie) {
        return Cookie.builder()
                .name(cookie.getName())
                .value(cookie.getValue())
                .domain(cookie.getDomain())
                .path(cookie.getPath())
                .expires(new Date(cookie.getExpires().longValue()))
                .httpOnly(cookie.getHttpOnly())
                .secure(cookie.getSecure())
                .sameSite(cookie.getSameSite())
                .build();
    }


    public static List<Cookie> parse(Header header, URL url) throws UnsupportedEncodingException, ParseException {
        if (!StringUtils.equalsIgnoreCase(SET_COOKIE, header.getName())) {
            throw new IllegalArgumentException("header");
        }
        if (ArrayUtils.isEmpty(header.getValues())) {
            return null;
        }
        List<Cookie> cookies = new ArrayList<>(header.getValues().length);
        OUTER:
        for(String cookieStr : header.getValues()) {
            Cookie.CookieBuilder builder = Cookie.builder();
            builder.domain(url.getHost());
            builder.path(url.getPath());
            builder.secure(HTTPS.equals(url.getProtocol()));
            List<String> kvs = Arrays.stream(cookieStr.split(SEPARATOR))
                    .map(s -> StringUtils.trim(s))
                    .filter(s -> StringUtils.isNoneEmpty(s))
                    .collect(Collectors.toList());

            Long expires = null;
            for(int i=0; i<kvs.size(); i++) {
                String[] kv = kvs.get(i).split(EQUAL);
                String name = URLDecoder.decode(kv[0], "UTF-8");
                String value = kv.length > 1 ? URLDecoder.decode(kv[1], "UTF-8") : null;
                if (i == 0) {
                    builder.name(name);
                    builder.value(value);
                } else if (DOMAIN_ATTR.equalsIgnoreCase(name)) {
                    builder.domain(value);
                } else if (PATH_ATTR.equalsIgnoreCase(name)) {
                    builder.path(value);
                } else if (SECURE_ATTR.equalsIgnoreCase(name)) {
                    builder.secure(true);
                } else if (HTTPONLY_ATTR.equalsIgnoreCase(name)) {
                    builder.httpOnly(true);
                } else if (MAX_AGE_ATTR.equalsIgnoreCase(name)) {
                    expires = System.currentTimeMillis() / 1000 + Long.valueOf(value);
                } else if (EXPIRES_ATTR.equalsIgnoreCase(name)) {
                    if (expires == null) {
                        expires = parseDate(value, DATE_FORMATS).getTime() / 1000;
                    }
                }
            }
            cookies.add(builder.build());
        }

        return cookies;
    }



    /**
     * Parses a date value.  The formats used for parsing the date value are retrieved from
     * the default http params.
     *
     * @param dateValue the date value to parse
     *
     * @return the parsed date or null if input could not be parsed
     */
    public static Date parseDate(final String dateValue) {
        return parseDate(dateValue, null, null);
    }

    /**
     * Parses the date value using the given date formats.
     *
     * @param dateValue the date value to parse
     * @param dateFormats the date formats to use
     *
     * @return the parsed date or null if input could not be parsed
     */
    public static Date parseDate(final String dateValue, final String[] dateFormats) {
        return parseDate(dateValue, dateFormats, null);
    }

    /**
     * Parses the date value using the given date formats.
     *
     * @param dateValue the date value to parse
     * @param dateFormats the date formats to use
     * @param startDate During parsing, two digit years will be placed in the range
     * {@code startDate} to {@code startDate + 100 years}. This value may
     * be {@code null}. When {@code null} is given as a parameter, year
     * {@code 2000} will be used.
     *
     * @return the parsed date or null if input could not be parsed
     */
    public static Date parseDate(
            final String dateValue,
            final String[] dateFormats,
            final Date startDate) {
        final String[] localDateFormats = dateFormats != null ? dateFormats : DEFAULT_PATTERNS;
        final Date localStartDate = startDate != null ? startDate : DEFAULT_TWO_DIGIT_YEAR_START;
        String v = dateValue;
        // trim single quotes around date if present
        // see issue #5279
        if (v.length() > 1 && v.startsWith("'") && v.endsWith("'")) {
            v = v.substring (1, v.length() - 1);
        }

        for (final String dateFormat : localDateFormats) {
            final SimpleDateFormat dateParser = DateFormatHolder.formatFor(dateFormat);
            dateParser.set2DigitYearStart(localStartDate);
            final ParsePosition pos = new ParsePosition(0);
            final Date result = dateParser.parse(v, pos);
            if (pos.getIndex() != 0) {
                return result;
            }
        }
        return null;
    }

    /**
     * Formats the given date according to the RFC 1123 pattern.
     *
     * @param date The date to format.
     * @return An RFC 1123 formatted date string.
     *
     * @see #PATTERN_RFC1123
     */
    public static String formatDate(final Date date) {
        return formatDate(date, PATTERN_RFC1123);
    }

    /**
     * Formats the given date according to the specified pattern.  The pattern
     * must conform to that used by the {@link SimpleDateFormat simple date
     * format} class.
     *
     * @param date The date to format.
     * @param pattern The pattern to use for formatting the date.
     * @return A formatted date string.
     *
     * @throws IllegalArgumentException If the given date pattern is invalid.
     *
     * @see SimpleDateFormat
     */
    public static String formatDate(final Date date, final String pattern) {
        final SimpleDateFormat formatter = DateFormatHolder.formatFor(pattern);
        return formatter.format(date);
    }

    /**
     * Clears thread-local variable containing {@link java.text.DateFormat} cache.
     *
     * @since 4.3
     */
    public static void clearThreadLocal() {
        DateFormatHolder.clearThreadLocal();
    }

    /** This class should not be instantiated. */
    private CookieUtils() {
    }


    /**
     * A factory for {@link SimpleDateFormat}s. The instances are stored in a
     * threadlocal way because SimpleDateFormat is not threadsafe as noted in
     * {@link SimpleDateFormat its javadoc}.
     *
     */
    final static class DateFormatHolder {

        private static final ThreadLocal<SoftReference<Map<String, SimpleDateFormat>>>
                THREADLOCAL_FORMATS = new ThreadLocal<SoftReference<Map<String, SimpleDateFormat>>>();

        /**
         * creates a {@link SimpleDateFormat} for the requested format string.
         *
         * @param pattern
         *            a non-{@code null} format String according to
         *            {@link SimpleDateFormat}. The format is not checked against
         *            {@code null} since all paths go through
         *            {@link DateUtils}.
         * @return the requested format. This simple dateformat should not be used
         *         to {@link SimpleDateFormat#applyPattern(String) apply} to a
         *         different pattern.
         */
        public static SimpleDateFormat formatFor(final String pattern) {
            final SoftReference<Map<String, SimpleDateFormat>> ref = THREADLOCAL_FORMATS.get();
            Map<String, SimpleDateFormat> formats = ref == null ? null : ref.get();
            if (formats == null) {
                formats = new HashMap<String, SimpleDateFormat>();
                THREADLOCAL_FORMATS.set(
                        new SoftReference<Map<String, SimpleDateFormat>>(formats));
            }

            SimpleDateFormat format = formats.get(pattern);
            if (format == null) {
                format = new SimpleDateFormat(pattern, Locale.US);
                format.setTimeZone(TimeZone.getTimeZone("GMT"));
                formats.put(pattern, format);
            }

            return format;
        }

        public static void clearThreadLocal() {
            THREADLOCAL_FORMATS.remove();
        }

    }
}
