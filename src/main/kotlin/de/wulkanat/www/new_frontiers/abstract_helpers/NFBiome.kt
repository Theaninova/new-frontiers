package de.wulkanat.www.new_frontiers.abstract_helpers

import net.minecraft.block.state.IBlockState
import net.minecraft.world.biome.Biome
import net.minecraftforge.common.BiomeDictionary
import net.minecraftforge.common.BiomeManager

abstract class NFBiome(
    val name: String,
    val biomeType: BiomeManager.BiomeType,
    val types: Array<BiomeDictionary.Type>,
    baseHeight: Float = 1.0F,
    heightVariation: Float = 1.0F,
    temperature: Float = 0.5F,
    rainFrequency: Float = 0.6F,
    rain: Boolean = true,
    snow: Boolean = false,
    waterColor: Int = 16711680,
    topBlock: IBlockState,
    fillerBlock: IBlockState,
    spawnableCaveCreatureList: List<SpawnListEntry> = arrayListOf(),
    spawnableCreatureList: List<SpawnListEntry> = arrayListOf(),
    spawnableMonsterList: List<SpawnListEntry> = arrayListOf(),
    spawnableWaterCreatureList: List<SpawnListEntry> = arrayListOf()
) : Biome(setRainAndSnow(BiomeProperties(name)
    .setBaseHeight(baseHeight)
    .setHeightVariation(heightVariation)
    .setTemperature(temperature)
    .setRainfall(rainFrequency)
    .setWaterColor(waterColor), rain, snow)) {
    init {
        this.topBlock = topBlock
        this.fillerBlock = fillerBlock

        this.spawnableCaveCreatureList = spawnableCaveCreatureList
        this.spawnableCreatureList = spawnableCreatureList
        this.spawnableMonsterList = spawnableMonsterList
        this.spawnableWaterCreatureList = spawnableWaterCreatureList

        // TODO: decorator
    }

    companion object {
        private fun setRainAndSnow(properties: BiomeProperties, rain: Boolean, snow: Boolean): BiomeProperties {
            if (!rain)
                properties.setRainDisabled()
            if (snow)
                properties.setSnowEnabled()

            return properties
        }
    }
}
