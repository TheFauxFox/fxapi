package paw.faux.fx.utils;

import net.minecraft.util.math.MathHelper;

public class Color {
    public static Color DARK_RED = Color.rgb(170, 0, 0);
    public static Color RED = Color.rgb(255, 85, 85);
    public static Color GOLD = Color.rgb(255, 170, 0);
    public static Color YELLOW = Color.rgb(255, 255, 85);
    public static Color DARK_GREEN = Color.rgb(0, 170, 0);
    public static Color GREEN = Color.rgb(85, 255, 85);
    public static Color AQUA = Color.rgb(85, 255, 255);
    public static Color DARK_AQUA = Color.rgb(0, 170, 170);
    public static Color DARK_BLUE = Color.rgb(0, 0, 170);
    public static Color BLUE = Color.rgb(85, 85, 255);
    public static Color LIGHT_PURPLE = Color.rgb(255, 85, 255);
    public static Color DARK_PURPLE = Color.rgb(170, 0, 170);
    public static Color WHITE = Color.rgb(255, 255, 255);
    public static Color GRAY = Color.rgb(170, 170, 170);
    public static Color DARK_GRAY = Color.rgb(85, 85, 85);
    public static Color BLACK = Color.rgb(0, 0, 0);

    public final int red, green, blue, alpha, asInt;
    public final String asHex;

    private Color(int red, int green, int blue, int alpha) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
        this.asInt = (this.alpha << 24) + (this.blue << 16) + (this.green << 8) + this.red;
        this.asHex = String.format("%02X%02X%02X", this.red, this.blue, this.green);
    }

    public static Color rgb(int r, int g, int b) {
        return Color.rgba(r, g, b, 255);
    }

    public static Color rgba(int r, int g, int b, int a) {
        return new Color(r, g, b, a);
    }

    public static int rainbow(float offset)
    {
        float x = System.currentTimeMillis() % 2000 / 1000F;
        x = NumberUtil.wrap(x + offset, 0.001f, 1.999f);
        float pi = (float)Math.PI;

        float r = 0.5F + 0.5F * MathHelper.sin(x * pi);
        float g = 0.5F + 0.5F * MathHelper.sin((x + 4F / 3F) * pi);
        float b = 0.5F + 0.5F * MathHelper.sin((x + 8F / 3F) * pi);

        return MathHelper.clamp((int)(r * 255), 0, 255) << 16 | MathHelper.clamp((int)(g * 255), 0, 255) << 8 | MathHelper.clamp((int)(b * 255), 0, 255);
    }
}
