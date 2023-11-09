package paw.faux.fx.events;

import net.minecraft.util.math.Vec3d;
import paw.faux.fx.abstracts.CancellableEvent;

public class EventPlayerTravel extends CancellableEvent {
    public Vec3d movmentInput;
    public EventPlayerTravel(Vec3d movementInput) {
        this.movmentInput = movementInput;
    }
}
