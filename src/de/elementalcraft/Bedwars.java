//CopyRight at Carlos17Kopra | Arvid

package de.elementalcraft;

import de.elementalcraft.util.classes.ConfigManager;
import de.elementalcraft.util.classes.SQLConnection;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class Bedwars extends JavaPlugin {

    public static Bedwars plugin;

    //config
    private ConfigManager config;
    private ConfigManager gamefile;

    //settings-variabeln
    private String prefix;
    private String noPerm;

    private int minPlayers;
    private int maxPlayers;
    private int teamAmount;
    private int playerPerTeamAmount;

    private int dropsBronze;
    private int dropsIron;
    private int dropsGold;

    //sql
    private SQLConnection con;

    @Override
    public void onEnable() {
        plugin = this;

        init();
        con.connect();

        System.out.println("");
        Bukkit.getConsoleSender().sendMessage(getPrefix()+"§aBedwars Plugin geladen!");
        System.out.println("");
    }

    @Override
    public void onDisable() {
        con.Disconnect();
    }


    private void init(){

        registerConfig();
        gamefile = new ConfigManager(this, "gamemanager");
        registerValues();
        registerCommands();
        registerEvents();

    }
    private void registerConfig(){

        config = new ConfigManager(this, "config").register();
        config.setMySQLDefaults();
        config.setRootPath("Bedwars.Settings.");

        List<String>perms = new ArrayList<>();
        perms.add("bw.build");
        perms.add("bw.troll");
        perms.add("bw.start");

        config.addDefault(config.getRootPath()+"Prefix", "§aBedwars §7| ");
        config.addDefault(config.getRootPath()+"NoPerm", "§cDazu hast du keine Rechte!");
        config.addDefault(config.getRootPath()+"Game.MinPlayers", 2);
        config.addDefault(config.getRootPath()+"Game.MaxPlayers", 4);
        config.addDefault(config.getRootPath()+"Game.Teams", 2);
        config.addDefault(config.getRootPath()+"Game.PlayersPerTeam", 2);
        config.addDefault(config.getRootPath()+"Game.Drops.BronzeDropsPerCycle", 3);
        config.addDefault(config.getRootPath()+"Game.Drops.IronDropsPerCycle", 2);
        config.addDefault(config.getRootPath()+"Game.Drops.GoldDropsPerCycle", 1);
        config.addDefault(config.getRootPath()+"System.Permissions", perms);

        config.registerDefaults();

    }
    public void registerValues(){

        String[] con_data = config.getMySQLData();
        con = new SQLConnection(con_data[0],con_data[1],con_data[2],con_data[3],con_data[4]);

        this.prefix = config.getString(config.getRootPath()+"Prefix");
        this.noPerm = config.getString(config.getRootPath()+"NoPerm");

        this.minPlayers = config.getInt(config.getRootPath()+"Game.MinPlayers");
        this.maxPlayers = config.getInt(config.getRootPath()+"Game.MaxPlayer");

        this.teamAmount = config.getInt(config.getRootPath()+"Game.Team");
        this.playerPerTeamAmount = config.getInt(config.getRootPath()+"Game.PlayersPerTeam");

        this.dropsBronze = config.getInt(config.getRootPath()+"Game.Drops.BronzeDropsPerCycle");
        this.dropsIron = config.getInt(config.getRootPath()+"Game.Drops.IronDropsPerCycle");
        this.dropsGold = config.getInt(config.getRootPath()+"Game.Drops.GoldDropsPerCycle");

    }

    private void registerEvents(){

    }
    private void registerCommands(){

    }

    public static Bedwars getPlugin() {
        return plugin;
    }

    public String getPrefix() {
        return ChatColor.translateAlternateColorCodes('&',prefix);
    }

    public SQLConnection getCon() {
        return con;
    }

    public ConfigManager _getConfig() {
        return config;
    }

    public String getNoPerm() {
        return ChatColor.translateAlternateColorCodes('&',noPerm);
    }

    public int getMinPlayers() {
        return minPlayers;
    }

    public ConfigManager getGamefile() {
        return gamefile;
    }

    public int getDropsBronze() {
        return dropsBronze;
    }

    public int getDropsGold() {
        return dropsGold;
    }

    public int getDropsIron() {
        return dropsIron;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public int getPlayerPerTeamAmount() {
        return playerPerTeamAmount;
    }

    public int getTeamAmount() {
        return teamAmount;
    }
}
