package com.rizerman.heal.commands;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Fly implements CommandExecutor{

    private ArrayList<String> HasFly = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("You must be a player to execute this command!");
            return false;
        }

        Player player = (Player) sender;

        if (!(player.hasPermission("heal.fly") || player.isOp())){
            player.sendMessage(ChatColor.RED + "You don't have permission to use this command");
            return false;
        }

        if (!(HasFly.contains(player.getName()))){

            player.sendMessage(ChatColor.GREEN + "Fly has been enabled!");
            player.setAllowFlight(true);
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, Integer.MAX_VALUE);

            HasFly.add(player.getName());
        }
        else {
            player.sendMessage(ChatColor.RED + "Fly has been disabled!");
            player.setAllowFlight(false);
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, Integer.MAX_VALUE);

            HasFly.remove(player.getName());
        }


        return false;
    }
}
