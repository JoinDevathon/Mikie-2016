package org.devathon.contest2016;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Guardian;
import org.bukkit.entity.Player;
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

        if(e.getAction() == Action.LEFT_CLICK_AIR || !e.getPlayer().getItemInHand().getType().equals(Material.BLAZE_ROD)){
            e.setCancelled(true);
        }


        Guardian g = (Guardian) p.getWorld().spawnEntity(p.getLocation(), EntityType.GUARDIAN);
        g.setGravity(false);
        g.setGlowing(false);
        g.getLeashHolder().equals(Material.BLAZE_ROD);
        p.sendMessage("I hope this works");

    }
}

