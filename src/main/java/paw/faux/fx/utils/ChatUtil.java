package paw.faux.fx.utils;

import net.minecraft.client.MinecraftClient;

public class ChatUtil {
    public static void sendChatMessage(String msg, Object ...args) {
        MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(StringUtil.formatText(msg, args));
    }

    public static void sendActionBarMessage(String msg, Object ...args) {
        MinecraftClient.getInstance().inGameHud.setOverlayMessage(StringUtil.formatText(msg, args), false);
    }

}
