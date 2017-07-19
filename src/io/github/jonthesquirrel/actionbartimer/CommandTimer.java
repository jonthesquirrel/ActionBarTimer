package io.github.jonthesquirrel.actionbartimer;

import com.connorlinfoot.actionbarapi.ActionBarAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTimer implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("set")) {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    ActionBarAPI.sendActionBar(player,"test", 20);
                }
                return true;
            }
            if (args[0].equalsIgnoreCase("clear")) {
                return true;
            }
            if (args[0].equalsIgnoreCase("pause")) {
                return true;
            }
            if (args[0].equalsIgnoreCase("unpause")) {
                return true;
            }
            if (args[0].equalsIgnoreCase("add")) {
                return true;
            }
            if (args[0].equalsIgnoreCase("remove")) {
                return true;
            }
        }
        return false;
    }

}
