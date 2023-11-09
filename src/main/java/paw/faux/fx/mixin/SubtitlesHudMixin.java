package paw.faux.fx.mixin;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.SubtitlesHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import paw.faux.fx.Fx;
import paw.faux.fx.events.EventRender2d;

@Mixin(SubtitlesHud.class)
public class SubtitlesHudMixin {
	@Inject(method = "render", at = @At("HEAD"))
	public void onTextGuiRender(DrawContext context, CallbackInfo ci) {
		Fx.EVENT_BUS.post(new EventRender2d(context));
	}
}
