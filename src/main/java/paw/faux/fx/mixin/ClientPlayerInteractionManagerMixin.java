package paw.faux.fx.mixin;

import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import paw.faux.fx.Fx;
import paw.faux.fx.events.EventAttackEntity;

@Mixin(ClientPlayerInteractionManager.class)
public class ClientPlayerInteractionManagerMixin {
    @Inject(method = "getReachDistance", at = @At("RETURN"), cancellable = true)
    private void onGetReachDistance(CallbackInfoReturnable<Float> cir) {
		if (Fx.Attributes.Player.ReachDistance != 4.5) cir.setReturnValue(Fx.Attributes.Player.ReachDistance);
    }

    @Inject(method = "hasExtendedReach", at = @At("RETURN"), cancellable = true)
    private void onHasExtendedReach(CallbackInfoReturnable<Boolean> cir) {
		if (Fx.Attributes.Player.ReachDistance > 4.5) cir.setReturnValue(true);
    }

    @Inject(method = "attackEntity", at = @At(value = "HEAD"), cancellable = true)
    private void onPreAttack(PlayerEntity player, Entity target, CallbackInfo ci) {
        if (Fx.EVENT_BUS.post(new EventAttackEntity.PRE(player, target)).isCancelled()) ci.cancel();
    }

    @Inject(method = "attackEntity", at = @At(value = "TAIL"))
    private void onPostAttack(PlayerEntity player, Entity target, CallbackInfo ci) {
        Fx.EVENT_BUS.post(new EventAttackEntity.POST(player, target));
    }
}

