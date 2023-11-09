package paw.faux.fx.mixin;

import net.minecraft.network.packet.s2c.play.ServerMetadataS2CPacket;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import paw.faux.fx.Fx;

@Mixin(ServerMetadataS2CPacket.class)
public class ServerMetadataPacketMixin {
	@Final
	@Shadow
	private boolean secureChatEnforced;

	@Inject(method = "isSecureChatEnforced" , at = @At("RETURN"), cancellable = true)
	public void onGetServerSecureChat(CallbackInfoReturnable<Boolean> cir) {
		cir.setReturnValue(secureChatEnforced || Fx.Attributes.Server.EnforcesSecureChat);
	}
}
