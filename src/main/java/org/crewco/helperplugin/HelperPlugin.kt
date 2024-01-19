package org.crewco.helperplugin

import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.plugin.java.JavaPlugin
import org.crewco.helperplugin.commands.reloadconfig
import org.crewco.helperplugin.PluginUtils.CommandRegistrar
import org.crewco.helperplugin.PluginUtils.CommandRegistrar.registerCommands
import org.crewco.helperplugin.PluginUtils.EventListenerRegistrar
import org.crewco.helperplugin.PluginUtils.EventListenerRegistrar.registerListeners
import org.crewco.helperplugin.PluginUtils.RecipeRegistrar
import org.crewco.helperplugin.PluginUtils.RecipeRegistrar.registerRecipes
import org.crewco.helperplugin.PluginUtils.RecipeRegistrar.loadRecipesFromConfig
import org.crewco.helperplugin.Recipes.EmeraldPickAxe
import org.crewco.helperplugin.listeners.CraftListeners.EmeraldPickaxeListener
import org.crewco.helperplugin.listeners.SleepListener
import org.crewco.helperplugin.listeners.freeze_listener
import java.util.UUID

class HelperPlugin : JavaPlugin() {
    companion object{
        lateinit var plugin: JavaPlugin
            private set
        lateinit var frozen_player: MutableMap<UUID,UUID>
        lateinit var fconfig: FileConfiguration

    }
    override fun onEnable() {
        super.onEnable()
        // Plugin startup logic

        //Intilizers
        CommandRegistrar.initialize(this)
        EventListenerRegistrar.initialize(this)
        RecipeRegistrar.initialize(this)
        plugin = this
        frozen_player = mutableMapOf()
        fconfig = plugin.config

        //register commands
        plugin.logger.info("Registering Commands")
        registerCommands(reloadconfig::class)
        plugin.logger.info("Registered Commands")

        //register events
        plugin.logger.info("Registering Listeners")
        registerListeners(freeze_listener::class,SleepListener::class,EmeraldPickaxeListener::class)
        plugin.logger.info("Registered Listeners")

        //Register Recipes
        plugin.logger.info("Registering Recipes")
        registerRecipes(EmeraldPickAxe::class)
        //Register Recipes from config
        loadRecipesFromConfig()
        plugin.logger.info("Registered Recipes")



        //Gen Config
        fconfig.options().copyDefaults(true)
        plugin.saveDefaultConfig()
    }


    override fun onDisable() {
        super.onDisable()
        // Plugin shutdown logic
    }
}