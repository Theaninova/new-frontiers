package de.wulkanat.www.new_frontiers.commands

import de.wulkanat.www.new_frontiers.abstract_helpers.NFCommand
import de.wulkanat.www.new_frontiers.dimensions.teleporter.NFTeleporter
import net.minecraft.command.NumberInvalidException
import net.minecraft.util.math.MathHelper
import java.lang.NullPointerException

class CommandTPDim : NFCommand(
    name = "tpdim",
    usage = "<id> [<x> <y> <z>]",

    action = {
        when (it.command.size) {
            1, 4 -> {
                try {
                    val player = it.sender.commandSenderEntity
                    player?.changeDimension(parseInt(it.command[0]), NFTeleporter(it.server.getWorld(parseInt(it.command[0]))))
                    it.sender.sendMessage(textLine("Teleporting you to dimension ${it.command[0]}"))
                } catch (e: NumberInvalidException) {
                    it.sender.sendMessage(textLine("Invalid dimension '${it.command[0]}'"))
                }
            }
            else -> it.sender.sendMessage(textLine("<id> [<x> <y> <z>]"))
        }

    }
)
