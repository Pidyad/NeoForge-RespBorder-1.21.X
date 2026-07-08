package net.pidyad.respborder.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.pidyad.respborder.RespBorder;
import net.pidyad.respborder.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, RespBorder.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.SRAKER_ORE.get())
                .add(ModBlocks.SRAKER_BLOCK.get())
                .add(ModBlocks.MAGIC_BLOCK.get())
                .add(ModBlocks.SRAKER_DOOR.get())
                .add(ModBlocks.SRAKER_TRAPDOOR.get())
                .add(ModBlocks.SRAKER_BUTTON.get())
                .add(ModBlocks.SRAKER_FENCE.get())
                .add(ModBlocks.SRAKER_FENCE_GATE.get())
                .add(ModBlocks.SRAKER_PRESSURE_PLATE.get())
                .add(ModBlocks.SRAKER_STAIRS.get())
                .add(ModBlocks.SRAKER_WALL.get())
                .add(ModBlocks.SRAKER_SLAB.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.SRAKER_ORE.get());

        tag(BlockTags.FENCES).add(ModBlocks.SRAKER_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.SRAKER_FENCE_GATE.get());
        tag(BlockTags.WALLS).add(ModBlocks.SRAKER_WALL.get());
    }


}
