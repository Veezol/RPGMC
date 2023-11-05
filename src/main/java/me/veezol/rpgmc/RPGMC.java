package me.veezol.rpgmc;

import me.veezol.rpgmc.config.MainConfig;
import me.veezol.rpgmc.data.PlayerData;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class RPGMC extends JavaPlugin {

    private MainConfig mainConfig;
    private PlayerData playerData;
    private final Logger logger = getLogger();

    @Override
    public void onEnable() {
        mainConfig = new MainConfig();
        playerData = new PlayerData();
        playerData.connect(mainConfig.getDatabaseUsername(),
                mainConfig.getDatabasePassword(),
                mainConfig.getDatabaseURI());
        logger.info("The plugin is enabled.");
    }

    @Override
    public void onDisable() {
        mainConfig.save();
        playerData.close();
        logger.info("The plugin is disabled");
    }

    public MainConfig getMainConfig() {
        return mainConfig;
    }
}
