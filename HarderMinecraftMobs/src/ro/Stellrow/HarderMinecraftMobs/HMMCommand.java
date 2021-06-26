package ro.Stellrow.HarderMinecraftMobs;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import ro.Stellrow.HarderMinecraftMobs.utils.Utils;

public class HMMCommand implements CommandExecutor {
    private final HMMobs pl;

    public HMMCommand(HMMobs pl) {
        this.pl = pl;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender.hasPermission("hm.mobs")){
            if (args.length==1&&args[0].equalsIgnoreCase("reload")){
                pl.updateData();
                sender.sendMessage(Utils.asColor("&aYou reloaded the config!"));
            }
            return true;
        }
        return true;
    }
}
