package me.tharle.myFirstPlugin.listenners;

import me.tharle.myFirstPlugin.MyFirstPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class DeadListenner implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event){
        MyFirstPlugin plugin = MyFirstPlugin.getPlugin(MyFirstPlugin.class);

        new BukkitRunnable(){

            @Override
            public void run() {
                event.getEntity().sendMessage("I want waffer fries!!");
            }
        }.runTaskLater(plugin, 20L);
    }
}
