package de.flashyboi.minecraft.gammellounge.ipchecker;

import de.flashyboi.minecraft.gammellounge.ipchecker.events.PlayerLogin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class IPChecker extends JavaPlugin {

    private static Logger logger;
    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Loading IPChecker - Version 1.0.0 by flash_btw");
        logger = this.getServer().getLogger();
        Bukkit.getPluginManager().registerEvents(new PlayerLogin(), this);
        Bukkit.getServer().
        getLogger().info("Loaded IPChecker successfully!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Logger getLog() {
        return logger;
    }


}
