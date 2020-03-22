package de.wulkanat.www.new_frontiers.dimensions

import net.minecraft.world.DimensionType
import net.minecraft.world.WorldProvider
import net.minecraft.world.gen.IChunkGenerator

abstract class NFDimension(
    private val canRespawn: Boolean = true,
    private val surfaceDimension: Boolean = false
) : WorldProvider() {
    abstract override fun getDimensionType(): DimensionType
    abstract override fun createChunkGenerator(): IChunkGenerator

    override fun canRespawnHere(): Boolean {
        return canRespawn
    }

    override fun isSurfaceWorld(): Boolean {
        return surfaceDimension
    }
}
