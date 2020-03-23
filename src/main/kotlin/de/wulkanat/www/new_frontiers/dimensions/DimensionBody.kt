package de.wulkanat.www.new_frontiers.dimensions

import de.wulkanat.www.new_frontiers.abstract_helpers.NFDimension
import net.minecraft.world.biome.Biome
import net.minecraft.world.biome.BiomeProviderSingle
import net.minecraft.world.gen.ChunkGeneratorOverworld

class DimensionBody : NFDimension(
    name = "planetary_body",
    id = 40001,
    canRespawn = true,
    surfaceDimension = true,
    biomeProvider = BiomeProviderSingle(Biome.getBiomeForId(29) as Biome)
) {
    override fun createChunkGenerator() = ChunkGeneratorOverworld(this.world, 19203, false, name)
}
