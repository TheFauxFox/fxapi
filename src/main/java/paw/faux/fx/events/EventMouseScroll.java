package paw.faux.fx.events;

import paw.faux.fx.abstracts.CancellableEvent;

public class EventMouseScroll extends CancellableEvent {
    public double eventDeltaWheel;
    public EventMouseScroll(double eventDeltaWheel) {
        this.eventDeltaWheel = eventDeltaWheel;
    }
}
