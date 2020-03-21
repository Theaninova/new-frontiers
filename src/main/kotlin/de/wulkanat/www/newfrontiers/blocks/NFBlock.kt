package de.wulkanat.www.newfrontiers.blocks

import net.minecraft.block.Block
import net.minecraft.block.material.Material

abstract class NFBlock(material: Material) : Block(material) {
    val hasItemBlock = true
}
