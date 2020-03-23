package de.wulkanat.www.new_frontiers.blocks

import de.wulkanat.www.new_frontiers.NewFrontiers
import de.wulkanat.www.new_frontiers.abstract_helpers.NFBlock
import net.minecraft.block.BlockHorizontal
import net.minecraft.block.material.Material

class SpaceshipController : NFBlock(
    name = "spaceship_controller",
    material = Material.GROUND,
    facingDirections = BlockHorizontal.FACING,

    onClick = {
        it.player.openGui(NewFrontiers, 0, it.world, it.pos.x, it.pos.y, it.pos.z)
        true
    }
)
