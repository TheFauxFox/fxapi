package paw.faux.fx.abstracts;

import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.MathHelper;

public record Rotations(float yaw, float pitch) {
    public Rotations(float yaw, float pitch) {
        this.yaw = MathHelper.wrapDegrees(yaw);
        this.pitch = MathHelper.wrapDegrees(pitch);
    }

    public static Rotations getCurrent() {
        return new Rotations(
                MinecraftClient.getInstance().player.getYaw(),
                MinecraftClient.getInstance().player.getPitch()
        );
    }

    public static Rotations getPrev() {
        return new Rotations(
                MinecraftClient.getInstance().player.prevYaw,
                MinecraftClient.getInstance().player.prevPitch
        );
    }
}
