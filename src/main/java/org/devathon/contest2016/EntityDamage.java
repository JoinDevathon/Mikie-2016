package org.devathon.contest2016;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

/**
 * Created by Michael on 11/5/2016.
 */
public class EntityDamage implements Listener {

    @EventHandler
    public void EntityDamage(EntityDamageEvent e) {
        Entity entity = e.getEntity();
        if (e.getEntity().getType().equals(EntityType.ARMOR_STAND) || e.getEntity().getType().equals(EntityType.GUARDIAN) || e.getEntity().getType().equals(EntityType.BAT));
        e.setCancelled(true);
    }
}
