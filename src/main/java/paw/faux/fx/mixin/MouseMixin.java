package paw.faux.fx.mixin;

import net.minecraft.client.Mouse;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import paw.faux.fx.Fx;
import paw.faux.fx.events.EventMouseScroll;

@Mixin(Mouse.class)
public abstract class MouseMixin {

    @Shadow
    private double eventDeltaVerticalWheel;

    @Inject(method = "onMouseScroll", at = @At(value = "FIELD", target = "Lnet/minecraft/client/Mouse;eventDeltaVerticalWheel:D", ordinal = 7), cancellable = true)
    private void onMouseScroll(CallbackInfo ci) {
        if (eventDeltaVerticalWheel != 0.0) {
            if (Fx.EVENT_BUS.post(new EventMouseScroll(eventDeltaVerticalWheel)).isCancelled()) ci.cancel();
        }
    }
}
