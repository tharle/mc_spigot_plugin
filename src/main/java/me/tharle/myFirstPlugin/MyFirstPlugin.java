package me.tharle.myFirstPlugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class MyFirstPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("ON ENABLE CUSTOM PLUGIN");

    }

    @Override
    public void onDisable() {
        getLogger().info("ON DISABLE CUSTOM PLUGIN");
    }
}
