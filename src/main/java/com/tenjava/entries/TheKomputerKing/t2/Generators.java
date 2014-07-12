package com.tenjava.entries.TheKomputerKing.t2;

import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Generators plugin - adds generators to the game that can create fuel to power
 * furnaces and other things that I haven't thought of yet.
 * @author kailanblanks
 */
public class Generators extends JavaPlugin {
    
    private static Logger logger;
    private static Generators instance;
    
    @Override
    public void onEnable() {
        instance = this;
        logger = this.getLogger();
    }
    
    public static Generators get() {
        return instance;
    }
    
    public static Logger logger() {
        return logger;
    }
    
}
