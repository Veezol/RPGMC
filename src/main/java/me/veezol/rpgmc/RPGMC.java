package me.veezol.rpgmc;

import me.veezol.rpgmc.config.MainConfig;
import me.veezol.rpgmc.data.Database;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class RPGMC extends JavaPlugin {

    private MainConfig mainConfig;
    private Database database;
    private final Logger logger = getLogger();

    @Override
    public void onEnable() {
        mainConfig = new MainConfig();
        database = Database.getDatabase(mainConfig);
        if (!database.connect()) {
            logger.info("Disabling RPGMC...");
            Bukkit.getServer().getPluginManager().disablePlugin(this);
            return;
        }
        logger.info("The plugin is enabled.");
    }

    @Override
    public void onDisable() {
        mainConfig.save();
        database.close();
        logger.info("The plugin is disabled");
    }

    public MainConfig getMainConfig() {
        return mainConfig;
    }
}
