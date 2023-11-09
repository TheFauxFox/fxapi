package paw.faux.fx.events;

import net.minecraft.world.World;
import paw.faux.fx.abstracts.Event;

public class EventJoinWorld extends Event {
    public World world;
    public EventJoinWorld(World world) {
        this.world = world;
    }
}
