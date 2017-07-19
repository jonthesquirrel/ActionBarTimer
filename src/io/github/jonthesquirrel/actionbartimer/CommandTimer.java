package io.github.jonthesquirrel.actionbartimer;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandTimer implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("set")) {
                TimerManager.state = "running";
                TimerManager.time = CommandTimer.parseTime(args[1]);
                return true;
            }
            if (args[0].equalsIgnoreCase("clear")) {
                TimerManager.state = "stopped";
                TimerManager.time = 0;
                return true;
            }
            if (args[0].equalsIgnoreCase("pause")) {
                TimerManager.state = "paused";
                return true;
            }
            if (args[0].equalsIgnoreCase("unpause")) {
                TimerManager.state = "running";
                return true;
            }
            if (args[0].equalsIgnoreCase("plus")) {
                TimerManager.time += CommandTimer.parseTime(args[1]);
                return true;
            }
            if (args[0].equalsIgnoreCase("minus")) {
                TimerManager.time -= CommandTimer.parseTime(args[1]);
                return true;
            }
        }
        return false;
    }

    private static int parseTime(String time) {
        String[] hms = time.split(":");
        int hours = 0;
        int minutes = 0;
        int seconds = 0;
        if (hms.length >= 1) {
            seconds = Integer.parseInt(hms[hms.length - 1]);
        }
        if (hms.length >= 2) {
            minutes = Integer.parseInt(hms[hms.length - 2]);
        }
        if (hms.length >= 3) {
            hours = Integer.parseInt(hms[hms.length - 3]);
        }
        return (hours * 60 * 60) + (minutes * 60) + seconds;
    }

}
