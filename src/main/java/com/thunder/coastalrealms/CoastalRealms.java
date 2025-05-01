package com.thunder.coastalrealms;

import com.thunder.coastalrealms.world.biomes.ModBiomes;
import com.thunder.coastalrealms.world.biomes.TerraBlenderBiomeProvider;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.level.LevelEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.event.server.ServerStoppingEvent;
import net.neoforged.neoforge.network.handling.IPayloadHandler;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

import java.util.HashMap;
import java.util.Map;

import static com.thunder.coastalrealms.Core.ModConstants.LOGGER;

/**
 * The type Wilderness odyssey api main mod class.
 */
@Mod(CoastalRealms.MOD_ID)
public class CoastalRealms {

    /**
     * The constant MOD_ID.
     */
    public static final String MOD_ID = "coastalrealms";


    private static final Map<CustomPacketPayload.Type<?>, NetworkMessage<?>> MESSAGES = new HashMap<>();

    private record NetworkMessage<T extends CustomPacketPayload>(StreamCodec<? extends FriendlyByteBuf, T> reader,
                                                                 IPayloadHandler<T> handler) {
    }

    /**
     * Instantiates a new Wilderness odyssey api main mod class.
     *
     * @param modEventBus the mod event bus
     * @param container   the container
     */
    public CoastalRealms(IEventBus modEventBus, ModContainer container) {
        LOGGER.info("WildernessOdysseyAPI initialized. I will also start to track mod conflicts");
        // Register mod setup and creative tabs
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);
        modEventBus.addListener(this::onServerStopping);

        // Register global events
        TerraBlenderBiomeProvider.init();

    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }


    /**
     * On server starting.
     *
     * @param event the event
     */
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    /**
     * On register commands.
     *
     * @param event the event
     */
    @SubscribeEvent
    public void onRegisterCommands(RegisterCommandsEvent event) {
    }

    /**
     * On world load.
     *
     * @param event the event
     */
    @SubscribeEvent
    public void onWorldLoad(LevelEvent.Load event) {

    }

    /**
     * On mob spawn.
     *
     * @param event the event
     */
    @SubscribeEvent
    public void onMobSpawn(EntityJoinLevelEvent event) {

    }

    /**
     * On server stopping.
     *
     * @param event the event
     */
    @SubscribeEvent
    public void onServerStopping(ServerStoppingEvent event) {

    }
}

