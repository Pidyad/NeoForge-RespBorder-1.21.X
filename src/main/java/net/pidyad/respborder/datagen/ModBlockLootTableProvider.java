package net.pidyad.respborder.datagen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.pidyad.respborder.block.ModBlocks;
import net.pidyad.respborder.item.ModItems;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.SRAKER_BLOCK.get());
        dropSelf(ModBlocks.MAGIC_BLOCK.get());
        dropSelf(ModBlocks.SRAKER_STAIRS.get());
        dropSelf(ModBlocks.SRAKER_FENCE.get());
        dropSelf(ModBlocks.SRAKER_WALL.get());
        dropSelf(ModBlocks.SRAKER_FENCE.get());
        dropSelf(ModBlocks.SRAKER_BUTTON.get());
        dropSelf(ModBlocks.SRAKER_FENCE_GATE.get());
        dropSelf(ModBlocks.SRAKER_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.SRAKER_TRAPDOOR.get());
        dropSelf(ModBlocks.SRAKER_LAMP.get());
        add(ModBlocks.SRAKER_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.SRAKER_SLAB.get()));
        add(ModBlocks.SRAKER_DOOR.get(),
                block -> createDoorTable(ModBlocks.SRAKER_DOOR.get()));

        add(ModBlocks.SRAKER_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.SRAKER_ORE.get(), ModItems.SRAKER.get(), 3, 9));
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrop, float maxDrop)
    {
        HolderLookup.RegistryLookup<Enchantment> registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrop, maxDrop)))
                        .apply(ApplyBonusCount.addOreBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks()
    {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
