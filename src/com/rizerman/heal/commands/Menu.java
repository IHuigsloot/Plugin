package com.rizerman.heal.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Menu implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)){
            sender.sendMessage("You must be a player to execute this command!");
            return false;
        }

        Player player = (Player) sender;
        Inventory inv = Bukkit.createInventory(null, 9, "Custom inventory");
        ItemStack spawnItem = nameItem(Material.COMPASS, ChatColor.AQUA + "Teleport to spawn");

        inv.setItem(4, spawnItem);

        player.openInventory(inv);

        return true;
    }
    private ItemStack nameItem(ItemStack item, String name){
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        item.setItemMeta(meta);
        return item;
    }
    private ItemStack nameItem(Material item, String name){
        return nameItem(new ItemStack(item), name);
    }

}
