package de.wulkanat.www.new_frontiers.init

import de.wulkanat.www.new_frontiers.dimensions.DimensionSpace
import de.wulkanat.www.new_frontiers.abstract_helpers.NFDimension
import net.minecraftforge.common.DimensionManager

enum class DimensionTypes(val value: NFDimension) {
    SPACE(DimensionSpace());
}

fun registerDimensions() {
    for (dimensionType in DimensionTypes.values()) {
        DimensionManager.registerDimension(dimensionType.value.id, dimensionType.value.dimensionType)
    }
}
