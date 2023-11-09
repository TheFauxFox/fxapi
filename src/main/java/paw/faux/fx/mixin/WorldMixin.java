package paw.faux.fx.mixin;

import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldProperties;
import net.minecraft.world.dimension.DimensionType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import paw.faux.fx.Fx;

@Mixin(World.class)
public abstract class WorldMixin implements WorldAccess {
    @Shadow public abstract WorldProperties getLevelProperties();

    @Shadow public abstract DimensionType getDimension();

    @Inject(method = "getRainGradient", at = @At("HEAD"), cancellable = true)
    public void onGetRainGradient(float f, CallbackInfoReturnable<Float> cir) {
        if (Fx.Attributes.World.HideRain) cir.setReturnValue(0f);
    }

    @Override
    public float getSkyAngle(float tickDelta) {
        long timeOfDay = getLevelProperties().getTimeOfDay();
        timeOfDay = Fx.Attributes.World.TimeLock != -1 ? Fx.Attributes.World.TimeLock : timeOfDay;
        return getDimension().getSkyAngle(timeOfDay);
    }

    @Override
    public int getMoonPhase() {
        int phase = getDimension().getMoonPhase(getLunarTime());
        phase = Fx.Attributes.World.MoonPhase != -1 ? Fx.Attributes.World.MoonPhase : phase;
        return phase;
    }
}
