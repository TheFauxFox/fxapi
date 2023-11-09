package paw.faux.fx.events;

import net.minecraft.client.util.math.MatrixStack;
import paw.faux.fx.abstracts.Event;

public class EventRender3d extends Event {
    public float partialTicks;
    public long finishTimeNano;
    public MatrixStack matrixStack;

    public EventRender3d(float partialTicks, long finishTimeNano, MatrixStack matrixStack) {
        this.partialTicks = partialTicks;
        this.finishTimeNano = finishTimeNano;
        this.matrixStack = matrixStack;
    }
}
