package net.pidyad.respborder.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.pidyad.respborder.block.ModBlocks;
import net.pidyad.respborder.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput)
    {
        List<ItemLike> SRAKER_SMELTABLES = List.of(ModBlocks.SRAKER_ORE);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SRAKER_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.SRAKER.get())
                .unlockedBy("has_sraker", has(ModItems.SRAKER)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.KOLBAS.get())
                .pattern("SPS")
                .define('S', Items.STRING)
                .define('P', Items.COOKED_PORKCHOP)
                .unlockedBy("has_string", has(Items.STRING)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SRAKER.get(), 9)
                .requires(ModBlocks.SRAKER_BLOCK)
                .unlockedBy("has_sraker_block", has(ModBlocks.SRAKER_BLOCK)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SRAKER.get(), 18)
                .requires(ModBlocks.MAGIC_BLOCK)
                .unlockedBy("has_magic_block", has(ModBlocks.MAGIC_BLOCK)).save(recipeOutput, "pidrespborder:srakers_from_magic_block");

        oreSmelting(recipeOutput, SRAKER_SMELTABLES, RecipeCategory.MISC, ModItems.SRAKER.get(), 0.25f, 200, "sraker");
        oreBlasting(recipeOutput, SRAKER_SMELTABLES, RecipeCategory.MISC, ModItems.SRAKER.get(), 0.25f, 100, "sraker");
    }
}

