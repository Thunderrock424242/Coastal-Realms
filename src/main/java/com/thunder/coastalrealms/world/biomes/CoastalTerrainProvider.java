package com.thunder.coastalrealms.world.biomes;

import com.thunder.coastalrealms.CoastalRealms;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.Region;
import terrablender.api.RegionType;

public class CoastalTerrainProvider extends Region {
    public CoastalTerrainProvider() {
        super(new ResourceLocation(CoastalRealms.MOD_ID, "coastal_region"), RegionType.OVERWORLD, 3);
    }

    @Override
    public void addBiomes(BiomeSelectionContext selectionContext, BiomeRegistry biomeRegistry) {
        selectionContext.addBiome(ModBiomes.FLAT_BEACH, getWeightForCoastBand(0));
        selectionContext.addBiome(ModBiomes.SHALLOW_SHORE, getWeightForCoastBand(1));
        selectionContext.addBiome(ModBiomes.REEF_OCEAN, getWeightForCoastBand(2));
        selectionContext.addBiome(ModBiomes.DEEP_OCEAN_SHELF, getWeightForCoastBand(3));
    }

    @Override
    public ResourceKey<Biome> getBiome(BiomeManager.NoiseBiomeSource noiseSource, int x, int y, int z, Climate.Parameter temperature, Climate.Parameter humidity, Climate.Parameter continentalness, Climate.Parameter erosion, Climate.Parameter depth, Climate.Parameter weirdness, float offset) {
        float depthVal = depth.max(); // range: -1 (ocean) to +1 (mountain)
        float erosionVal = erosion.max(); // higher = flatter
        float continentalVal = continentalness.max(); // lower = ocean

        if (depthVal < -0.2f && erosionVal > 0.0f) {
            // Deep drop-off
            return ModBiomes.DEEP_OCEAN_SHELF;
        } else if (depthVal < -0.1f && erosionVal > -0.3f) {
            // Coral reef
            return ModBiomes.REEF_OCEAN;
        } else if (depthVal < 0.05f && erosionVal > 0.1f) {
            // Shoreline
            return ModBiomes.SHALLOW_SHORE;
        } else {
            // Default: flat beach
            return ModBiomes.FLAT_BEACH;
        }
    }

    private int getWeightForCoastBand(int band) {
        // You can make these values dynamic based on player config later
        return switch (band) {
            case 0 -> 8;  // Flat beach
            case 1 -> 6;  // Shoreline
            case 2 -> 5;  // Reef
            case 3 -> 2;  // Drop-off
            default -> 1;
        };
    }
}
