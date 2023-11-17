package paw.faux.fx.utils;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

import org.apache.logging.log4j.message.FormattedMessage;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class StringUtil {
    public static String colorSym = "§";

    public static String color(String s) {
        return s.replaceAll("(?<!&)&", colorSym);
    }

    public static String uncolor(String s) {
        return s.replaceAll(colorSym, "&");
    }

    public static int len(String s) {
        return MinecraftClient.getInstance().textRenderer.getWidth(uncolor(s).replaceAll("(&\\w|&#\\w{6})", ""));
    }

    public static String title(String s) {
        StringBuilder builder = new StringBuilder();
        for (String seg: s.split(" ")) {
            char firstChar = seg.toUpperCase().charAt(0);
            String rest = seg.toLowerCase();
            builder.append(firstChar).append(rest.substring(1));
        }
        return builder.toString();
    }

    public static String format(String s, Object ...args) {
        return new FormattedMessage(s, args).getFormattedMessage();
    }

    public static Text formatText(String s, Object ...args) {
        return Text.of(color(format(s, args)));
    }

    public static <T extends Enum<T>> List<String> enumStringList(T[] enumValues) {
        List<String> arr = new ArrayList<>();
        for (T val: enumValues) {
            arr.add(val.name());
        }
        return arr;
    }
}
