package paw.faux.fx.abstracts;

public abstract class CancellableEvent {
    private boolean cancelled = false;

    public void cancel() {
        cancelled = true;
    }

    public boolean isCancelled() {
        return cancelled;
    }
}
