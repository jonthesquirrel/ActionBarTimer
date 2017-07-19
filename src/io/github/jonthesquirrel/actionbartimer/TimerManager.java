package io.github.jonthesquirrel.actionbartimer;

import com.connorlinfoot.actionbarapi.ActionBarAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

class TimerManager {

    //remaining time
    static int time = 0;
    static String state = "stopped";

    static void tick() {
        // if state equals "stopped" do nothing
        if (TimerManager.state.equals("running")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                ActionBarAPI.sendActionBar(player, TimerManager.formatTime(TimerManager.time));
            }
            if (TimerManager.time > 0) {
                TimerManager.time--;
            } else {
                TimerManager.state = "stopped";
            }
        } else if (TimerManager.state.equals("paused")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                ActionBarAPI.sendActionBar(player, TimerManager.formatTime(TimerManager.time));
            }
        }
    }

    private static String formatTime(int time) {
        //time is in seconds
        int hours = Math.floorDiv(time, 60 * 60) % 60;
        int minutes = Math.floorDiv(time, 60) % 60;
        int seconds = time % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

}
