package de.wulkanat.www.new_frontiers.init

import de.wulkanat.www.new_frontiers.abstract_helpers.NFCommand
import de.wulkanat.www.new_frontiers.commands.CommandTPDim

enum class Commands(val value: NFCommand) {
    TP_DIM(CommandTPDim())
}
