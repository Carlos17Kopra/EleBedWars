//CopyRight at Carlos17Kopra | Arvid

package de.elementalcraft.listener;

import de.elementalcraft.util.GameManager;
import de.elementalcraft.util.playermanagement.PreparedPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){

        //Default prevent
        e.setCancelled(true);

        //Message holen
        String msg = e.getMessage();
        //PreparedPlayer aus dem e.getPlayer() parsen
        PreparedPlayer pp = new PreparedPlayer(e.getPlayer());
        //ist das Game am laufen
        if(GameManager.inGame){

            //ist der Sender ein Spec
            if(!pp.isSpectator()){

                sendToSpecChat(msg, pp);

            //falls nicht
            }else{

                sendToAllChat(msg, pp);

            }

        }else{
            //Lobbynachricht senden
            Bukkit.broadcastMessage("§7[§6Lobby§7] "+ pp.getPlayer().getDisplayName()+" §8⋙ §7"+msg);
        }

    }

    private void sendToSpecChat(String msg, PreparedPlayer pp) {

        //Spielerloop
        for(Player current : Bukkit.getServer().getOnlinePlayers()){

            //PreparedPlayer parsen
            PreparedPlayer cp = new PreparedPlayer(current);
            //ist der Spieler Spec
            if(cp.isSpectator()){
                //Message senden
                cp.getPlayer().sendMessage("§7[§bSpectator§7] "+pp.getPlayer().getName()+" §8⋙ §7"+msg);

            }

        }

    }

    private void sendToAllChat(String msg, PreparedPlayer pp) {

        //ist die Message für den AllChat
        if(msg.startsWith("@all")){

            //das @all entfernen
            msg = msg.substring(4);
            //Senden
            Bukkit.broadcastMessage("§8Global | "+pp.getChatPrefix()+msg);

        }else {
            //Spielerloop
            for (Player current : Bukkit.getServer().getOnlinePlayers()) {

                //PreparedPlayer parsen
                PreparedPlayer cp = new PreparedPlayer(current);
                //ist das Team des Spielers das des Senders
                if (cp.getTeam() == pp.getTeam()) {
                    //senden
                    current.sendMessage(pp.getChatPrefix() + msg);
                }

            }
        }
    }

}
