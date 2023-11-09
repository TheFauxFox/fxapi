package paw.faux.fx.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import paw.faux.fx.Fx;
import paw.faux.fx.events.EventPlayerTravel;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {
	@Inject(method = "travel", at = @At("HEAD"), cancellable = true)
	public void onTravel(Vec3d movementInput, CallbackInfo ci) {
		if (Fx.EVENT_BUS.post(new EventPlayerTravel(movementInput)).isCancelled()) {
			ci.cancel();
		}
	}
}
