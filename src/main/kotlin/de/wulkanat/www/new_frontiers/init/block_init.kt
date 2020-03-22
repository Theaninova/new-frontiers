package de.wulkanat.www.new_frontiers.init

import de.wulkanat.www.new_frontiers.blocks.BlockFTLDrive
import de.wulkanat.www.new_frontiers.abstract_helpers.NFBlock
import de.wulkanat.www.new_frontiers.blocks.BlockSpaceTeleporter

enum class Blocks(val value: NFBlock) {
    SPACE_TELEPORTER(BlockSpaceTeleporter()),
    FTL_DRIVE(BlockFTLDrive());
}
