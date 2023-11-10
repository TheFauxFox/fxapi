package paw.faux.fx.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import paw.faux.fx.Fx;
import paw.faux.fx.events.*;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
	@Inject(method = "handleInputEvents", at = @At("HEAD"), cancellable = true)
	public void handleInputEvents(CallbackInfo ci) {
		if (Fx.EVENT_BUS.post(new EventKeyPress()).isCancelled()) ci.cancel();
	}

	@Inject(method = "<init>(Lnet/minecraft/client/RunArgs;)V", at = @At("TAIL"))
	public void onClientInit(CallbackInfo ci) {
		Fx.EVENT_BUS.post(new EventClientInit());
	}

	@Inject(method = "tick", at = @At("HEAD"))
	public void onClientTick(CallbackInfo ci) {
		Fx.EVENT_BUS.post(new EventClientTick());
	}

	@Inject(method = "joinWorld", at = @At("TAIL"))
	public void onGameJoin(ClientWorld world, CallbackInfo ci) {
		Fx.EVENT_BUS.post(new EventJoinWorld(world));
	}

	@Inject(method = "disconnect()V", at = @At("HEAD"))
	public void onGameQuit(CallbackInfo ci) {
		Fx.EVENT_BUS.post(new EventLeaveWorld());
	}

	@Inject(method = "handleBlockBreaking", at = @At("HEAD"), cancellable = true)
	public void onBlockBreak(boolean breaking, CallbackInfo ci) {
		if (Fx.EVENT_BUS.post(new EventBlockBreaking(breaking).isCancelled())) ci.cancel();
	}

	@Inject(method = "doAttack", at = @At("HEAD"), cancellable = true)
	public void onDoAttackPre(CallbackInfoReturnable<Boolean> cir) {
		if (Fx.EVENT_BUS.post(new EventAttack.PRE()).isCancelled()) cir.setReturnValue(false);
	}

	@Inject(method = "doAttack", at = @At("RETURN"))
	public void onDoAttackPost(CallbackInfoReturnable<Boolean> cir)	{
		Fx.EVENT_BUS.post(new EventAttack.POST());
	}

	@Inject(method = "doItemUse", at = @At("HEAD"), cancellable = true)
	private void onDoItemUsePre(CallbackInfo ci) {
		if (Fx.EVENT_BUS.post(new EventItemUse.PRE()).isCancelled()) ci.cancel();
	}

	@Inject(method = "doItemUse", at = @At("TAIL"))
	private void onDoItemUsePost(CallbackInfo ci) {
		Fx.EVENT_BUS.post(new EventItemUse.POST());
	}
}
