package de.wulkanat.www.new_frontiers

import de.wulkanat.www.new_frontiers.blocks.FTLDrive
import de.wulkanat.www.new_frontiers.blocks.NFBlock
import de.wulkanat.www.new_frontiers.blocks.SpaceTeleporter
import de.wulkanat.www.new_frontiers.dimensions.Space
import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraft.item.ItemBlock
import net.minecraft.world.DimensionType
import net.minecraftforge.common.DimensionManager
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

@Mod(
    modid = NewFrontiers.MOD_ID,
    name = NewFrontiers.MOD_NAME,
    version = NewFrontiers.VERSION,
    modLanguageAdapter = "net.shadowfacts.forgelin.KotlinAdapter"
)
object NewFrontiers {
    const val MOD_ID = "new_frontiers"
    const val MOD_NAME = "New Frontiers"
    const val VERSION = "1.0-SNAPSHOT"

    val NF_CREATIVE_TAB = NFCreativeTabs()

    /**
     * This is the first initialization event. Register tile entities here.
     * The registry events below will have fired prior to entry to this method.
     */
    @Mod.EventHandler
    fun preinit(event: FMLPreInitializationEvent) {
        val a = DimensionType.register("Space", "_space", 2, Space::class.java, false)
        DimensionManager.registerDimension(2, a)
    }

    /**
     * This is the second initialization event. Register custom recipes
     */
    @Mod.EventHandler
    fun init(event: FMLInitializationEvent) {
    }

    /**
     * This is the final initialization event. Register actions from other mods here
     */
    @Mod.EventHandler
    fun postinit(event: FMLPostInitializationEvent) {

    }

    /**
     * This is a special class that listens to registry events, to allow creation of mod blocks and items at the proper time.
     */
    @Mod.EventBusSubscriber(modid = MOD_ID)
    object ObjectRegistryHandler {
        val blocks: Array<NFBlock> = arrayOf(
            SpaceTeleporter(),
            FTLDrive()
        )

        /**
         * Listen for the register event for creating custom items
         */
        @SubscribeEvent
        @JvmStatic
        fun addItems(event: RegistryEvent.Register<Item>) {
            for (block in blocks) {
                if (block.hasItemBlock) {
                    event.registry.register(ItemBlock(block).setRegistryName(block.registryName))
                }
            }
            // TODO: register items
        }

        /**
         * Listen for the register event for creating custom blocks
         */
        @SubscribeEvent
        @JvmStatic
        fun addBlocks(event: RegistryEvent.Register<Block>) {
            for (block in blocks) {
                event.registry.register(block)
            }
        }
    }
}
