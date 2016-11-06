package org.devathon.contest2016;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class DevathonPlugin extends JavaPlugin {


    @Override
    public void onEnable() {
        Bukkit.getPluginManager().getPlugin("DevathonPlugin");
        Bukkit.getPluginManager().registerEvents(new EntityDamage(), this);
        getCommand("test").setExecutor(new TestCommand(this));
    }


    @Override
    public void onDisable() {
        this.getLogger().info("Machine Has been disabled");
    }
}

