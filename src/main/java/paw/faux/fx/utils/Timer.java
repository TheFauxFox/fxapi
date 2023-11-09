package paw.faux.fx.utils;

public class Timer {
    private long startTime;

    public Timer() {
        startTime = getCurrentTime();
    }

    private long getCurrentTime() {
        return System.currentTimeMillis();
    }

    public void reset() {
        this.startTime = getCurrentTime();
    }

    public boolean hasElapsed(int ms) {
        return getCurrentTime() - this.startTime  >= ms;
    }

    public long getElapsed() {
        return getCurrentTime() - this.startTime;
    }
}
