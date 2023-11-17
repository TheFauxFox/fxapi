package paw.faux.fx.utils;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class NumberUtil {
    public static double percent(double min, double max, double perc) {
        return min + ((max - min) * perc);
    }

    public static float percent(float min, float max, double perc) {
        return (float) percent(min, (double) max, perc);
    }

    public static int percent(int min, int max, double perc) {
        return (int) percent(min, (double) max, perc);
    }

    public static float wrap(float value, float min, float max) {
        float intermed = value;
        if (value > max) {
            intermed = min + (value - max);
        } else if (value < min) {
            intermed = max - (min - value);
        }
        return intermed;
    }

    public static double roundToPlaces(double val, int numPlaces) {
        return Math.round(val * Math.pow(10, numPlaces)) / Math.pow(10, numPlaces);
    }

    public static float lerp(float delta, float start, float end) {
        return start + delta * ((end - start + 180) % 360 - 180);
    }

    public static Vec3d movementInputToVelocity(Vec3d movementInput, float speed, float yaw) {
        double d = movementInput.lengthSquared();
        Vec3d vec3d = (d > 1.0D ? movementInput.normalize() : movementInput).multiply(speed);
        float f = MathHelper.sin(yaw * 0.017453292F);
        float g = MathHelper.cos(yaw * 0.017453292F);
        return new Vec3d(vec3d.x * (double)g - vec3d.z * (double)f, vec3d.y, vec3d.z * (double)g + vec3d.x * (double)f);
    }
}
