package org.devathon.contest2016;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class DevathonPlugin extends JavaPlugin {


    @Override
    public void onEnable() {
        Bukkit.getPluginManager().getPlugin("DevathonPlugin");
        Bukkit.getPluginManager().registerEvents(new PlayerInteract(this), this);
        Bukkit.getPluginManager().registerEvents(new EntityDamage(), this);
        Bukkit.getPluginManager().registerEvents(new ChuckLoad(), this);

    }

    @Override
    public void onDisable() {
        //c
    }
}

