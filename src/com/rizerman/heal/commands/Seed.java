package com.rizerman.heal.commands;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Seed implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("You must be a player to execute this command!");
            return false;
        }

        Player player = (Player) sender;
        World world = player.getWorld();
        player.sendMessage("The world Seed is: " + world.getSeed());

        return false;
    }
}
