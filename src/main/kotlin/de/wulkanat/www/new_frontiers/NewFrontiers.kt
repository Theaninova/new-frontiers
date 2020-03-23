package de.wulkanat.www.new_frontiers

import de.wulkanat.www.new_frontiers.init.*
import net.minecraft.block.Block
import net.minecraft.client.main.Main
import net.minecraft.item.Item
import net.minecraft.item.ItemBlock
import net.minecraftforge.client.event.ModelRegistryEvent
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import net.minecraftforge.fml.common.event.FMLServerStartingEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

@Mod(
    modid = MOD_ID,
    name = MOD_NAME,
    version = VERSION,
    modLanguageAdapter = "net.shadowfacts.forgelin.KotlinAdapter"
)
object NewFrontiers {
    @Mod.EventHandler
    fun preinit(event: FMLPreInitializationEvent) {
        // TODO: register world generator

        registerBiomes()
        registerDimensions()

        // TODO: register entities
    }

    @Mod.EventHandler
    fun init(event: FMLInitializationEvent) {

    }

    @Mod.EventHandler
    fun postinit(event: FMLPostInitializationEvent) {

    }

    @Mod.EventHandler
    fun start(event: FMLServerStartingEvent) {
        for (command in Commands.values()) {
            event.registerServerCommand(command.value)
        }
    }

    @Mod.EventBusSubscriber(modid = MOD_ID)
    object ObjectRegistryHandler {
        @SubscribeEvent
        @JvmStatic
        fun addItems(event: RegistryEvent.Register<Item>) {
            for (block in Blocks.values()) {
                if (block.value.hasItemBlock) {
                    event.registry.register(ItemBlock(block.value).setRegistryName(block.value.registryName))
                }
            }

            for (item in Items.values()) {
                event.registry.register(item.value)
            }
        }

        @SubscribeEvent
        @JvmStatic
        fun registerModels(event: ModelRegistryEvent) {
            for (item in Items.values()) {
                if (item.value.hasCustomModel) {
                    item.value.registerModels()
                }
            }

            for (block in Blocks.values()) {
                if (block.value.hasCustomModel) {
                    block.value.registerModels()
                }
            }
        }

        @SubscribeEvent
        @JvmStatic
        fun addBlocks(event: RegistryEvent.Register<Block>) {
            for (block in Blocks.values()) {
                event.registry.register(block.value)
            }
        }
    }
}
