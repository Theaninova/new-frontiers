package de.wulkanat.www.new_frontiers.creativetabs

import de.wulkanat.www.new_frontiers.abstract_helpers.NFCreativeTabs
import de.wulkanat.www.new_frontiers.init.Blocks
import net.minecraft.item.Item

class CreativeTabNFBlocks : NFCreativeTabs(
    name = "nf_blocks",
    tabIcon = { Item.getItemFromBlock(Blocks.SPACE_TELEPORTER.value) }
)
