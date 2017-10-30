package io.github.jonthesquirrel.actionbartimer;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.time.Duration;
import java.time.format.DateTimeParseException;

public class CommandTimer implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("set")) {
                try {
                    Duration d = Formatter.parse(args[1]);
                    AsyncTimer.setTime(d);
                    return true;
                } catch (DateTimeParseException e) {
                    return false;
                }
            }
            if (args[0].equalsIgnoreCase("add")) {
                try {
                    Duration d = Formatter.parse(args[1]);
                    AsyncTimer.addTime(d);
                    return true;
                } catch (DateTimeParseException e) {
                    return false;
                }
            }
            if (args[0].equalsIgnoreCase("remove")) {
                try {
                    Duration d = Formatter.parse(args[1]);
                    AsyncTimer.removeTime(d);
                    return true;
                } catch(DateTimeParseException e) {
                    return false;
                }
            }
            if (args[0].equalsIgnoreCase("start")) {
                AsyncTimer.start();
                return true;
            }
            if (args[0].equalsIgnoreCase("pause")) {
                AsyncTimer.pause();
                return true;
            }
            if (args[0].equalsIgnoreCase("stop")) {
                AsyncTimer.setTime(Duration.ZERO);
                return true;
            }
        }
        return false;
    }
}
