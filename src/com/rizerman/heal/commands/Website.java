package com.rizerman.heal.commands;

import net.minecraft.server.v1_11_R1.IChatBaseComponent;
import net.minecraft.server.v1_11_R1.PacketPlayOutChat;
import net.minecraft.server.v1_11_R1.PlayerConnection;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Website implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("You must be a player to execute this command!");
            return false;
        }

        Player player = (Player) sender;
        PlayerConnection connection = ((CraftPlayer)player).getHandle().playerConnection;
        PacketPlayOutChat packet = new PacketPlayOutChat(IChatBaseComponent.ChatSerializer.a("{\"text\":\"Click here to view the server info\",\"clickEvent\":{\"action\":\"open_url\",\"value\":\"http://google.nl\"},\"hoverEvent\":{\"action\":\"show_text\",\"value\":{\"text\":\"\",\"extra\":[{\"text\":\"CLICK ME! \"}]}}}"));

        sender.sendMessage(ChatColor.GOLD + "################################");
        connection.sendPacket(packet);
        sender.sendMessage(ChatColor.GOLD + "################################");

        return true;
    }
}
