package de.wulkanat.www.new_frontiers.blocks

import de.wulkanat.www.new_frontiers.abstract_helpers.NFBlock
import net.minecraft.block.material.Material

class BlockSpaceTeleporter : NFBlock(
    material = Material.GROUND,
    hardness = 1.5F,
    resistance = 2.5F,
    lightLevel = 15,
    name = "space_teleporter"
)
