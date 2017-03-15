package com.rizerman.heal.commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Gamemode implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("You must be a player to execute this command!");
            return false;
        }

        Player player = (Player) sender;
        GameMode gm = player.getGameMode();

        if (!(player.hasPermission("heal.gamemode") || player.isOp()))     {
            player.sendMessage(ChatColor.RED + "You don't have permission to use this command");
            return false;
        }

        if (args.length == 0){
            if (gm == GameMode.SURVIVAL){
                player.sendMessage(ChatColor.GREEN + "Your gamemode has changed to " + ChatColor.BLUE + "Creative");
                player.setGameMode(GameMode.CREATIVE);
            }
            else {
                player.sendMessage(ChatColor.GREEN + "Your gamemode has changed to " + ChatColor.BLUE + "Survival");
                player.setGameMode(GameMode.SURVIVAL);
            }
        }
        else if (args[0].equalsIgnoreCase("creative")){
            player.sendMessage(ChatColor.GREEN + "Your gamemode has changed to " + ChatColor.BLUE + "Creative");
            player.setGameMode(GameMode.CREATIVE);
            return false;
        }
        else if (args[0].equalsIgnoreCase("Survival")){
            player.sendMessage(ChatColor.GREEN + "Your gamemode has changed to " + ChatColor.BLUE + "Survival");
            player.setGameMode(GameMode.SURVIVAL);
            return false;
        }
        else if (args[0].equalsIgnoreCase("Spectator")){
            player.sendMessage(ChatColor.GREEN + "Your gamemode has changed to " + ChatColor.BLUE + "Spectator");
            player.setGameMode(GameMode.SPECTATOR);
            return false;
        }
        else if (args[0].equalsIgnoreCase("Adventure")){
            player.sendMessage(ChatColor.GREEN + "Your gamemode has changed to " + ChatColor.BLUE + "Adventure");
            player.setGameMode(GameMode.ADVENTURE);
            return false;
        }
        else {
            sender.sendMessage(ChatColor.RED + "incorrect usage, /gamemode <Survival:Creative:Spectator:Adventure>");
            return false;
        }
        return false;
    }
}
