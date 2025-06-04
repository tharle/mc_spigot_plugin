package me.tharle.myFirstPlugin;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerShearEntityEvent;

public class ShearListenner implements Listener {
    @EventHandler
    public void onShear(PlayerShearEntityEvent event){
        Player player = event.getPlayer();
        Entity entity = event.getEntity();

        if(entity.getType() == EntityType.SHEEP){
            player.sendMessage("This is a  sheep, but you can't do that for now!");
            event.setCancelled(true);
        } else {
            player.sendMessage("This is not the sheep!!! beeeh");
        }
    }
}
