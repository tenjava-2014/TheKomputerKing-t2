package com.tenjava.entries.TheKomputerKing.t2;

import java.util.*;
import org.bukkit.*;
import org.bukkit.event.*;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Manages putting fuel into generators.
 * @author kailanblanks
 */
public class GeneratorManager implements Listener {

    private static GeneratorManager instance;
    
    /**
     * Creates a new instance of GeneratorManager.
     */
    public static void initialize() {
        instance = new GeneratorManager();
    }

    /**
     * Gets the current instance of the GeneratorManager.
     * @return instance
     */
    public static GeneratorManager get() {
        return instance;
    }
    
    private Map<Location, Integer> generatorBlocks = new HashMap<>();
    
    /**
     * Adds the specified amount of fuel to a generator block.
     * @param l
     * @param amount 
     */
    public void addFuel(Location l, int amount) {
        if (!generatorBlocks.containsKey(l)) {
            generatorBlocks.put(l, amount);
        } else {
            generatorBlocks.put(l, generatorBlocks.get(l)+amount);
        }
    }
    
    /**
     * Called when a block is broken.
     * @param event 
     */
    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        if (generatorBlocks.containsKey(event.getBlock().getLocation())) {
            Location l = event.getBlock().getLocation();
            l.getWorld().dropItem(l, new ItemStack(Material.COAL, generatorBlocks.get(l)));
        }
    }

 }
