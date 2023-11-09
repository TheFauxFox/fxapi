package paw.faux.fx.events;

import paw.faux.fx.abstracts.CancellableEvent;

public class EventBlockBreaking extends CancellableEvent {
    public boolean breaking;
    public EventBlockBreaking(boolean breaking) {
        this.breaking = breaking;
    }
}
