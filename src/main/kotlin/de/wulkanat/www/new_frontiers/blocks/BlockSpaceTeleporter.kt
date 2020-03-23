package de.wulkanat.www.new_frontiers.blocks

import de.wulkanat.www.new_frontiers.abstract_helpers.NFBlock
import net.minecraft.block.material.Material
import net.minecraft.entity.player.EntityPlayerMP

class BlockSpaceTeleporter : NFBlock(
    material = Material.GROUND,
    hardness = 1.5F,
    resistance = 2.5F,
    lightLevel = 15,
    name = "space_teleporter",

    onClick = {
        if (it.player is EntityPlayerMP) {
            it.player.changeDimension(40000)
            it.player.setPositionAndUpdate(0.0, 0.0, 0.0)
            true
        } else {
            false
        }
    }
)
