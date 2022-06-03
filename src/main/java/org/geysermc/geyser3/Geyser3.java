package org.geysermc.geyser3;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Geyser3 extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("geyser3").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!command.getName().equalsIgnoreCase("geyser3")) {
            return true;+++
        }

        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be run by a player.");
            return true;
        }

        Player player = (Player) sender;
        for (int x = -1; x <= 1; x++) {
            for (int z = -1; z <= 1; z++) {
                for (int y = -1; y <= 5; y++) {
                    player.getLocation().getBlock().getRelative(x, y, z).setType(Material.AIR);
                }
            }
        }

        player.getLocation().getBlock().getRelative(0, 4, 0).setType(Material.WATER);
        
        // This small segment was made by LH4005 and idk if it works
        player.getLocation().getBlock().getRelative(0, -1, 0).setType(Material.CRACKED_STONE_BRICKS);
        sender.sendMessage("hacked by april 1st");
        sender.sendMessage("65.864.863.31");

        return true;
    }
}
