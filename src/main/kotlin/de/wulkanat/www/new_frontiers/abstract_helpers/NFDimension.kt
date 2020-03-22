package de.wulkanat.www.new_frontiers.abstract_helpers

import net.minecraft.world.DimensionType
import net.minecraft.world.WorldProvider
import net.minecraft.world.biome.BiomeProvider
import net.minecraft.world.gen.IChunkGenerator

abstract class NFDimension(
    private val canRespawn: Boolean = true,
    private val surfaceDimension: Boolean = false,
    val name: String,
    val id: Int,
    biomeProvider: BiomeProvider
) : WorldProvider() {
    init {
        this.biomeProvider = biomeProvider
    }

    private val dimType: DimensionType = DimensionType.register(name, "_${name.toLowerCase()}", id, this.javaClass, false)

    override fun getDimensionType(): DimensionType? {
        return dimType
    }

    abstract override fun createChunkGenerator(): IChunkGenerator

    override fun canRespawnHere(): Boolean {
        return canRespawn
    }

    override fun isSurfaceWorld(): Boolean {
        return surfaceDimension
    }
}
