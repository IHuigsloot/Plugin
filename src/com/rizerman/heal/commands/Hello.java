package com.rizerman.heal.commands;

import com.rizerman.heal.main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class Hello implements CommandExecutor{

    private main plugin;

    public Hello(main pl) {
        plugin = pl;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("You must be a player to execute this command!");
            return false;
        }
        Player player = (Player) sender;
        player.sendMessage(ChatColor.AQUA +"Hello " + player.getName() + "!");

        List<String> serverAdmins = plugin.getConfig().getStringList("Server Admins");

        player.sendMessage("The Server admins are: ");
        for (String admin : serverAdmins){
            player.sendMessage(admin);
        }

        return true;
    }
}
