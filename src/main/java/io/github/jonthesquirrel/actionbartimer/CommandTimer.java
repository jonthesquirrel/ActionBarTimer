package io.github.jonthesquirrel.actionbartimer;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.time.Duration;

public class CommandTimer implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("set")) {
                AsyncTimer.setTime(Formatter.parse(args[1]));
                //TODO return false if formatter fails to parse string (bad format)?
                return true;
            }
            if (args[0].equalsIgnoreCase("add")) {
                AsyncTimer.addTime(Formatter.parse(args[1]));
                return true;
            }
            if (args[0].equalsIgnoreCase("remove")) {
                AsyncTimer.removeTime(Formatter.parse(args[1]));
                return true;
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
