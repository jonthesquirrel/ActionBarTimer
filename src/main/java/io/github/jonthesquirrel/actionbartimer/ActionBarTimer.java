package io.github.jonthesquirrel.actionbartimer;

import org.bukkit.plugin.java.JavaPlugin;

public class ActionBarTimer extends JavaPlugin {
    @Override
    public void onEnable() {
        getCommand("timer").setExecutor(new CommandTimer());
        new AsyncTimer(this).runTaskTimerAsynchronously(this, 0L, 20L);
    }
}
