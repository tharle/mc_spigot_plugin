package me.tharle.myFirstPlugin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class MyFirstPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getLogger().info("ON ENABLE CUSTOM PLUGIN");

        // Register all events
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        getLogger().info("ON DISABLE CUSTOM PLUGIN");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        getLogger().info("The player ["+event.getPlayer().getName()+"] has join to the server!!! <3" );
        event.setJoinMessage("Welcome to the server "+event.getPlayer().getName()+"! Get a chair and relax!");
    }

    @EventHandler
    public void onLeaveBed(PlayerBedLeaveEvent event) {
        Player player = event.getPlayer();
        player.sendMessage("GOOD MORNING!! ");
    }
}
