//CopyRight at Carlos17Kopra | Arvid

package de.elementalcraft.util.playermanagement;

import de.elementalcraft.util.Teams;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class PreparedPlayer {

    //Attribute des Players
    private final Player player;
    private Teams team;
    private boolean canbuild;
    private boolean spectator;
    private String chatPrefix;

    public PreparedPlayer(Player player){
        //alle Werte auf Default setzen
        this.player = player;
        this.canbuild = false;
        this.spectator = false;
        this.team = Teams.NONE;
        this.chatPrefix = team.getCode()+team.getPrefix()+" §8⋙ "+team.getCode();
    }

    public String getChatPrefix() {
        //Chatprefix setzt sich aus den Werten des Teams zusammen
        return ChatColor.translateAlternateColorCodes('&', chatPrefix);
    }

    //spectator setzen
    public void setSpectator(boolean spectator) {
        this.spectator = spectator;
    }

    public boolean isSpectator() {
        return spectator;
    }

    //Buildmode togglen
    public void toggleBuildMode(){
        canbuild = !canbuild;
    }

    public boolean canBuild() {
        return canbuild;
    }

    //Team-getter
    public Teams getTeam() {
        return team;
    }
    //Team-setter
    public void setTeam(Teams team) {
        this.team = team;
        this.chatPrefix = this.team.getCode()+this.team.getPrefix()+" §8⋙ "+this.team.getCode();
    }
    //für die Benutzung aller Player-Methoden
    public Player getPlayer() {
        return player;
    }
}
