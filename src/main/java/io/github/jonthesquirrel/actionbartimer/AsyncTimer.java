package io.github.jonthesquirrel.actionbartimer;

import org.bukkit.scheduler.BukkitRunnable;

import java.time.Duration;

public class AsyncTimer extends BukkitRunnable {
    private final ActionBarTimer plugin;

    private static Duration time = Duration.ZERO;
    private static boolean paused = true;

    AsyncTimer(ActionBarTimer plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        if (time.isZero() || time.isNegative()) {
            if (time.isNegative()) {
                setTime(Duration.ZERO);
            }
            pause();
        } else {
            if (!paused) {
                removeTime(Duration.ofSeconds(1));
            }
            String message = paused ? Formatter.format(time) + " (paused)" : Formatter.format(time);
            new SyncActionBarSender(message).runTask(plugin);
        }
    }

    static void setTime(Duration d) {
        time = d;
    }
    static void addTime(Duration d) {
        time = time.plus(d);
    }
    static void removeTime(Duration d) {
        time = time.minus(d);
    }
    static void start() {
        paused = false;
    }
    static void pause() {
        paused = true;
    }
}
