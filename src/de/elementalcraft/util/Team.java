//CopyRight at Carlos17Kopra | Arvid

package de.elementalcraft.util;

import java.util.ArrayList;
import java.util.List;

public class Team {

    //Liste aller Teams im Spiel
    public static List<Team> all = new ArrayList<>();

    //Type
    private Teams teamType;
    //ob das Bett noch da ist
    private boolean respawn;

    public Team(Teams teamType){

        this.teamType = teamType;
        respawn = true;
        all.add(this);

    }

    public void remove(){
        all.remove(this);
    }

    public Teams getTeamType() {
        return teamType;
    }

    public boolean canRespawn() {
        return respawn;
    }
}

