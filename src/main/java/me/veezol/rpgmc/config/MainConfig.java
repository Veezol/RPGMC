package me.veezol.rpgmc.config;

import me.veezol.rpgmc.RPGMC;
import org.bukkit.plugin.java.JavaPlugin;
public class MainConfig {

    private final JavaPlugin plugin = RPGMC.getPlugin(RPGMC.class);

    public MainConfig() {
        plugin.saveDefaultConfig(); // Save a copy of the default config if one is not present
    }

    public String getDatabaseUsername() {
        return plugin.getConfig().getString("mongodb.username");
    }

    public String getDatabasePassword() {
        return plugin.getConfig().getString("mongodb.password");
    }

    public String getDatabaseURI() {
        return plugin.getConfig().getString("mongodb.uri");
    }

    public void save() {
        plugin.reloadConfig(); // First reload the config file
        plugin.saveConfig(); // Then save it
    }






}
