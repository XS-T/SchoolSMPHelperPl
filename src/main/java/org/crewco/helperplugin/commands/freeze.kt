package org.crewco.helperplugin.commands

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.crewco.helperplugin.HelperPlugin.Companion.frozen_player

class freeze : CommandExecutor {
    override fun onCommand(player: CommandSender?, p1: Command?, p2: String?, p3: Array<out String>?): Boolean {
        if (player is Player) {
            // Check if there are arguments and at least one element
            if (!player.hasPermission("smp.freeze") || !player.isOp){return false}
            if (p3 != null && p3.isNotEmpty()) {
                val target = Bukkit.getPlayer(p3[0])
                // Rest of your logic with the target
                player.sendMessage("Freezing ${target?.name ?: "unknown player"}")
                if (!frozen_player.containsKey(player.uniqueId)){
                    frozen_player[player.uniqueId] = target.uniqueId
                    target.sendMessage("${ChatColor.RED} You have been frozen by ${player.displayName}.")
                }else{
                    frozen_player.remove(player.uniqueId)
                    player.sendMessage("UnFreezing ${target?.name ?: "unknown player"}")
                    target.sendMessage("${ChatColor.GREEN} You have been unfrozen.")
                }
            } else {
                // Handle case when arguments are not provided
                player.sendMessage("Usage: /freeze <player>")
            }
        }
        return true
    }
}