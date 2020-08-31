//CopyRight at Carlos17Kopra | Arvid

package de.elementalcraft;

import org.bukkit.plugin.java.JavaPlugin;

public class Bedwars extends JavaPlugin {

    public static Bedwars plugin;



    @Override
    public void onEnable() {
        plugin = this;

        init();

    }

    @Override
    public void onDisable() {

    }


    private void init(){

    }
    private void registerConfig(){

    }

    private void registerEvents(){

    }
    private void registerCommands(){

    }

    public static Bedwars getPlugin() {
        return plugin;
    }
}
