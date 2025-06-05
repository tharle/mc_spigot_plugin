package me.tharle.myFirstPlugin.commands;

import org.bukkit.ChatColor;
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
                    (player.isInvulnerable()? ChatColor.GREEN : ChatColor.RED)
                    + "God mode "
                    + (player.isInvulnerable()? "enabled" : "disabled"));

        }


        return true;
    }
}
