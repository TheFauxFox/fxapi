package paw.faux.fx.utils;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Box;

import java.util.ArrayList;
import java.util.List;

public class EntityUtil {
    public static void fixEntityBB(Entity e) {
        e.setBoundingBox(e.getType().getDimensions().getBoxAt(e.getPos()));
    }

    public static void setEntityBB(Entity e, double size) {
        e.setBoundingBox(e.getType().getDimensions().getBoxAt(e.getPos()).expand(size));
    }

    public static Box getRealEntityBB(Entity e) {
        return e.getType().getDimensions().getBoxAt(e.getPos());
    }

    public static List<LivingEntity> getLivingEntities(double distance) {
        List<LivingEntity> target = new ArrayList<>();
        if (MinecraftClient.getInstance().player == null || MinecraftClient.getInstance().world == null) return target;
        final double rangeSq = Math.pow(distance, 2.0);
        for(Entity e: MinecraftClient.getInstance().world.getEntities()) {
            if (e == null) continue;
            if (e instanceof LivingEntity && !e.isRemoved() && ((LivingEntity) e).getHealth() > 0 && MinecraftClient.getInstance().player.squaredDistanceTo(e) < rangeSq) {
                if (e == MinecraftClient.getInstance().player) continue;
                target.add((LivingEntity) e);
            }
        }
        return target;
    }
}
