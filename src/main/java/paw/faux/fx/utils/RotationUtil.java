package paw.faux.fx.utils;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import paw.faux.fx.abstracts.Rotations;

public class RotationUtil {
    public static Vec3d getEyesPos() {
        if (MinecraftClient.getInstance().player == null) return Vec3d.ZERO;
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        return new Vec3d(player.getX(), player.getY() + player.getEyeHeight(player.getPose()), player.getZ());
    }

    public static Rotations getNeededRotations(Vec3d vec) {
        Vec3d eyesPos = getEyesPos();
        double diffX = vec.x - eyesPos.x;
        double diffY = vec.y - eyesPos.y;
        double diffZ = vec.z - eyesPos.z;
        double diffXZ = Math.sqrt(diffX * diffX + diffZ * diffZ);
        float yaw = (float)Math.toDegrees(Math.atan2(diffZ, diffX)) - 90.0f;
        float pitch = (float)(-Math.toDegrees(Math.atan2(diffY, diffXZ)));
        return new Rotations(yaw, pitch);
    }

    public static double getAngleToLookVec(Vec3d vec) {
        if (MinecraftClient.getInstance().player == null) return 0;
        Rotations needed = getNeededRotations(vec);
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        float currentYaw = MathHelper.wrapDegrees(player.getYaw());
        float currentPitch = MathHelper.wrapDegrees(player.getPitch());
        float diffYaw = currentYaw - needed.yaw();
        float diffPitch = currentPitch - needed.pitch();
        return Math.sqrt(diffYaw * diffYaw + diffPitch * diffPitch);
    }

    private double normalizeAngle(double angle) {
        return (angle + 360) % 360;
    }
}
