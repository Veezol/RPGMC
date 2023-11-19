package me.veezol.rpgmc.config;

import me.veezol.rpgmc.RPGMC;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Locale;

/*
 * This class reads the main config
 */
public class MainConfig {

    private final JavaPlugin plugin = RPGMC.getPlugin(RPGMC.class);

    public MainConfig() {
        plugin.saveDefaultConfig(); // Save a copy of the default config if one is not present
    }

    public boolean mongoDBEnabled() {
        String database = plugin.getConfig().getString("database");
        return database != null && database.toLowerCase(Locale.ENGLISH).contains("mongodb");
    }

    public String mongoDBUsername() {
        return plugin.getConfig().getString("mongodb.username");
    }

    public String mongoDBPassword() {
        return plugin.getConfig().getString("mongodb.password");
    }

    public String mongoDBURI() {
        return plugin.getConfig().getString("mongodb.uri");
    }

    public String mongoDatabaseName() {
        return plugin.getConfig().getString("mongodb.database");
    }

    public void save() {
        plugin.reloadConfig(); // First reload the config file
        plugin.saveConfig(); // Then save it
    }


}
