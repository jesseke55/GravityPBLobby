package net.gravitynetwork.gravitypblobby;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

/**
 * Copyright (c) 2015-2016, ProtocollWeb/jesseke55/Jesse.
 */
public class AllEvents implements Listener {

    @EventHandler
    public void onEvent(Event e) {
        FileConfiguration config = Main.getPlugin().getConfig();
        if (e instanceof BlockBreakEvent) {
            BlockBreakEvent bbe = (BlockBreakEvent) e;

            if (bbe.getPlayer().getWorld() == Bukkit.getWorld("world")) {
                bbe.setCancelled(true);
            }
        } else if (e instanceof BlockPlaceEvent) {
            BlockPlaceEvent bpe = (BlockPlaceEvent) e;

            if (bpe.getPlayer().getWorld() == Bukkit.getWorld("world")) {
                bpe.setCancelled(true);
            }
        }
        else if (e instanceof PlayerDropItemEvent) {
            PlayerDropItemEvent playerDropItemEvent = (PlayerDropItemEvent) e;
            if (playerDropItemEvent.getPlayer().getWorld() == Bukkit.getWorld("world")) {
                playerDropItemEvent.setCancelled(true);
            }
        }
        else if(e instanceof FoodLevelChangeEvent){
         FoodLevelChangeEvent foodlevelchange = (FoodLevelChangeEvent) e;
            if(foodlevelchange.getEntity().getWorld() == Bukkit.getWorld("world")){
                foodlevelchange.setCancelled(true);
            }
        }
        else if(e instanceof PlayerDeathEvent){
            PlayerDeathEvent death = (PlayerDeathEvent) e;
            death.setKeepInventory(false);
            death.getDrops().clear();
            death.setDeathMessage(null);
            death.getEntity().spigot().respawn();
        }
        else if (e instanceof PlayerJoinEvent){
            PlayerJoinEvent join = (PlayerJoinEvent) e;
            join.setJoinMessage(null);
        }
        else if(e instanceof PlayerRespawnEvent){
            PlayerRespawnEvent respawn = (PlayerRespawnEvent) e;
            Player p = respawn.getPlayer();
            Items.Playeritems(p);
        }
        else if(e instanceof PlayerJoinEvent){

            PlayerJoinEvent join = (PlayerJoinEvent) e;
            Player p = join.getPlayer();



            Items.Playeritems(p);
            join.setJoinMessage(null);

            if(p.hasPermission(config.getString("JoinMSG.Owner.permission"))){
                join.setJoinMessage(ChatColor.translateAlternateColorCodes('&', config.getString("JoinMSG.Owner.MSG").replace("%p", p.getName())));
            }
        }

        else if (e instanceof PlayerQuitEvent){
            PlayerQuitEvent quit = (PlayerQuitEvent) e;

            quit.setQuitMessage(null);

        }
    }
}
