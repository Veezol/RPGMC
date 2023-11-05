package me.veezol.rpgmc;

import me.veezol.rpgmc.config.PluginConfig;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class RPGMC extends JavaPlugin {

    private PluginConfig config;
    private final Logger logger = getLogger();

    @Override
    public void onEnable() {
        config = new PluginConfig(this);
        logger.info(  "The plugin is enabled.");
    }

    @Override
    public void onDisable() {
        config.save();
        logger.info("The plugin is disabled");
    }
}
