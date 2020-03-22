package de.wulkanat.www.new_frontiers.abstract_helpers

import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly

abstract class NFCreativeTabs(
    val name: String,
    val tabIcon: () -> Item,
    tabBackground: String? = null
) : CreativeTabs(name) {
    init {
        if (tabBackground != null)
            backgroundImageName = tabBackground
    }

    override fun getTabLabel(): String {
        return name
    }

    @SideOnly(Side.CLIENT)
    override fun createIcon(): ItemStack {
        return ItemStack(tabIcon())
    }
}
