package com.rizerman.heal.event.player;

import net.minecraft.server.v1_11_R1.ChatBaseComponent;
import net.minecraft.server.v1_11_R1.IChatBaseComponent;
import net.minecraft.server.v1_11_R1.PacketPlayOutTitle;
import net.minecraft.server.v1_11_R1.PlayerConnection;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.rizerman.heal.main;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener{

    private main plugin;

    public PlayerJoin(main pl){
        plugin = pl;
    }

    @EventHandler
    public void onPlayerJoin (PlayerJoinEvent event){
        String welcomeMessage = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Welcome Message"));

        Player player = event.getPlayer();

        player.sendMessage(welcomeMessage);

        /*PacketPlayOutTitle welcomeTitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE,
                ChatBaseComponent.ChatSerializer.a("{\"text\":\"Welcome to the server!\",\"color\":\"gold\",\"bold\":true}"), 20, 40, 30 );
        PacketPlayOutTitle welcomeSubtitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE,
                ChatBaseComponent.ChatSerializer.a(",{\"text\":\"Enjoy your stay\",\"italic\":true,\"underlined\":true}"), 20, 40, 30 );

        PlayerConnection connection = ((CraftPlayer)player).getHandle().playerConnection;
        connection.sendPacket(welcomeTitle);
        connection.sendPacket(welcomeSubtitle);
        */
    }

}
