package org.crewco.helperplugin.listeners

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerMoveEvent
import org.crewco.helperplugin.HelperPlugin.Companion.frozen_player

class freeze_listener:Listener {
    @EventHandler
    fun onFreeze(e:PlayerMoveEvent){
        if (frozen_player.containsKey(e.player.uniqueId)){
            e.isCancelled = true
        }
    }
}