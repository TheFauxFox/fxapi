package paw.faux.fx.mixin;

import net.minecraft.client.render.LightmapTextureManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import paw.faux.fx.Fx;

@Mixin(LightmapTextureManager.class)
public class LightmapTextureManagerMixin {
	@Inject(method = "getBrightness", at = @At("HEAD"), cancellable = true)
	private static void onGetBrightness(CallbackInfoReturnable<Float> cir) {
		if (Fx.Attributes.World.Brightness != -1) cir.setReturnValue(Fx.Attributes.World.Brightness);
	}
}
