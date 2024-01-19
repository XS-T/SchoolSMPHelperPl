// EmeraldPickAxe Example
package org.crewco.helperplugin.Recipes

import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.crewco.helperplugin.PluginUtils.CustomRecipe

class EmeraldPickAxe : CustomRecipe(
        resultMaterial= Material.DIAMOND_PICKAXE,
        displayName="EmeraldPickaxe",
        shape=arrayOf("XXX", " S ", " S "),
        ingredients=mapOf('X' to Material.EMERALD, 'S' to Material.STICK),
        enchantments = mapOf(Enchantment.DIG_SPEED to 2),
        lore = listOf("Hello"),
        ammount = 1

)