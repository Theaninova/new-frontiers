package de.wulkanat.www.new_frontiers.proxy

import jdk.nashorn.internal.ir.Block
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.item.Item
import net.minecraft.util.ResourceLocation
import net.minecraftforge.client.model.ModelLoader

fun registerItemRenderer(item: Item, meta: Int, id: String) {
    ModelLoader.setCustomModelResourceLocation(item, meta, ModelResourceLocation(item.registryName as ResourceLocation, id))
}
