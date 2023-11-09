package paw.faux.fx.utils;

import net.minecraft.client.MinecraftClient;
import net.minecraft.network.packet.Packet;
import paw.faux.fx.mixin.ClientConnectionAccessor;

public class PacketUtil {
    public static void sendPacketNow(Packet<?> packet) {
        if (MinecraftClient.getInstance().player != null) {
            ((ClientConnectionAccessor) MinecraftClient.getInstance().player.networkHandler.getConnection()).callSendImmediately(packet, null, true);
        }
    }
}
