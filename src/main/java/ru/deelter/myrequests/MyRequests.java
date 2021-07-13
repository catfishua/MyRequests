package ru.deelter.myrequests;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import ru.deelter.myrequests.commands.Request;
import ru.deelter.myrequests.utils.MyRequest;
import ru.deelter.myrequests.utils.Other;

import java.io.File;

public final class MyRequests extends JavaPlugin {

    private static JavaPlugin instance;

    public static JavaPlugin getInstance() {
        return instance;
    }

    String[] LOGO =
            new String[]{
                    "§6 __  __       ____                            _",
                    "§6|  \\/  |_   _|  _ \\ ___  __ _ _   _  ___  ___| |_",
                    "§6| |\\/| | | | | |_) / _ \\/ _` | | | |/ _ \\/ __| __|",
                    "§6| |  | | |_| |  _ <  __/ (_| | |_| |  __/\\__ \\ |_ ",
                    "§6|_|  |_|\\__, |_| \\_\\___|\\__, |\\__,_|\\___||___/\\__|",
                    "§6        |___/              |_|"
            };

    @Override
    public void onEnable() {
        instance = this;

        File config = new File(instance.getDataFolder().getPath() + "/config.yml");
        if (!config.exists()) {
            Other.log("&cThe config doesn't exist. Create a new one");
            saveDefaultConfig();
        }
        Config.reload();
        MyRequest.load();
        getCommand("myrequest").setExecutor(new Request());

        /* Final console icon */
        for (String str : LOGO) {
            Bukkit.getLogger().info(str);
        }
        Bukkit.getLogger().info("");
        Bukkit.getLogger().info("BY DEELTER");
        Bukkit.getLogger().info("");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
