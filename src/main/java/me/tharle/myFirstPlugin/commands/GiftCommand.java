package me.tharle.myFirstPlugin.commands;

import static org.bukkit.Material.*;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class GiftCommand implements CommandExecutor {
    private final int KNOCKBACK_VALUE = 255;

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        //Create item


        if(commandSender instanceof Player player){
            PlayerInventory playerInventory = player.getInventory();

            ItemStack flower = new ItemStack(FLOWERING_AZALEA, 2);
            //That will set in any slot
            //playerInventory.addItem(flower);

            //Specific slot
            playerInventory.setItem(1, flower); // hotbar 2

            ItemStack food = new ItemStack(BEEF, 7);
            ItemMeta foodMeta = food.getItemMeta();
            foodMeta.setDisplayName(ChatColor.RED + "Yummy food");

            List<String> foodLore = new ArrayList<>();
            foodLore.add("This is the best food.");
            foodLore.add("You want to eat me.");
            foodLore.add("Subscribe to tharle.");
            foodMeta.setLore(foodLore);

            // Max is 255
            foodMeta.addEnchant(Enchantment.KNOCKBACK, KNOCKBACK_VALUE, true );

            //add the meta
            food.setItemMeta(foodMeta);
            playerInventory.addItem(food);

        }

        return true;
    }
}
