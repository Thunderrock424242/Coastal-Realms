package com.thunder.coastalrealms.world.biomes;

import com.thunder.coastalrealms.CoastalRealms;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class ModBiomes {
    public static ResourceKey<Biome> FLAT_BEACH = register("flat_beach");
    public static ResourceKey<Biome> SHALLOW_SHORE = register("shallow_shore");
    public static ResourceKey<Biome> REEF_OCEAN = register("reef_ocean");
    public static ResourceKey<Biome> DEEP_OCEAN_SHELF = register("deep_ocean_shelf");

    private static ResourceKey<Biome> register(String name) {
        return ResourceKey.create(Registries.BIOME, new ResourceLocation(CoastalRealms.MOD_ID, name));
    }

    public static void bootstrap() {
        register(registry, FLAT_BEACH, makeFlatBeach());
        register(registry, SHALLOW_SHORE, makeShallowShore());
        register(registry, REEF_OCEAN, makeReefOcean());
        register(registry, DEEP_OCEAN_SHELF, makeDeepOceanShelf());
    }

    private static void register(Registry<Biome> registry, ResourceKey<Biome> key, Biome biome) {
        Registry.register(registry, key.location(), biome);
    }
}
