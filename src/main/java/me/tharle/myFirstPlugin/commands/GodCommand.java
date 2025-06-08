package me.tharle.myFirstPlugin.commands;

import static org.bukkit.ChatColor.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GodCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        //Toogle make invunerable
        if(commandSender instanceof Player player){
            player.setInvulnerable(!player.isInvulnerable());

            player.sendMessage(
                    (player.isInvulnerable()? GREEN : RED)
                    + "God mode "
                    + (player.isInvulnerable()? "enabled" : "disabled"));

        } else {
            commandSender.sendMessage(RED + ""+ ITALIC + "You need a player for this command.");
        }


        return true;
    }
}
