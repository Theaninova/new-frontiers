package de.wulkanat.www.newfrontiers.blocks

import net.minecraft.block.material.Material
import net.minecraft.creativetab.CreativeTabs

class SpaceTeleporter(modid: String, name: String) : NFBlock(Material.GROUND) {
    init {
        setHardness(1.5F)
        setResistance(2.5F)
        setRegistryName("$modid:$name")
        creativeTab = CreativeTabs.BUILDING_BLOCKS
    }
}
