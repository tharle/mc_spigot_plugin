package me.tharle.myFirstPlugin.listenners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryListenner implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){
        if(event.getWhoClicked() instanceof Player player){
            ItemStack itemStack = event.getCurrentItem();

            String message = "You clicked ";
            switch (itemStack.getType()){
                case Material.FLOWERING_AZALEA -> {
                  message += "the Flower!";
                }
                case Material.BEEF -> {
                    message += "the Beef!";
                }
                default -> {
                    message += "something else! aka ";
                    message += itemStack.getType().toString() + "!";
                }
            }

            player.sendMessage(ChatColor.ITALIC + "" + ChatColor.DARK_PURPLE + message);
        }
    }
}
