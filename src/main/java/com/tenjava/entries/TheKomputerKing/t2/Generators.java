package com.tenjava.entries.TheKomputerKing.t2;

import com.tenjava.entries.TheKomputerKing.t2.generators.MobTrapGenerator;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Generators plugin - adds generators to the game that can create fuel to power
 * furnaces and other things that I haven't thought of yet.
 * @author kailanblanks
 */
public class Generators extends JavaPlugin {
    
    private static Logger logger;
    private static Generators instance;
    
    /**
     * Called when the plugin is enabled.
     */
    @Override
    public void onEnable() {
        instance = this;
        logger = this.getLogger();
        
        Bukkit.getPluginManager().registerEvents(new MobTrapGenerator(), this);
        
        GeneratorManager.initialize();
        Bukkit.getPluginManager().registerEvents(GeneratorManager.get(), this);
    }
    
    /**
     * Gets the current instance of the plugin.
     * @return plugin
     */
    public static Generators get() {
        return instance;
    }
    
    /**
     * Gets the current logger for the plugin.
     * @return logger
     */
    public static Logger logger() {
        return logger;
    }
    
}
