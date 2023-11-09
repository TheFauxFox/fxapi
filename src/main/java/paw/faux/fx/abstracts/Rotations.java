package paw.faux.fx.abstracts;

import net.minecraft.util.math.MathHelper;

public record Rotations(float yaw, float pitch) {
    public Rotations(float yaw, float pitch) {
        this.yaw = MathHelper.wrapDegrees(yaw);
        this.pitch = MathHelper.wrapDegrees(pitch);
    }
}
