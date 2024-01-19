package org.crewco.helperplugin.listeners

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.World
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerBedEnterEvent
import org.bukkit.event.player.PlayerBedLeaveEvent

class SleepListener : Listener {

    @EventHandler
    fun onPlayerBedEnter(event: PlayerBedEnterEvent) {
        val player =  event.player
        val bed = event.bed
        checkSleep(bed.world,player)
    }

    @EventHandler
    fun onPlayerBedLeave(e: PlayerBedLeaveEvent){
        val player = e.player
        player.bedSpawnLocation = player.location
    }

    private fun isInNether(worldName: String): Boolean {
        return worldName.equals("world_nether", ignoreCase = true) // Adjust world name as needed
    }

    private fun checkSleep(world: World,player: Player) {
        // Count the number of sleeping players
        var sleepingPlayers = 0
        for (onlinePlayer in Bukkit.getOnlinePlayers()) {
            if (!onlinePlayer.isSleeping) {
                sleepingPlayers++
            }else{
                //onlinePlayer.sendMessage("Is Sleeping?: ${onlinePlayer.isSleeping}")
            }
        }

        // Skip the night if at least one player is sleeping
        if (sleepingPlayers > 0) {
            // Broadcast a message indicating that the night is skipped
            world.time = 0 // Set time to morning
            player.sendMessage("${ChatColor.YELLOW}The night is skipped thanks to a player sleeping!)")
        }
    }
}