package pl.michalek.marcin.nfcdrinkerserver.config;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Marcin on 2015-01-04.
 */
public final class DrinkingConstants {
    private DrinkingConstants() {
    }

    public static final double ALCOHOL_DENSITY_GRAM_PER_MILLILITER = 0.79;
    public static Map<String, Double> WATER_IN_BODY_PERCENTAGE;

    static {
        WATER_IN_BODY_PERCENTAGE = new HashMap<String, Double>();
        WATER_IN_BODY_PERCENTAGE.put("MALE", 0.6);
        WATER_IN_BODY_PERCENTAGE.put("FEMALE", 0.7);
    }
}
