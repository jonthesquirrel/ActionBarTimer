package io.github.jonthesquirrel.actionbartimer;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("timer").setExecutor(new CommandTimer());

        this.getServer().getScheduler().runTaskTimer(this, new Runnable() {
            @Override
            public void run() {
                TimerManager.tick();
            }
        }, 0 , 20);
    }

    @Override
    public void onDisable() {

    }

}
