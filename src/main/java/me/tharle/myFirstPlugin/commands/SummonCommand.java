package me.tharle.myFirstPlugin.commands;

import me.tharle.myFirstPlugin.MyFirstPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class SummonCommand implements CommandExecutor {
    private final MyFirstPlugin plugin;

    public SummonCommand(){
        plugin = MyFirstPlugin.getPlugin(MyFirstPlugin.class);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {

        // if no args, then exit error
        if(args.length == 0) {
            commandSender.sendMessage(ChatColor.RED + "You need tap what you want to summoner");
            commandSender.sendMessage(ChatColor.RED + "Ex: /summon <entity>");
            return true;
        }
        String entityName = args[0];
        EntityType entityTypeToSummon = findEntityByName(entityName);

        if(entityTypeToSummon == EntityType.UNKNOWN){
            commandSender.sendMessage(ChatColor.RED + "The  "+ChatColor.UNDERLINE+entityName+ChatColor.RED+" is not a entity valid to summon. Try another one.");
            return true;
        }

        World world = Bukkit.getWorld("world");

        // 61, 71, 31 (Location in the world to spawn the entity)
        Location location = new Location(world, 61, 71, 31);
        Entity entitySummoned = world.spawnEntity(location, entityTypeToSummon);


        entitySummoned.setGlowing(true);
        entitySummoned.setCustomName("SUMMON ["+entityName+"]");
        entitySummoned.setCustomNameVisible(true);


        new BukkitRunnable() {
            @Override
            public void run() {
                commandSender.sendMessage(
                        "The " +ChatColor.YELLOW + commandSender.getName() +
                                ChatColor.WHITE + " summon a  "+
                                ChatColor.DARK_AQUA + entityName +" to this planet!! ");
            }
        }.runTaskLater(plugin, 60L);

        return true;
    }

    private EntityType findEntityByName(String entityName) {
        if(entityName.equalsIgnoreCase("bee")) return EntityType.BEE;

        return EntityType.UNKNOWN;
    }
}
