package net.gravitynetwork.gravitypblobby;

import net.gravitynetwork.gravitypblobby.util.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.PlayerInventory;

/**
 * Copyright (c) 2015-2016, ProtocollWeb/jesseke55/Jesse.
 */
public class Items implements Listener{
//TODO: Geef speler items en teleport naar spawn locatie van de hub

    public static void Playeritems(Player p){
        final FileConfiguration config = Main.getPlugin().getConfig();
        PlayerInventory pi = p.getInventory();

        pi.setArmorContents(null);

       pi.addItem(new ItemBuilder(Material.EMPTY_MAP).name(ChatColor.translateAlternateColorCodes('&', config.getString("Items.Lobby.About"))).getStack());




    }
}
