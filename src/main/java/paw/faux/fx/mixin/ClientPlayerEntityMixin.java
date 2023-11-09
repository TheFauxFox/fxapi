package paw.faux.fx.mixin;

import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import paw.faux.fx.Fx;
import paw.faux.fx.events.EventPlayerMove;

@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin {
	@Inject(method = "move", at = @At("HEAD"), cancellable = true)
	public void onPlayerMove(MovementType movementType, Vec3d movement, CallbackInfo ci) {
		if (Fx.EVENT_BUS.post(new EventPlayerMove(movementType, movement)).isCancelled()) ci.cancel();
	}
}
