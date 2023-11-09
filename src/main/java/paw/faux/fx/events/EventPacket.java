package paw.faux.fx.events;

import net.minecraft.network.packet.Packet;
import paw.faux.fx.abstracts.CancellableEvent;

public class EventPacket extends CancellableEvent {
    public Packet<?> packet;
    public EventPacket(Packet<?> packet) {
        this.packet = packet;
    }

    public static class C2S extends EventPacket {
        public C2S(Packet<?> packet) {
            super(packet);
        }
    }

    public static class S2C extends EventPacket {
        public S2C(Packet<?> packet) {
            super(packet);
        }
    }
}
