package de.wulkanat.www.new_frontiers.abstract_helpers

import net.minecraft.block.state.IBlockState
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import net.minecraft.world.biome.Biome
import net.minecraft.world.chunk.ChunkPrimer
import net.minecraftforge.common.BiomeDictionary
import net.minecraftforge.common.BiomeManager
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import java.util.*

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
    spawnableWaterCreatureList: List<SpawnListEntry> = arrayListOf(),

    val decorate: (decorateParams: DecorateParams) -> Unit = {},
    val genTerrainBlocks: (genTerrainBlocksParams: GenTerrainBlocksParams) -> Unit = {},
    val skyColorByTemp: (currentTemperature: Float) -> Int = { 0x000000 },
    val grassColorAtPos: (pos: BlockPos) -> Int = { 0x000000 },
    val foliageColorAtPos: (pos: BlockPos) -> Int = { 0x000000 }
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

    override fun decorate(world: World, rand: Random, pos: BlockPos) {
        decorate(DecorateParams(world, rand, pos, this))
    }

    override fun genTerrainBlocks(world: World, rand: Random, chunkPrimer: ChunkPrimer, x: Int, z: Int, noiseVal: Double) {
        genTerrainBlocks(GenTerrainBlocksParams(world, rand, chunkPrimer, x, z, noiseVal))
    }

    @SideOnly(Side.CLIENT)
    override fun getSkyColorByTemp(temp: Float): Int {
        return skyColorByTemp(temp)
    }

    @SideOnly(Side.CLIENT)
    override fun getGrassColorAtPos(pos: BlockPos): Int {
        return grassColorAtPos(pos)
    }

    @SideOnly(Side.CLIENT)
    override fun getFoliageColorAtPos(pos: BlockPos): Int {
        return foliageColorAtPos(pos)
    }

    class GenTerrainBlocksParams(
        val world: World,
        val rand: Random,
        val chunkPrimer: ChunkPrimer,
        val x: Int,
        val z: Int,
        val noiseVal: Double
    )

    class DecorateParams(
        val world: World,
        val rand: Random,
        val pos: BlockPos,
        val biomeInstance: NFBiome
    )
}
