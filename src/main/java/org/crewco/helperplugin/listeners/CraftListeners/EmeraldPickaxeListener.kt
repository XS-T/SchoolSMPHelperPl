package org.crewco.helperplugin.listeners.CraftListeners

import org.bukkit.enchantments.Enchantment
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.CraftItemEvent

class EmeraldPickaxeListener:Listener {
    @EventHandler
    fun onCraft(e:CraftItemEvent){
        val item = e.recipe.result.itemMeta
        val clicked_item = e.currentItem
        if (item.displayName == "EmeraldPickaxe"){
            item.addEnchant(Enchantment.DIG_SPEED,10,true)
            item.addEnchant(Enchantment.DURABILITY,10,true)
            clicked_item.itemMeta = item
        }
    }
}