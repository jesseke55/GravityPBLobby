package net.gravitynetwork.gravitypblobby;

import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Copyright (c) 2015-2016, ProtocollWeb/jesseke55/Jesse.
 */
public class Main extends JavaPlugin implements Listener{

    private static Plugin plugin;
    public static Plugin getPlugin(){
        return plugin;
    }

    public void onEnable(){
        Main.plugin = this;
        initConfig();
    }
    public void onDisable(){
        Main.plugin=null;
    }








    private void initConfig(){
        getConfig().addDefault("Items.Lobby.About", "&bAbout PaintBall");


        getConfig().options().copyDefaults(true);
        saveConfig();
    }




    //TODO: Voeg anti WDL toe
}
