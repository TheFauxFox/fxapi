package paw.faux.fx.mixin;

import paw.faux.fx.abstracts.CancellableEvent;
import paw.faux.fx.abstracts.Event;

public class EventAttack {
    public static class PRE extends CancellableEvent {}
    public static class POST extends Event {}
}
