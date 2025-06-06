package me.tharle.myFirstPlugin;

import me.tharle.myFirstPlugin.commands.FeedCommand;
import me.tharle.myFirstPlugin.commands.GodCommand;
import me.tharle.myFirstPlugin.commands.HungryCommand;
import me.tharle.myFirstPlugin.listenners.DeadListenner;
import me.tharle.myFirstPlugin.listenners.ShearListenner;
import org.bukkit.ChatColor;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class MyFirstPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getLogger().info("ON ENABLE CUSTOM PLUGIN");

        // Register all events
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new ShearListenner(), this);
        getServer().getPluginManager().registerEvents(new DeadListenner(), this);

        // Register all commands
        getCommand("god").setExecutor(new GodCommand());
        getCommand("feed").setExecutor(new FeedCommand());
        getCommand("hungry").setExecutor(new HungryCommand());
    }

    @Override
    public void onDisable() {
        getLogger().info("ON DISABLE CUSTOM PLUGIN");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        getLogger().info("The player ["+event.getPlayer().getName()+"] has join to the server!!! <3" );
        event.setJoinMessage("Welcome to the server "+event.getPlayer().getName()+"! Get a chair and relax!");
    }

    @EventHandler
    public void onLeaveBed(PlayerBedLeaveEvent event) {
        Player player = event.getPlayer();
        player.sendMessage("GOOD MORNING!! ");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // /die kill the player

        if(command.getName().equalsIgnoreCase("die")) {
            if(sender instanceof Player player){
                player.setHealth(0);
                player.sendMessage(ChatColor.RED + "" + ChatColor.ITALIC + "You have opted to die!!");

                return true;
            } else if(sender instanceof ConsoleCommandSender){
                getLogger().info("Command send for CONSOLE commander sender");
            } else if(sender instanceof BlockCommandSender){
                getLogger().info("Command send for BLOCK commander sender");
            }
        }

        return super.onCommand(sender, command, label, args);
    }
}
