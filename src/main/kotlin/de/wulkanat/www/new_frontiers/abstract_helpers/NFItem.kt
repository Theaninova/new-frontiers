package de.wulkanat.www.new_frontiers.abstract_helpers

import de.wulkanat.www.new_frontiers.NewFrontiers
import de.wulkanat.www.new_frontiers.proxy.registerItemRenderer
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.ActionResult
import net.minecraft.util.EnumHand
import net.minecraft.world.World

abstract class NFItem(
    name: String,
    creativeTab: CreativeTabs = de.wulkanat.www.new_frontiers.init.CreativeTabs.NF_ITEMS.value,
    val hasCustomModel: Boolean = true
) : Item() {
    init {
        setRegistryName("${NewFrontiers.MOD_ID}:$name")
        this.translationKey = name
        this.creativeTab = creativeTab
    }

    fun registerModels() {
        registerItemRenderer(this, 0, "inventory")
    }
}
