package io.github.jonthesquirrel.actionbartimer;

import io.github.theluca98.textapi.ActionBar;
import org.bukkit.scheduler.BukkitRunnable;

public class SyncActionBarSender extends BukkitRunnable {
    private String message;

    SyncActionBarSender(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        new ActionBar(message).sendToAll();
    }
}
