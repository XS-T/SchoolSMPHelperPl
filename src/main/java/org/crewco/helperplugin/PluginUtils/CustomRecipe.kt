// CustomRecipe
package org.crewco.helperplugin.PluginUtils

import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta
import org.bukkit.plugin.java.JavaPlugin

open class CustomRecipe(
        private val resultMaterial: Material,
        private val displayName: String,
        private val shape: Array<String>,
        private val ingredients: Map<Char, Material>,
        private val enchantments: Map<Enchantment, Int>? = null,
        private val lore: List<String>? = null,
        private val ammount: Int? = null
) {

    fun register(recipeManager: RecipeManager) {
        recipeManager.createCustomRecipe(resultMaterial, displayName, shape, ingredients, enchantments, lore,ammount)
    }
}