package com.thunder.coastalrealms.world.biomes;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.*;

import static com.thunder.coastalrealms.CoastalRealms.MOD_ID;

public class ModBiomes {
    public static final ResourceKey<Biome> FLAT_BEACH = register("flat_beach");
    public static final ResourceKey<Biome> SHALLOW_SHORE = register("shallow_shore");
    public static final ResourceKey<Biome> REEF_OCEAN = register("reef_ocean");
    public static final ResourceKey<Biome> DEEP_OCEAN_SHELF = register("deep_ocean_shelf");

    private static ResourceKey<Biome> register(String name) {
        return ResourceKey.create(Registries.BIOME, ResourceLocation.tryParse(MOD_ID + ":" + name));
    }
}
