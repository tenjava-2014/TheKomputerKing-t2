package com.tenjava.entries.TheKomputerKing.t2;

import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Powerups plugin - Allows survival users to find powerups
 * that can make the game experience longer.
 * @author kailanblanks
 */
public class Powerups extends JavaPlugin {
    
    private static Logger logger;
    private static Powerups instance;
    
    @Override
    public void onEnable() {
        instance = this;
        logger = this.getLogger();
    }
    
    public static Powerups get() {
        return instance;
    }
    
    public static Logger logger() {
        return logger;
    }
    
}
