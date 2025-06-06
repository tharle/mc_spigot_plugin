package me.tharle.myFirstPlugin.commands;

import me.tharle.myFirstPlugin.MyFirstPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCommand implements CommandExecutor {

    private final MyFirstPlugin plugin;

    public SetSpawnCommand(){
        plugin = MyFirstPlugin.getPlugin(MyFirstPlugin.class);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(commandSender instanceof Player player){
            Location location = player.getLocation();
            plugin.getConfig().set("spawn", location);
            plugin.saveConfig();

            player.sendMessage(ChatColor.ITALIC + "Spawn location set");
        }

        return true;
    }


}
