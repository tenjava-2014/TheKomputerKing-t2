package com.tenjava.entries.TheKomputerKing.t2.generators;

/**
 * Interface implemented by all energy generators.
 * @author kailanblanks
 */
public interface EnergyGenerator {

   /**
    * Gets the human-readable name for the generator.
    * @return name
    */
    public String getName();
    
    /**
     * Called every 5 seconds for each generator, used to create fuel.
     */
    public void tick();
    
}
