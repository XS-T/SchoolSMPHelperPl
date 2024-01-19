// RecipeReloadCommand.kt
package org.crewco.helperplugin.commands

import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandException
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.crewco.helperplugin.HelperPlugin.Companion.plugin
import org.crewco.helperplugin.PluginUtils.RecipeRegistrar.loadRecipesFromConfig

class reloadconfig : CommandExecutor {
    override fun onCommand(sender: CommandSender, cmd: Command, label: String, args: Array<out String>): Boolean {
        if (cmd.name.equals("reloadconfig", ignoreCase = true)) {
            plugin.reloadConfig()
            sender.sendMessage(ChatColor.GREEN.toString() + "Config reloaded.")
            try {
                loadRecipesFromConfig()
            }catch (e:CommandException){
                sender.sendMessage("Error in Recipe")
            }
            return true
        }
        return false
    }
}