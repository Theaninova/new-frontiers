package de.wulkanat.www.new_frontiers.init

import de.wulkanat.www.new_frontiers.creativetabs.CreativeTabNFBlocks
import de.wulkanat.www.new_frontiers.abstract_helpers.NFCreativeTabs
import de.wulkanat.www.new_frontiers.creativetabs.CreativeTabNFItems

enum class CreativeTabs(val value: NFCreativeTabs) {
    NF_BLOCKS(CreativeTabNFBlocks()),
    NF_ITEMS(CreativeTabNFItems())
}
