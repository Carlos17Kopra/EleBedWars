//CopyRight at Carlos17Kopra | Arvid

package de.elementalcraft.util.playermanagement;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;
import java.util.List;

public class PlayerManager implements Listener {

    //liste aller PPlayers, die online sind
    static List<PreparedPlayer> players = new ArrayList<>();


    //Handling für eine aktuelle PPlayer-Liste
    @EventHandler
    public void join(PlayerJoinEvent e){
        players.add(new PreparedPlayer(e.getPlayer()));
    }
    @EventHandler
    public void quit(PlayerQuitEvent e){
        players.remove(new PreparedPlayer(e.getPlayer()));
    }

}
