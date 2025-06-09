package me.tharle.myFirstPlugin.listenners;

import me.tharle.myFirstPlugin.MyFirstPlugin;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveListener implements Listener {
    private final MyFirstPlugin plugin;

    public MoveListener(){
        plugin = MyFirstPlugin.getPlugin(MyFirstPlugin.class);
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event)
    {
        if(!plugin.getConfig().getBoolean("spawn-move")) return;

        //spawn a entity
        Player player = event.getPlayer();
        player.getWorld().spawnEntity(player.getLocation(), EntityType.TURTLE);
    }
}
