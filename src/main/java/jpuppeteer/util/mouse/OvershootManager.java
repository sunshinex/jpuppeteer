package jpuppeteer.util.mouse;

import jpuppeteer.entity.Point;

public interface OvershootManager {

    int getOvershoots(Flow flow, long mouseMovementMs, double distance);

    Point getOvershootAmount(double distanceToRealTargetX, double distanceToRealTargetY, long mouseMovementMs, int overshootsRemaining);

    long deriveNextMouseMovementTimeMs(long mouseMovementMs, int overshootsRemaining);

}
