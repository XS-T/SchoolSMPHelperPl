package org.crewco.helperplugin

import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin
import org.crewco.helperplugin.PluginUtils.CommandRegistrar
import org.crewco.helperplugin.PluginUtils.CommandRegistrar.registerCommands
import org.crewco.helperplugin.PluginUtils.EventListenerRegistrar
import org.crewco.helperplugin.PluginUtils.EventListenerRegistrar.registerListeners
import org.crewco.helperplugin.commands.freeze
import org.crewco.helperplugin.listeners.SleepListener
import org.crewco.helperplugin.listeners.freeze_listener
import java.util.UUID

class HelperPlugin : JavaPlugin() {
    companion object{
        lateinit var plugin: JavaPlugin
            private set
        lateinit var frozen_player: MutableMap<UUID,UUID>

    }
    override fun onEnable() {
        super.onEnable()
        // Plugin startup logic

        //Intilizers
        CommandRegistrar.initialize(this)
        EventListenerRegistrar.initialize(this)
        plugin = this
        frozen_player = mutableMapOf()

        //register commands
        plugin.logger.info("Registering Commands")
        registerCommands(freeze::class)
        plugin.logger.info("Registered Commands")

        //register events
        plugin.logger.info("Registering Listeners")
        registerListeners(freeze_listener::class,SleepListener::class)
        plugin.logger.info("Registered Listeners")
    }


    override fun onDisable() {
        super.onDisable()
        // Plugin shutdown logic
    }
}