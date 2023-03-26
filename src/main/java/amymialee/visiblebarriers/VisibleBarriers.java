package amymialee.visiblebarriers;

import net.fabricmc.api.ModInitializer;

public class VisibleBarriers implements ModInitializer {
    public final static String MOD_ID = "visiblebarriers";
    protected static boolean visible = false;
    protected static boolean visibleAir = false;

    @Override
    public void onInitialize() {}

    public static boolean isVisible() {
        return visible;
    }

    public static boolean isVisibleAir() {
        return visibleAir;
    }
}