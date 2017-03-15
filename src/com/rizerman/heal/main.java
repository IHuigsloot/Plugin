package com.rizerman.heal;

import com.rizerman.heal.commands.*;
import com.rizerman.heal.event.block.BlockBreak;
import com.rizerman.heal.event.inventory.InventoryClick;
import com.rizerman.heal.event.other.ProjectileHit;
import com.rizerman.heal.event.player.PlayerChat;
import com.rizerman.heal.event.player.PlayerJoin;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class main extends JavaPlugin{

    public void onEnable(){
        PluginDescriptionFile pdffile = getDescription();
        Logger logger = Logger.getLogger("Minecraft");

        registerCommands();
        registerEvents();
        registerConfig();
        registerPermission();

        logger.info(pdffile.getName()+ "Has been enabled V" + pdffile.getVersion());
    }

    public void onDisable(){
        PluginDescriptionFile pdffile = getDescription();
        Logger logger = Logger.getLogger("Minecraft");

        logger.info(pdffile.getName()+ "Has been Disabled!");
    }

    private void registerCommands(){
        getCommand("hello").setExecutor(new Hello(this));
        getCommand("goodbye").setExecutor(new goodbye());
        getCommand("menu").setExecutor(new Menu());
        getCommand("Website").setExecutor(new Website());
        getCommand("Seed").setExecutor(new Seed());
        getCommand("Fly").setExecutor(new Fly());
        getCommand("Gamemode").setExecutor(new Gamemode());
    }
    private void registerEvents(){
        PluginManager pm = getServer().getPluginManager();

        pm.registerEvents(new BlockBreak(), this);
        pm.registerEvents(new PlayerChat(), this);
        pm.registerEvents(new PlayerJoin(this), this);
        pm.registerEvents(new InventoryClick(), this);
        pm.registerEvents(new ProjectileHit(), this);
    }
    private void registerConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
    private void registerPermission(){
        Permission p = new Permission("heal.snowball");

        PluginManager pm = getServer().getPluginManager();

        pm.addPermission(p);
    }
}
