package de.wulkanat.www.new_frontiers.init

import de.wulkanat.www.new_frontiers.blocks.BlockFTLDrive
import de.wulkanat.www.new_frontiers.abstract_helpers.NFBlock
import de.wulkanat.www.new_frontiers.blocks.BlockSpaceTeleporter
import de.wulkanat.www.new_frontiers.blocks.SpaceshipController

enum class Blocks(val value: NFBlock) {
    SPACE_TELEPORTER(BlockSpaceTeleporter()),
    FTL_DRIVE(BlockFTLDrive()),
    SPACESHIP_CONTROLLER(SpaceshipController())
}
