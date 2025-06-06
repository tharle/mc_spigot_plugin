package me.tharle.myFirstPlugin.listenners;

import me.tharle.myFirstPlugin.MyFirstPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class SpawnListeners implements Listener {
    private final MyFirstPlugin plugin;

    public SpawnListeners(){
        plugin = MyFirstPlugin.getPlugin(MyFirstPlugin.class);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        plugin.getLogger().info("The player ["+event.getPlayer().getName()+"] has join to the server!!! <3" );
        if(!event.getPlayer().hasPlayedBefore()) {
            event.setJoinMessage("Welcome to the server "+event.getPlayer().getName()+"! Get a chair and relax!");

            Location location = plugin.getConfig().getLocation("spawn");
            if(location == null) return;

            event.getPlayer().teleport(location);
        } else {
            // Get the config  value message thing
            String rejoinMessage = plugin.getConfig().getString("rejoin-message");

            if(rejoinMessage == null) rejoinMessage = "Welcome back.";
            rejoinMessage = rejoinMessage.replace("%player_name%", event.getPlayer().getDisplayName());
            event.setJoinMessage(ChatColor.translateAlternateColorCodes('&', rejoinMessage));
        }
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event){
        // When player is died, respawn in the spawn if set
        Location location = plugin.getConfig().getLocation("spawn");
        if(location == null) return;

        event.setRespawnLocation(location);
    }
}
