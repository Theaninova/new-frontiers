package de.wulkanat.www.new_frontiers.abstract_helpers

import de.wulkanat.www.new_frontiers.MOD_ID
import de.wulkanat.www.new_frontiers.proxy.registerItemRenderer
import net.minecraft.block.Block
import net.minecraft.block.SoundType
import net.minecraft.block.material.Material
import net.minecraft.block.properties.PropertyDirection
import net.minecraft.block.state.IBlockState
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.Item
import net.minecraft.util.EnumFacing
import net.minecraft.util.EnumHand
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

abstract class NFBlock(
    val hasItemBlock: Boolean = true,
    val collidable: Boolean = true,
    val tickRate: Int = 10,
    val hasCustomModel: Boolean = true,
    val onClick: (ClickParameters) -> Boolean = { false },
    val facingDirections: PropertyDirection? = null,
    material: Material,
    hardness: Float = 1.0F,
    resistance: Float = 1.0F,
    lightLevel: Int = 0,
    lightOpacity: Int = 0,
    soundType: SoundType = SoundType.METAL,
    name: String,
    creativeTab: CreativeTabs = de.wulkanat.www.new_frontiers.init.CreativeTabs.NF_BLOCKS.value
) : Block(material) {
    init {
        // The Java code is a lot of hot garbage, so most of this is copied from the setter functions
        blockResistance = resistance * 3.0f

        blockHardness = hardness
        if (blockResistance < hardness * 5.0f) {
            blockResistance = hardness * 5.0f
        }

        setRegistryName("${MOD_ID}:$name")
        this.translationKey = name
        this.lightValue = lightLevel
        this.lightOpacity = lightOpacity
        this.creativeTab = creativeTab

        this.blockSoundType = soundType
    }

    override fun onBlockAdded(world: World, pos: BlockPos, state: IBlockState) {
        if (this.facingDirections != null && !world.isRemote) {
            val north = world.getBlockState(pos.north())
            val south = world.getBlockState(pos.south())
            val west = world.getBlockState(pos.west())
            val east = world.getBlockState(pos.east())
            var face = state.getValue(facingDirections) as EnumFacing

            when {
                face == EnumFacing.NORTH && north.isFullBlock && south.isFullBlock -> face = EnumFacing.SOUTH
                face == EnumFacing.SOUTH && north.isFullBlock && south.isFullBlock -> face = EnumFacing.NORTH
                face == EnumFacing.EAST && west.isFullBlock && east.isFullBlock -> face = EnumFacing.WEST
                face == EnumFacing.WEST && west.isFullBlock && east.isFullBlock -> face = EnumFacing.EAST
            }

            world.setBlockState(pos, state.withProperty(facingDirections, face), 2)
        }
    }

    override fun isCollidable(): Boolean {
        return collidable
    }

    override fun tickRate(p_tickRate_1_: World): Int {
        return tickRate
    }

    override fun onBlockActivated(world: World, pos: BlockPos, state: IBlockState, player: EntityPlayer, hand: EnumHand, face: EnumFacing, x: Float, y: Float, z: Float): Boolean {
        if (world.isRemote) return true

        return onClick(ClickParameters(world, pos, state, player, hand, face, x, y, z))
    }

    fun registerModels() {
        registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory")
    }

    class ClickParameters(
        val world: World,
        val pos: BlockPos,
        val state: IBlockState,
        val player: EntityPlayer,
        val hand: EnumHand,
        val face: EnumFacing,
        val x: Float,
        val y: Float,
        val z: Float
    )
}
