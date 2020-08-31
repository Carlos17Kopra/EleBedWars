//CopyRight at Carlos17Kopra | Arvid

package de.elementalcraft.util.classes;

//CopyRight at Carlos17Kopra | Arvid
import org.bukkit.*;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigManager{

    private Plugin plugin;

    private HashMap<String, Object> defaults = new HashMap<>();

    private String path;
    private String name;

    private YamlConfiguration cfg;
    private File file;

    public static ConfigManager fromYamlConfiguration(Plugin plugin, YamlConfiguration cfg){

        return new ConfigManager(plugin, cfg.getCurrentPath(), cfg.getName());

    }

    public ConfigManager(Plugin plugin, String name){

        this.plugin = plugin;

        if(name.contains(".yml")){
            this.name = name;
        }else{
            this.name = name+".yml";
        }
        this.path = "plugins//"+plugin.getName()+"//";

    }

    public ConfigManager(Plugin plugin, String path, String name){

        this.plugin = plugin;

        if(name.contains(".yml")){
            this.name = name;
        }else{
            this.name = name+".yml";
        }
        this.path = path;

    }

    public ConfigManager register(){
        this.file = new File(this.path, this.name);
        this.cfg = YamlConfiguration.loadConfiguration(this.file);
        return this;
    }

    public ConfigManager addDefault(String path, Object value){
        defaults.put(path, value);
        return this;
    }
    public ConfigManager clearDefaults(){
        defaults.clear();
        return this;
    }

    public ConfigManager save(){

        try {
            this.cfg.save(this.file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    public ConfigManager setMySQLDefaults(){

        defaults.put("MySQL.Host", "localhost");
        defaults.put("MySQL.Port", "3306");
        defaults.put("MySQL.User", "root");
        defaults.put("MySQL.Passwd", "passwd");
        defaults.put("MySQL.Database", "Database");
        return this;

    }

    public String[] getMySQLData(){

        if(this.cfg.getConfigurationSection("MySQL") != null){

            String[] ret = new String[5];
            ret[0] = cfg.getString("MySQL.Host");
            ret[1] = cfg.getString("MySQL.Port");
            ret[2] = cfg.getString("MySQL.User");
            ret[3] = cfg.getString("MySQL.Passwd");
            ret[4] = cfg.getString("MySQL.Database");

            return ret;

        }else{
            return new String[1];
        }

    }

    public ConfigManager registerDefaults(){

        this.cfg.options().copyDefaults(true);

        for(String path : defaults.keySet()){

            Object value = defaults.get(path);
            this.cfg.addDefault(path, value);

        }
        save();
        return this;
    }

    public String getName() {
        return name;
    }

    public File getFile() {
        return file;
    }

    public HashMap<String, Object> getDefaults() {
        return defaults;
    }

    public Plugin getPlugin() {
        return plugin;
    }

    public String getPath() {
        return path;
    }

    public YamlConfiguration getCfg() {
        return cfg;
    }


    //getter

    public void setLocation(String path, Location loc){

        cfg.set(path+".World", loc.getWorld().getName());
        cfg.set(path+".X", loc.getX());
        cfg.set(path+".Y", loc.getY());
        cfg.set(path+".Z", loc.getZ());
        cfg.set(path+".Yaw", loc.getYaw());
        cfg.set(path+".Pitch", loc.getPitch());

    }

    public Location getLocation(String path){

        String worldName = cfg.getString(path+".World");
        double x = cfg.getDouble(path+".X");
        double y = cfg.getDouble(path+".Y");
        double z = cfg.getDouble(path+".Z");
        float yaw = (float)cfg.getDouble(path+".Yaw");
        float pitch = (float)cfg.getDouble(path+".Pitch");
        World world = null;
        while(true){
            if(worldName !=null){
                world = Bukkit.getWorld(worldName);
                break;
            }
        }
        return new Location(world, x,y,z,yaw,pitch);

    }

    public void set(String path, Object val){
        cfg.set(path, val);
    }
    public Object get(String path){
        return cfg.get(path);
    }

    public Object get(String path, Object var2){
        return cfg.get(path, var2);
    }

    public ConfigurationSection getConfigurationSection(String section){
        return cfg.getConfigurationSection(section);
    }

    public ConfigurationSection createSection(String var1){
        return cfg.createSection(var1);
    }

    public ConfigurationSection createSection(String var1, Map<?, ?> var2){
        return cfg.createSection(var1, var2);
    }


    public String getString(String path){
        return cfg.getString(path);
    }

    public String getString(String var1, String var2){
        return cfg.getString(var1, var2);
    }

    public boolean isString(String var1){
        return cfg.isString(var1);
    }

    public int getInt(String var1){
        return cfg.getInt(var1);
    }

    public int getInt(String var1, int var2){
        return cfg.getInt(var1, var2);
    }

    public boolean isInt(String var1){
        return cfg.isInt(var1);
    }

    public boolean getBoolean(String var1){
        return cfg.getBoolean(var1);
    }

    public boolean getBoolean(String var1, boolean var2){
        return cfg.getBoolean(var1, var2);
    }

    public boolean isBoolean(String var1){
        return cfg.isBoolean(var1);
    }

    public double getDouble(String var1){
        return cfg.getDouble(var1);
    }

    public double getDouble(String var1, double var2){
        return cfg.getDouble(var1, var2);
    }

    public boolean isDouble(String var1){
        return cfg.isDouble(var1);
    }

    public long getLong(String var1){
        return cfg.getLong(var1);
    }

    public long getLong(String var1, long var2){
        return cfg.getLong(var1, var2);
    }

    public boolean isLong(String var1){
        return cfg.isLong(var1);
    }

    public List<?> getList(String var1){
        return cfg.getList(var1);
    }

    public List<?> getList(String var1, List<?> var2){
        return cfg.getList(var1, var2);
    }

    public boolean isList(String var1){
        return cfg.isList(var1);
    }

    public List<String> getStringList(String var1){
        return cfg.getStringList(var1);
    }

    public List<Integer> getIntegerList(String var1){
        return cfg.getIntegerList(var1);
    }

    public List<Boolean> getBooleanList(String var1){
        return cfg.getBooleanList(var1);
    }

    public List<Double> getDoubleList(String var1){
        return cfg.getDoubleList(var1);
    }

    public List<Float> getFloatList(String var1){
        return cfg.getFloatList(var1);
    }

    public List<Long> getLongList(String var1){
        return cfg.getLongList(var1);
    }

    public List<Byte> getByteList(String var1){
        return cfg.getByteList(var1);
    }

    public List<Character> getCharacterList(String var1){
        return cfg.getCharacterList(var1);
    }

    public List<Short> getShortList(String var1){
        return cfg.getShortList(var1);
    }

    public List<Map<?, ?>> getMapList(String var1){
        return cfg.getMapList(var1);
    }

    public Vector getVector(String var1){
        return cfg.getVector(var1);
    }

    public Vector getVector(String var1, Vector var2){
        return cfg.getVector(var1);
    }

    public boolean isVector(String var1){
        return cfg.isVector(var1);
    }

    public OfflinePlayer getOfflinePlayer(String var1){
        return cfg.getOfflinePlayer(var1);
    }

    public OfflinePlayer getOfflinePlayer(String var1, OfflinePlayer var2){
        return cfg.getOfflinePlayer(var1, var2);
    }

    public boolean isOfflinePlayer(String var1){
        return cfg.isOfflinePlayer(var1);
    }

    public ItemStack getItemStack(String var1){
        return cfg.getItemStack(var1);
    }

    public ItemStack getItemStack(String var1, ItemStack var2){
        return cfg.getItemStack(var1, var2);
    }

    public boolean isItemStack(String var1){
        return cfg.isItemStack(var1);
    }

    public Color getColor(String var1){
        return cfg.getColor(var1);
    }

    public Color getColor(String var1, Color var2){
        return cfg.getColor(var1, var2);
    }

    public boolean isColor(String var1){
        return cfg.isColor(var1);
    }


    public boolean isConfigurationSection(String var1){
        return cfg.isConfigurationSection(var1);
    }

    public ConfigurationSection getDefaultSection(){
        return cfg.getDefaultSection();
    }

    //alter ist das eine Scheißarbeit!

}
