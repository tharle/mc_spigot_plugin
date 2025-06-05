package me.tharle.myFirstPlugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HungryCommand implements CommandExecutor {
    //The minimum hunger level (or food level) a player can have is 0.
    private final int MIN_FOOD_LEVEL = 0;
    //pitch is optional. It determines the pitch for the sound effect. It can be a value between 0.0 and 2.0. The higher the value, the higher the pitch.
    private final float SOUND_PTICH = 1.0f;
    //minimumVolume is optional. It is determines the minimum volume that the sound will be heard outside of the audible sphere. It can be a value between 0.0 and 1.0.
    private final float SOUND_VOLUME = 1.5f;

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player player) {

            if(player.getFoodLevel() > MIN_FOOD_LEVEL ){
                player.setFoodLevel(player.getFoodLevel() - 5);

                player.playSound(player, Sound.ENTITY_GENERIC_HURT, SOUND_VOLUME, SOUND_PTICH);
                commandSender.sendMessage(ChatColor.YELLOW + "Ohhh!!! I fell a little more hunger now!!!!");
            } else {
                commandSender.sendMessage(ChatColor.BLUE + "I'm starving. I need food!!!!");
            }
        }else {
            commandSender.sendMessage(ChatColor.RED + ""+ ChatColor.ITALIC + "You need a player for this command.");
        }

        return true;
    }
}
