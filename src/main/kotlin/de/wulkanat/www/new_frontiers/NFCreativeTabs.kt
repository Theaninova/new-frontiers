package de.wulkanat.www.new_frontiers

import net.minecraft.creativetab.CreativeTabs
import net.minecraft.init.Blocks
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly

class NFCreativeTabs : CreativeTabs("new_frontiers") {
    override fun getTabLabel(): String {
        return "new_frontiers"
    }

    @SideOnly(Side.CLIENT)
    override fun createIcon(): ItemStack {
        return ItemStack(Item.getItemFromBlock(NewFrontiers.ObjectRegistryHandler.blocks[0]))
    }
}
