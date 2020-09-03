//CopyRight at Carlos17Kopra | Arvid

package de.elementalcraft.listener;

import de.elementalcraft.util.playermanagement.PreparedPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class SuperListener implements Listener {

    //Buildmode

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e){

        PreparedPlayer pp = new PreparedPlayer(e.getPlayer());
        if(!pp.canBuild()){
            e.setCancelled(true);
        }

    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e){

        PreparedPlayer pp = new PreparedPlayer(e.getPlayer());
        if(!pp.canBuild()){
            e.setCancelled(true);
        }

    }

}
