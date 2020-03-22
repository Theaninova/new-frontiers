package de.wulkanat.www.new_frontiers.dimensions.chunkgen

import net.minecraft.entity.EnumCreatureType
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import net.minecraft.world.biome.Biome
import net.minecraft.world.chunk.Chunk
import net.minecraft.world.gen.IChunkGenerator

class VoidChunkGenerator(
    private val world: World
) : IChunkGenerator {
    override fun generateStructures(p0: Chunk, p1: Int, p2: Int): Boolean {
        return false
    }

    override fun getPossibleCreatures(p0: EnumCreatureType, p1: BlockPos): MutableList<Biome.SpawnListEntry> {
        return arrayListOf()
    }

    override fun populate(p0: Int, p1: Int) {
        // noop
    }

    override fun recreateStructures(p0: Chunk, p1: Int, p2: Int) {
        // noop
    }

    override fun getNearestStructurePos(p0: World, p1: String, p2: BlockPos, p3: Boolean): BlockPos? {
        return null
    }

    override fun generateChunk(p0: Int, p1: Int): Chunk {
        return Chunk(world, p0, p1)
    }

    override fun isInsideStructure(p0: World, p1: String, p2: BlockPos): Boolean {
        return false
    }
}
