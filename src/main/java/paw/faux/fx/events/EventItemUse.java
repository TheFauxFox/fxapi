package paw.faux.fx.events;

import paw.faux.fx.abstracts.CancellableEvent;
import paw.faux.fx.abstracts.Event;

public class EventItemUse {
    public static class PRE extends CancellableEvent {}
    public static class POST extends Event {}
}
