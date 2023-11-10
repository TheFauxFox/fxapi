package paw.faux.fx;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import paw.faux.fx.eventbus.EventBus;

public class Fx implements ModInitializer {
    public static EventBus EVENT_BUS = new EventBus();

    public static class Attributes {
        public static class World {
            public static boolean HideRain = false;
            public static long TimeLock = -1;
            public static int MoonPhase = -1;
            public static float Brightness = -1;
            public static float AmbientOcclusionBrightness = -1;
        }
        public static class Server {
            public static boolean EnforcesSecureChat = false;
        }
        public static class Player {
            public static float ReachDistance = 4.5f;
        }
        public static class Mod {
            public static boolean init = false;
            public static String Prefix = "";
        }
    }

    @Override
    public void onInitialize() {

    }
}
