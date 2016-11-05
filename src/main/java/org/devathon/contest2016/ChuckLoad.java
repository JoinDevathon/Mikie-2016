package org.devathon.contest2016;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkUnloadEvent;

import java.util.List;

/**
 * Created by Michael on 11/5/2016.
 */
public class ChuckLoad implements Listener {
    @EventHandler
    public void onChunkLoad(ChunkUnloadEvent e)
    {
        e.setCancelled(true);
    }
}
