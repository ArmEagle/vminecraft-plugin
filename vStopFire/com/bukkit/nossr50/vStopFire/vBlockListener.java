package com.bukkit.nossr50.vStopFire;

import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockListener;

/**
 * vStopFire block listener
 * @author nossr50
 */
public class vBlockListener extends BlockListener {

    public vBlockListener() {
    }
    //This should stop fire from spreading but still allow players to light stuff up with flint and steel
    public void onBlockIgnite(BlockIgniteEvent event) {
    	String cause = event.getCause().toString();
    	if(cause.equals("SPREAD"))
    		event.setCancelled(true);
    	if(!cause.equals("FLINT_AND_STEEL"))
    		event.setCancelled(true);
    }
    
    // Cancel blocks actually being burned and destroyed
    // Fire is fine, but we don't want to lose blocks.
    public void onBlockBurn(BlockBurnEvent event) {
    	event.setCancelled(true);
    }
}
