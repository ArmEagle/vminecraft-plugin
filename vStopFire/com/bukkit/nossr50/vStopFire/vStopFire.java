package com.bukkit.nossr50.vStopFire;

import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * vStopFire for Bukkit
 *
 * @author nossr50
 */
public class vStopFire extends JavaPlugin {
    private final vBlockListener blockListener = new vBlockListener();
    private boolean hasRegisteredListeners = false; 
    
    public void onEnable() {
    	if ( !this.hasRegisteredListeners ) {
	    	getServer().getPluginManager().registerEvent(Event.Type.BLOCK_IGNITE, blockListener, Priority.Normal, this);
	    	getServer().getPluginManager().registerEvent(Event.Type.BLOCK_BURN, blockListener, Priority.Normal, this);
	    	this.hasRegisteredListeners = true;
    	}
        PluginDescriptionFile pdfFile = this.getDescription();
        System.out.println( pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled" );
    }
    public void onDisable() {
        PluginDescriptionFile pdfFile = this.getDescription();
        System.out.println( pdfFile.getName() +" is disabled");
    }
}
