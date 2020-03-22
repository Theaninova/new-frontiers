package de.wulkanat.www.new_frontiers.init

import de.wulkanat.www.new_frontiers.biomes.BiomeDeepSpace
import de.wulkanat.www.new_frontiers.abstract_helpers.NFBiome
import net.minecraft.world.biome.Biome
import net.minecraftforge.common.BiomeDictionary
import net.minecraftforge.common.BiomeManager
import net.minecraftforge.fml.common.registry.ForgeRegistries

enum class Biomes(val value: NFBiome) {
    DEEP_SPACE(BiomeDeepSpace())
}

fun registerBiomes() {
    for (biome in Biomes.values()) {
        initBiome(biome.value, biome.value.name, biome.value.biomeType, *biome.value.types)
    }
}

fun initBiome(biome: Biome, name: String, biomeType: BiomeManager.BiomeType, vararg types: BiomeDictionary.Type): Biome {
    biome.setRegistryName(name)
    ForgeRegistries.BIOMES.register(biome)
    BiomeDictionary.addTypes(biome, *types)
    BiomeManager.addBiome(biomeType, BiomeManager.BiomeEntry(biome, 10))
    BiomeManager.addSpawnBiome(biome)
    return biome
}
