package jpuppeteer.api.browser;

public class Emulator {

    private final Viewport viewport;

    private final UserAgent userAgent;

    private Emulator(Viewport viewport, UserAgent userAgent) {
        this.viewport = viewport;
        this.userAgent = userAgent;
    }

    public Viewport getViewport() {
        return viewport;
    }

    public UserAgent getUserAgent() {
        return userAgent;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {

        private int width;

        private int height;

        private int deviceScaleFactor = 1;

        private boolean isMobile = false;

        private boolean hasTouch = false;

        private boolean isLandscape = false;

        private String userAgent;

        private String acceptLanguage;

        private String platform;

        public Builder width(int width) {
            this.width = width;
            return this;
        }

        public Builder height(int height) {
            this.height = height;
            return this;
        }

        public Builder deviceScaleFactor(int deviceScaleFactor) {
            this.deviceScaleFactor = deviceScaleFactor;
            return this;
        }

        public Builder isMobile(boolean isMobile) {
            this.isMobile = isMobile;
            return this;
        }

        public Builder hasTouch(boolean hasTouch) {
            this.hasTouch = hasTouch;
            return this;
        }

        public Builder isLandscape(boolean isLandscape) {
            this.isLandscape = isLandscape;
            return this;
        }

        public Builder userAgent(String userAgent) {
            this.userAgent = userAgent;
            return this;
        }

        public Builder acceptLanguage(String acceptLanguage) {
            this.acceptLanguage = acceptLanguage;
            return this;
        }

        public Builder platform(String platform) {
            this.platform = platform;
            return this;
        }

        public Emulator build() {
            if (width <= 0) {
                throw new RuntimeException("error : width <= 0");
            }
            if (height <= 0) {
                throw new RuntimeException("error : height <= 0");
            }
            if (deviceScaleFactor <= 0) {
                throw new RuntimeException("error : deviceScaleFactor <= 0");
            }
            if (userAgent == null || userAgent.length() == 0) {
                throw new RuntimeException("error : userAgent empty");
            }
            return new Emulator(new Viewport(width, height, deviceScaleFactor, isMobile, hasTouch, isLandscape), new UserAgent(userAgent, acceptLanguage, platform));
        }
    }

    public static final Emulator IPHONEX = newBuilder().width(375).height(812).deviceScaleFactor(3).isMobile(true).hasTouch(true).isLandscape(false).userAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 12_0 like Mac OS X) AppleWebKit/604.1.38 (KHTML, like Gecko) Version/12.0 Mobile/15A372 Safari/604.1").build();
}
