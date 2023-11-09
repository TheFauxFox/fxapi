package paw.faux.fx.mixin;

import net.minecraft.block.AbstractBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import paw.faux.fx.Fx;

@Mixin(AbstractBlock.AbstractBlockState.class)
public class AbstractBlockStateMixin {
	@Inject(method = { "getAmbientOcclusionLightLevel" }, at = { @At("TAIL") }, cancellable = true)
	public void onGetAmbientOcclusionLightLevel(BlockView blockView, BlockPos blockPos, CallbackInfoReturnable<Float> cir) {
		if (Fx.Attributes.World.AmbientOcclusionBrightness != -1) cir.setReturnValue(Fx.Attributes.World.AmbientOcclusionBrightness);
	}
}
