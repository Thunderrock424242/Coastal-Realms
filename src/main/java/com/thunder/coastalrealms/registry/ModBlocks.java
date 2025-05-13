package com.thunder.coastalrealms.registry;

import com.thunder.coastalrealms.CoastalRealms;
import com.thunder.coastalrealms.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(CoastalRealms.MOD_ID);

    public static final DeferredBlock<Block> SMALL_ROCK = registerBlock("small rock",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2.0F, 4.0F)
                    .mapColor(MapColor.STONE)
                    .sound(SoundType.STONE)));

    public static final DeferredBlock<Block> ROCK = registerBlock("rock",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4.0F, 8.0F)
                    .mapColor(MapColor.STONE)
                    .sound(SoundType.STONE)));

    public static final DeferredBlock<Block> BIG_ROCK = registerBlock("big rock",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5.0F, 10.0F)
                    .mapColor(MapColor.STONE)
                    .sound(SoundType.STONE)));

    public static final DeferredBlock<Block> BIG_BIG_ROCK = registerBlock("big big rock",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(15.0F, 20.0F)
                    .mapColor(MapColor.STONE)
                    .sound(SoundType.STONE)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> blockSupplier) {
        DeferredBlock<T> block = BLOCKS.register(name, blockSupplier);
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}