package paw.faux.fx.events;

import net.minecraft.entity.MovementType;
import net.minecraft.util.math.Vec3d;
import paw.faux.fx.abstracts.CancellableEvent;

public class EventPlayerMove extends CancellableEvent {
    public MovementType movementType;
    public Vec3d movement;

    public EventPlayerMove(MovementType movementType, Vec3d movement) {
        this.movementType = movementType;
        this.movement = movement;
    }
}
