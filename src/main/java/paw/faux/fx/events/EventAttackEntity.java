package paw.faux.fx.events;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import paw.faux.fx.abstracts.CancellableEvent;
import paw.faux.fx.abstracts.Event;

public class EventAttackEntity {
    public static class PRE extends CancellableEvent {
        public PlayerEntity player;
        public Entity entity;

        public PRE(PlayerEntity player, Entity entity) {
            this.player = player;
            this.entity = entity;
        }
    }

    public static class POST extends Event {
        public PlayerEntity player;
        public Entity entity;

        public POST(PlayerEntity player, Entity entity) {
            this.player = player;
            this.entity = entity;
        }
    }
}
