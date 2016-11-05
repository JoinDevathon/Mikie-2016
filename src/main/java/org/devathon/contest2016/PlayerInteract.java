package org.devathon.contest2016;

import com.sun.openpisces.Dasher;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * Created by Michael on 11/5/2016.
 */
public class PlayerInteract implements Listener {

    @EventHandler

    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();

        e.hasItem();
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
        g.setAI(true);
        b.launchProjectile(Fireball.class);
        p.sendMessage("I hope this works");

    }
}


