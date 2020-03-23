package de.wulkanat.www.new_frontiers.dimensions.teleporter

import net.minecraft.entity.Entity
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.MathHelper
import net.minecraft.world.Teleporter
import net.minecraft.world.WorldServer

class NFTeleporter(private val worldInstance: WorldServer) : Teleporter(worldInstance) {
    override fun placeInPortal(entity: Entity, p5: Float) {
        val i = MathHelper.floor(entity.posX)
        val j = MathHelper.floor(entity.posY)
        val k = MathHelper.floor(entity.posZ)

        // Dummy chunk loading
        worldInstance.getChunk(BlockPos(i, j, k))
        val height = worldInstance.getHeight(i, k)
        entity.setPosition(i.toDouble(), j.toDouble(), k.toDouble())
    }
}
