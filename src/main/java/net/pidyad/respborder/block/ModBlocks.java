package net.pidyad.respborder.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.pidyad.respborder.RespBorder;
import net.pidyad.respborder.block.custom.MagicBlock;
import net.pidyad.respborder.block.custom.SrakerLampBlock;
import net.pidyad.respborder.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(RespBorder.MOD_ID);

    public static final DeferredBlock<Block> SRAKER_BLOCK = registerBlock("sraker_block", () -> new Block(BlockBehaviour.Properties.of()
            .strength(0.1f)
            .sound(SoundType.ANVIL)) );

    public static final DeferredBlock<Block> SRAKER_ORE = registerBlock("sraker_ore", () -> new Block(BlockBehaviour.Properties.of()
            .strength(0.1f)
            .sound(SoundType.ANVIL)) );

    public static final DeferredBlock<Block> MAGIC_BLOCK = registerBlock("magic_block", () -> new MagicBlock(BlockBehaviour.Properties.of()
            .strength(1f)
            .sound(SoundType.BASALT)
            .requiresCorrectToolForDrops()));

    public static DeferredBlock<StairBlock> SRAKER_STAIRS = registerBlock("sraker_stairs",
            () -> new StairBlock(ModBlocks.SRAKER_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));

    public static DeferredBlock<Block> SRAKER_LAMP = registerBlock("sraker_lamp",
            () -> new SrakerLampBlock(BlockBehaviour.Properties.of().strength(2f).lightLevel(state -> state.getValue(SrakerLampBlock.CLICKED) ? 15 : 0)));

    public static DeferredBlock<SlabBlock> SRAKER_SLAB = registerBlock("sraker_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));

    public static DeferredBlock<PressurePlateBlock> SRAKER_PRESSURE_PLATE = registerBlock("sraker_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));

    public static DeferredBlock<FenceBlock> SRAKER_FENCE = registerBlock("sraker_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));

    public static DeferredBlock<FenceGateBlock> SRAKER_FENCE_GATE = registerBlock("sraker_fence_gate",
            () -> new FenceGateBlock(WoodType.WARPED, BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));

    public static DeferredBlock<WallBlock> SRAKER_WALL = registerBlock("sraker_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));

    public static DeferredBlock<ButtonBlock> SRAKER_BUTTON = registerBlock("sraker_button",
            () -> new ButtonBlock(BlockSetType.OAK, 20, BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().noCollission()));

    public static DeferredBlock<DoorBlock> SRAKER_DOOR = registerBlock("sraker_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().noOcclusion()));

    public static DeferredBlock<TrapDoorBlock> SRAKER_TRAPDOOR = registerBlock("sraker_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().noOcclusion()));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}
