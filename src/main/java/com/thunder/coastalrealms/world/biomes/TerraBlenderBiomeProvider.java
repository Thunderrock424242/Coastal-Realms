package com.thunder.coastalrealms.world.biomes;

import net.minecraft.resources.ResourceLocation;
import terrablender.api.RegionType;

import javax.naming.Context;
import javax.swing.plaf.synth.Region;

import static com.thunder.coastalrealms.CoastalRealms.MOD_ID;

public class TerraBlenderBiomeProvider implements TerraBlenderApi {
    public static final ResourceLocation COASTAL_REGION = new ResourceLocation(MOD_ID, "coastal_region");

    public static void init() {
        TerraBlenderApi.register(new CoastalTerrainProvider());
    }

    @Override
    public void onTerraBlenderInitialized(Context context) {
        context.registerRegion(new Region(COASTAL_REGION, RegionType.OVERWORLD, 3));
    }
}
