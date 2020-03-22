package de.wulkanat.www.new_frontiers.biomes

import de.wulkanat.www.new_frontiers.abstract_helpers.NFBiome
import net.minecraft.block.BlockClay
import net.minecraft.block.BlockStone
import net.minecraftforge.common.BiomeDictionary
import net.minecraftforge.common.BiomeManager

class BiomeDeepSpace : NFBiome(
    name = "deep_space",
    biomeType = BiomeManager.BiomeType.COOL,
    types = arrayOf(BiomeDictionary.Type.VOID),
    rain = false,
    snow = false,
    temperature = 0F,
    topBlock = BlockStone().defaultState,
    fillerBlock = BlockClay().defaultState
)
