package paw.faux.fx.events;

import net.minecraft.client.gui.DrawContext;
import paw.faux.fx.abstracts.Event;

public class EventRender2d extends Event {
    public DrawContext context;

    public EventRender2d(DrawContext context) {
        this.context = context;
    }
}
