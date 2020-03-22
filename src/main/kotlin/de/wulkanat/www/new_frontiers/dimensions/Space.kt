package de.wulkanat.www.new_frontiers.dimensions

import net.minecraft.world.DimensionType
import net.minecraft.world.gen.IChunkGenerator

class Space : NFDimension(
    canRespawn = true,
    surfaceDimension = false
) {
    override fun getDimensionType(): DimensionType {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createChunkGenerator(): IChunkGenerator {
        TODO("not implemented")
    }
}
