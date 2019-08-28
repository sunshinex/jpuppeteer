package jpuppeteer.httpclient.condition;

import com.google.common.collect.ImmutableSet;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

public final class PathsRequestCondition extends AbstractRequestCondition<PathsRequestCondition> {

    private static final Logger logger = LoggerFactory.getLogger(PathsRequestCondition.class);

    private final Set<String> hosts;

    private final Set<String> paths;

    public PathsRequestCondition(String[] hosts, String[] paths) {
        this.hosts = ImmutableSet.copyOf(hosts);
        this.paths = ImmutableSet.copyOf(paths);
    }

    public Set<String> getHosts() {
        return hosts;
    }

    public Set<String> getPaths() {
        return paths;
    }

    @Override
    protected Collection<String> getContent() {
        return this.paths;
    }

    @Override
    protected String getToStringInfix() {
        return " || ";
    }

    @Override
    public boolean match(HttpRequestInfo request) {
        URI uri = request.getURI();
        if (uri == null) {
            return false;
        }
        if (!hosts.contains(uri.getHost())) {
            return false;
        }
        if (CollectionUtils.isNotEmpty(paths) && !paths.contains(uri.getPath())) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(PathsRequestCondition other) {
        return this.paths.size() - other.paths.size();
    }

}
