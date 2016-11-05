package org.devathon.contest2016;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Guardian;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * Created by Michael on 11/5/2016.
 */
public class PlayerInteract implements Listener {

    @EventHandler

    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();

     Action action = e.getAction();
        if(e.getAction() == Action.LEFT_CLICK_AIR)
            e.setCancelled(true);

        if (p.getItemInHand().getType().equals(Material.BLAZE_ROD))
            return;

        Guardian g = (Guardian) p.getWorld().spawnEntity(p.getLocation(), EntityType.GUARDIAN);
        g.setGravity(false);

    }
}

