package me.tharle.myFirstPlugin.listenners;

import me.tharle.myFirstPlugin.commands.MenuCommand;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class MenuListenner implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){

        //Check if is the custom menu
        if(event.getView().getTitle().equalsIgnoreCase(MenuCommand.MENU_TITLE)
                && event.getWhoClicked() instanceof Player player
                && event.getCurrentItem() != null){

            // That will clean the "default click event"
            event.setCancelled(true);

            if(event.isRightClick()) return;

            switch (event.getCurrentItem().getType()){
                case BREAD -> {
                    player.setFoodLevel(20);
                    player.sendMessage("Yum!! So yummy!!");
                }
                case TNT -> {
                    player.setHealth(0);
                    player.sendMessage("You just blow yourself...");
                }
                case DIAMOND_SWORD -> {
                    ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
                    player.getInventory().addItem(sword);
                    player.sendMessage("There, take this. It's dangerous go alone outside.");
                }
                default -> {
                    //  do nothing
                }
            }
        }
    }
}
