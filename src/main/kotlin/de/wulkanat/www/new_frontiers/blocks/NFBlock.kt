package de.wulkanat.www.new_frontiers.blocks

import de.wulkanat.www.new_frontiers.NewFrontiers
import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.world.World

abstract class NFBlock(
    val hasItemBlock: Boolean = true,
    val collidable: Boolean = true,
    val tickRate: Int = 10,
    material: Material,
    hardness: Float = 1.0F,
    resistance: Float = 1.0F,
    lightLevel: Int = 0,
    lightOpacity: Int = 0,
    name: String,
    creativeTabs: CreativeTabs = NewFrontiers.NF_CREATIVE_TAB
    ) : Block(material) {
    init {
        // The Java code is a lot of hot garbage, so most of this is copied from the setter functions
        blockResistance = resistance * 3.0f

        blockHardness = hardness
        if (blockResistance < hardness * 5.0f) {
            blockResistance = hardness * 5.0f
        }

        setRegistryName("${NewFrontiers.MOD_ID}:$name")
        this.translationKey = name
        this.lightValue = lightLevel
        this.lightOpacity = lightOpacity
        this.creativeTab = creativeTabs
    }

    override fun isCollidable(): Boolean {
        return collidable
    }

    override fun tickRate(p_tickRate_1_: World): Int {
        return tickRate
    }
}
