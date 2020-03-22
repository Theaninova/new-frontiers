package de.wulkanat.www.new_frontiers.init

import de.wulkanat.www.new_frontiers.blocks.BlockFTLDrive
import de.wulkanat.www.new_frontiers.abstract_helpers.NFBlock
import de.wulkanat.www.new_frontiers.blocks.BlockSpaceTeleporter

enum class Blocks(value: NFBlock) {
    SPACE_TELEPORTER(BlockSpaceTeleporter()),
    FTL_DRIVE(BlockFTLDrive());

    val value: NFBlock by lazy {
        value
    }
}

class B(val a: String) {
    init {
        println("B Created")
    }
}

class A(a: B) {
    val b by lazy {
        a
    }
}

fun main() {
    val a = A(B("something"))

    println(a.b)
}
