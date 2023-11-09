package paw.faux.fx.utils;

public class NumberUtil {
    public static double percent(double min, double max, double perc) {
        return min + ((max - min) * perc);
    }

    public static float percent(float min, float max, double perc) {
        return (float) percent(min, (double) max, perc);
    }

    public static int percent(int min, int max, double perc) {
        return (int) percent(min, (double) max, perc);
    }

    public static float wrap(float value, float min, float max) {
        float intermed = value;
        if (value > max) {
            intermed = min + (value - max);
        } else if (value < min) {
            intermed = max - (min - value);
        }
        return intermed;
    }

    public static double roundToPlaces(double val, int numPlaces) {
        return Math.round(val * Math.pow(10, numPlaces)) / Math.pow(10, numPlaces);
    }
}
