package de.wulkanat.www.new_frontiers.dimensions

import de.wulkanat.www.new_frontiers.abstract_helpers.NFDimension
import de.wulkanat.www.new_frontiers.dimensions.chunkgen.VoidChunkGenerator
import de.wulkanat.www.new_frontiers.init.Biomes
import net.minecraft.world.biome.BiomeProviderSingle
import net.minecraft.world.gen.IChunkGenerator

class DimensionSpace : NFDimension(
    name = "space",
    id = 40000,
    canRespawn = true,
    surfaceDimension = false,
    biomeProvider = BiomeProviderSingle(Biomes.DEEP_SPACE.value)
) {
    override fun createChunkGenerator() = VoidChunkGenerator(this.world)
}
