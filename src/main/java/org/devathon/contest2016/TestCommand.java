package org.devathon.contest2016;

import com.sun.org.apache.xpath.internal.axes.WalkingIterator;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

/**
 * Created by Michael on 11/5/2016.
 */
public class TestCommand implements CommandExecutor {

    public DevathonPlugin plugin;

    public TestCommand(DevathonPlugin plugin) {

        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("test")) {
            Player p = (Player) sender;

            p.sendMessage(ChatColor.RED + "DOES IT WORK!?!?");
            Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
                @Override
                public void run() {
                    Player p = (Player) sender;
                    Location loc = p.getLocation();
                    Wither b = (Wither) p.getWorld().spawnEntity(p.getLocation().add(5, 5, 2), EntityType.WITHER);
                    Guardian g = (Guardian) b.getWorld().spawnEntity(b.getLocation(), EntityType.GUARDIAN);
                    b.getWorld().setSpawnLocation(loc.getBlockY() + 10, 30, 20 + loc.getBlockZ());
                    b.setPassenger(g);
                    b.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 1, true, false));
                    g.setAI(true);
                    g.setGravity(false);
                    g.setRemoveWhenFarAway(false);
                    g.setMaxHealth(Integer.MAX_VALUE);
                    g.setCustomName(ChatColor.RED + "MRMEOW123");
                    g.setCustomNameVisible(true);
                    SmallFireball fb = g.launchProjectile(SmallFireball.class);
                    fb.setIsIncendiary(false);
                    fb.setYield(0);
                }
            }, 0, 2 * 10);

        }
        return true;
    }
}
