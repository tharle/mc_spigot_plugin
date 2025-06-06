package me.tharle.myFirstPlugin.commands;

import me.tharle.myFirstPlugin.MyFirstPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {
    private final MyFirstPlugin plugin;

    public SpawnCommand(){
        plugin = MyFirstPlugin.getPlugin(MyFirstPlugin.class);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player player){
            Location location = plugin.getConfig().getLocation("spawn");

            if(location == null) return true;

            player.teleport(location);
            player.sendMessage(ChatColor.ITALIC +"" + ChatColor.DARK_PURPLE + "You have teleported to the spawn!!!");
        }
        return true;
    }
}
