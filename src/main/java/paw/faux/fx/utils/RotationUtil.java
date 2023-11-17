package paw.faux.fx.utils;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.command.argument.EntityAnchorArgumentType;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import paw.faux.fx.abstracts.Rotations;

public class RotationUtil {
    public static Vec3d getEyesPos() {
        if (MinecraftClient.getInstance().player == null) return Vec3d.ZERO;
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        return new Vec3d(player.getX(), player.getY() + player.getEyeHeight(player.getPose()), player.getZ());
    }

    public static Rotations getNeededRotations(EntityAnchorArgumentType.EntityAnchor anchorPoint, Entity entity) {
        return getNeededRotations(anchorPoint.positionAt(entity));
    }

    public static Rotations getNeededRotations(Vec3d target) {
        Vec3d vec3d = getEyesPos();
        double d = target.x - vec3d.x;
        double e = target.y - vec3d.y;
        double f = target.z - vec3d.z;
        double g = Math.sqrt(d * d + f * f);
        return new Rotations(
                MathHelper.wrapDegrees((float)(MathHelper.atan2(f, d) * 57.2957763671875) - 90.0F),
                MathHelper.wrapDegrees((float)(-(MathHelper.atan2(e, g) * 57.2957763671875)))
        );
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

    public static float slowlyTurnTowards(float current, float target, float speed) {
        float angularDifference = NumberUtil.wrap((target - current + 180.0f) % 360.0f - 180.0f, -180, 180);
        float maxChange = MathHelper.clamp(angularDifference, -speed, speed);
        return current + maxChange;
    }

    public static Rotations getNextSlowRotation(Rotations current, Rotations target, float speed) {
        return new Rotations(
                slowlyTurnTowards(current.yaw(), target.yaw(), speed),
                slowlyTurnTowards(current.pitch(), target.pitch(), speed)
        );
    }
}
