package ro.Stellrow.HarderMinecraftMobs;

import org.bukkit.plugin.java.JavaPlugin;
import ro.Stellrow.HarderMinecraftMobs.utils.ConfigurationManager;

public class HMMobs extends JavaPlugin {
    public ConfigurationManager configurationManager = new ConfigurationManager();


    public void onEnable(){
        loadConfig();
        configurationManager.updateValues(getConfig());
        getCommand("harderminecraftmobs").setExecutor(new HMMCommand(this));
        getServer().getPluginManager().registerEvents(new HMMEvents(this),this);
    }
    private void loadConfig(){
        getConfig().options().copyDefaults(true);
        saveConfig();
    }


    public void updateData(){
        reloadConfig();
        configurationManager.updateValues(getConfig());
    }




}
