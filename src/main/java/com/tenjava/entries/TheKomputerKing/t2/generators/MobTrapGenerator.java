package com.tenjava.entries.TheKomputerKing.t2.generators;

import com.tenjava.entries.TheKomputerKing.t2.GeneratorManager;
import java.util.*;
import org.bukkit.*;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Creature;
import org.bukkit.event.*;
import org.bukkit.event.entity.EntityInteractEvent;

/**
 * Harnesses energy by trapping mobs and using their energy.
 * @author kailanblanks
 */
public class MobTrapGenerator implements EnergyGenerator, Listener {

    @Override
    public String getName() {
        return "Mob Trap";
    }

    @Override
    public void tick() {
    }
    
    /**
     * Called whenever an entity interacts with something.
     * Used here to check when a mob stands on a golden pressure plate.
     * @param event 
     */
    @EventHandler
    public void onInteract(EntityInteractEvent event) {
        if (event.getBlock().getType().equals(Material.GOLD_PLATE) && event.getEntity() instanceof Creature) {
            // The entity is a mob and the block they have stood on is a golden pressure plate.
            // Now check if the pressure plate is on top of a generator.
            Location testing = event.getBlock().getRelative(BlockFace.DOWN).getLocation();
            if (testing.getBlock().getType().equals(Material.GOLD_BLOCK)) {
                // It's probably a generator, now let's add some fuel.
                GeneratorManager.get().addFuel(testing, 5);
            }
        }
    }

}
