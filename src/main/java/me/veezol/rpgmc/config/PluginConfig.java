package me.veezol.rpgmc.config;

import org.bukkit.plugin.java.JavaPlugin;
public class PluginConfig {

    private final JavaPlugin plugin;

    public PluginConfig(JavaPlugin plugin) {
        this.plugin = plugin;
        plugin.saveDefaultConfig(); // Save a copy of the default config if one is not present
    }

    public void save() {
        plugin.saveConfig(); // Save the config file
    }






}
