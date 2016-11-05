package org.devathon.contest2016;

import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * Created by Michael on 11/5/2016.
 */
public class PlayerInteract implements Listener {

    @EventHandler

    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();

        if(e.getAction() == Action.LEFT_CLICK_AIR || !e.getPlayer().getItemInHand().getType().equals(Material.BLAZE_ROD)){
            e.setCancelled(true);
        }
        Guardian g = (Guardian) p.getWorld().spawnEntity(p.getLocation(), EntityType.GUARDIAN);
        Bat b = (Bat) p.getWorld().spawnEntity(p.getLocation(), EntityType.BAT);
        ArmorStand a = (ArmorStand) p.getWorld().spawnEntity(p.getLocation(), EntityType.ARMOR_STAND);
        a.setVisible(true);
        b.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 1, true, false));
        b.setPassenger(a);
        b.setGravity(true);
        a.setGravity(false);
        a.setPassenger(g);
        g.setGravity(false);
        p.sendMessage("I hope this works");

    }
}

