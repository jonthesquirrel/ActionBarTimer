package io.github.jonthesquirrel.actionbartimer;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("timer").setExecutor(new CommandTimer());
    }

    @Override
    public void onDisable() {

    }

}
