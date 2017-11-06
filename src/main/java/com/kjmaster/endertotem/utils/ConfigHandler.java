package com.kjmaster.endertotem.utils;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigHandler {
    public static Configuration config;

    public static boolean chaosGuardianEnabled;

    public static void init(File file) {
        config = new Configuration(file);
        syncConfig();
    }

    private static void syncConfig() {
        String category = "Draconic Evolution";
        config.addCustomCategoryComment(category, "Draconic Evolution Settings");
        chaosGuardianEnabled = config.getBoolean("chaosGuardianEnabled", category, true,
                "Set to false to prevent ender totem from affecting chaos guardians");
        config.save();
    }
}
