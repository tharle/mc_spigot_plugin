package me.tharle.myFirstPlugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class MenuCommand implements CommandExecutor {

    public static final String MENU_TITLE = ChatColor.AQUA + "Custom GUI";

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player player){
            // The menu
            // The slots need be mult of 9, because even line is 9.
            Inventory inventory = Bukkit.createInventory(player, 9, MENU_TITLE);

            // Buttons
            ItemStack feed = new ItemStack(Material.BREAD);
            ItemStack death = new ItemStack(Material.TNT);
            ItemStack fight = new ItemStack(Material.DIAMOND_SWORD);

            //Item metadata
            ItemMeta feedMeta = feed.getItemMeta();
            feedMeta.setDisplayName(ChatColor.GREEN + "Feed");
            feedMeta.setLore(List.of(ChatColor.GOLD + "Hunger no more."));
            feed.setItemMeta(feedMeta);

            ItemMeta deathMeta = feed.getItemMeta();
            deathMeta.setDisplayName(ChatColor.RED + "Death");
            deathMeta.setLore(List.of(ChatColor.GOLD + "Death is inevitable."));
            death.setItemMeta(deathMeta);

            ItemMeta fightMeta = feed.getItemMeta();
            fightMeta.setDisplayName(ChatColor.YELLOW + "Fight");
            fightMeta.setLore(List.of(ChatColor.GOLD + "Fight like a kinga!"));
            fight.setItemMeta(fightMeta);

            inventory.setItem(0, feed);
            inventory.setItem(4, death);
            inventory.setItem(8, fight);

            // Open inventory for the player
            player.openInventory(inventory);



        }else {
            commandSender.sendMessage(ChatColor.RED + ""+ ChatColor.ITALIC + "You need be a player for this command.");
        }

        return true;
    }
}
