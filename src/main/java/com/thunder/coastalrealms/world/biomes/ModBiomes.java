package com.thunder.coastalrealms.world.biomes;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

import static com.thunder.coastalrealms.CoastalRealms.MOD_ID;

public class ModBiomes {
    public static ResourceKey<Biome> FLAT_BEACH = register("flat_beach");
    public static ResourceKey<Biome> SHALLOW_SHORE = register("shallow_shore");
    public static ResourceKey<Biome> REEF_OCEAN = register("reef_ocean");
    public static ResourceKey<Biome> DEEP_OCEAN_SHELF = register("deep_ocean_shelf");

    private static ResourceKey<Biome> register(String name) {
        return ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(MOD_ID, name));
    }

    public static void bootstrap() {
        // Called during mod loading, actual biome registration done via JSON or Datagen
    }
}