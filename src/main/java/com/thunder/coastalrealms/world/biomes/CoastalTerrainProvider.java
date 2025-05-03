package com.thunder.coastalrealms.world.biomes;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.Region;
import terrablender.api.RegionType;

import static com.thunder.coastalrealms.CoastalRealms.MOD_ID;

public class CoastalTerrainProvider extends Region {
    public CoastalTerrainProvider() {
        super(ResourceLocation.tryParse(MOD_ID + ":coastal_region"), RegionType.OVERWORLD, 3);
    }

    public ResourceKey<Biome> getBiome(BiomeManager.NoiseBiomeSource noiseSource, int x, int y, int z,
                                       Climate.Parameter temperature, Climate.Parameter humidity, Climate.Parameter continentalness,
                                       Climate.Parameter erosion, Climate.Parameter depth, Climate.Parameter weirdness, float offset) {

        float depthVal = depth.max();
        float erosionVal = erosion.max();

        if (depthVal < -0.2f && erosionVal > 0.0f) {
            return ModBiomes.DEEP_OCEAN_SHELF;
        } else if (depthVal < -0.1f && erosionVal > -0.3f) {
            return ModBiomes.REEF_OCEAN;
        } else if (depthVal < 0.05f && erosionVal > 0.1f) {
            return ModBiomes.SHALLOW_SHORE;
        } else {
            return ModBiomes.FLAT_BEACH;
        }
    }
}
