package com.thunder.coastalrealms.world.biomes;

import com.thunder.coastalrealms.CoastalRealms;
import net.minecraft.resources.ResourceLocation;
import terrablender.api.RegionType;
import terrablender.core.TerraBlender;

import javax.naming.Context;
import javax.swing.plaf.synth.Region;

public class TerraBlenderBiomeProvider extends TerraBlender {
    public static final ResourceLocation COASTAL_REGION = new ResourceLocation(CoastalRealms.MOD_ID, "coastal_region");

    @Override
    public void onTerraBlenderInitialized(Context context) {
        context.registerRegion(new Region(COASTAL_REGION, RegionType.OVERWORLD, 3));
    }
}
