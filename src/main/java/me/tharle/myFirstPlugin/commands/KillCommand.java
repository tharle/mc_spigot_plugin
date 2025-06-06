package me.tharle.myFirstPlugin.commands;

import me.tharle.myFirstPlugin.MyFirstPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class KillCommand implements CommandExecutor {
    private final MyFirstPlugin plugin;

    public KillCommand(){
        plugin = MyFirstPlugin.getPlugin(MyFirstPlugin.class);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        // if no args, then exit error
        if(args.length == 0) {
            commandSender.sendMessage(ChatColor.RED + "You need tap the player to kill");
            commandSender.sendMessage(ChatColor.RED + "Ex: /kill <player_name>");
            return true;
        }

        String playerName = args[0];
        Player playerTarget = Bukkit.getServer().getPlayer(playerName);

        if(playerTarget == null){
            commandSender.sendMessage(ChatColor.RED + "The player ["+playerName+"] can't be found in this server.");
            return true;
        }

        playerTarget.setHealth(0);

        plugin.getLogger().info("The "+commandSender.getName() + " kill the "+playerName+" by command /kill.");

        new BukkitRunnable() {
            @Override
            public void run() {
                playerTarget.sendMessage(
                        "The " +ChatColor.YELLOW + commandSender.getName() +
                                ChatColor.WHITE + " kill the player "+
                                ChatColor.DARK_AQUA + playerName +"!!! YEEEAAHH");
            }
        }.runTaskLater(plugin, 60L);







        return true;
    }
}
