package org.devathon.contest2016;

import net.minecraft.server.v1_10_R1.Material;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_10_R1.entity.CraftLivingEntity;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static org.bukkit.event.block.Action.LEFT_CLICK_BLOCK;

/**
 * Created by Michael on 11/5/2016.
 */
public class PlayerInteract implements Listener {

    public DevathonPlugin plugin;

    public PlayerInteract(DevathonPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler

    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();

        if (e.getAction() == Action.LEFT_CLICK_BLOCK) {
            e.setCancelled(true);
        }
        Guardian g = (Guardian) p.getWorld().spawnEntity(p.getLocation().add(0, 5, 2), EntityType.GUARDIAN);
        Bat b = (Bat) p.getWorld().spawnEntity(p.getLocation().add(0, 5, 2), EntityType.BAT);
        ArmorStand a = (ArmorStand) p.getWorld().spawnEntity(p.getLocation().add(0, 5, 2), EntityType.ARMOR_STAND);
        a.setVisible(true);
        b.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 1, true, false));
        b.setPassenger(a);
        b.setGravity(true);
        a.setGravity(false);
        a.setPassenger(g);
        g.setGravity(false);
        b.setMaxHealth(Integer.MAX_VALUE);
        g.setMaxHealth(Integer.MAX_VALUE);
        g.setRemoveWhenFarAway(false);
        b.setRemoveWhenFarAway(false);
        a.setRemoveWhenFarAway(false);
        g.setRemainingAir(Integer.MAX_VALUE);
        b.setRemainingAir(Integer.MAX_VALUE);
        a.setRemainingAir(Integer.MAX_VALUE);
        g.getRemoveWhenFarAway();
        g.setAI(true);
        p.sendMessage("I hope this works");

        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            @Override
            public void run() {
                DragonFireball fb = a.launchProjectile(DragonFireball.class);
                fb.setIsIncendiary(false);
                fb.setYield(0);
            }
        }, 0, 20 * 10);

    }
}





