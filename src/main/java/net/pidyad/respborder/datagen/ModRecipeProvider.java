package net.pidyad.respborder.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
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

        stairBuilder(ModBlocks.SRAKER_STAIRS.get(), Ingredient.of(ModItems.SRAKER))
                .unlockedBy("has_sraker", has(ModItems.SRAKER)).save(recipeOutput);

        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SRAKER_SLAB.get(), ModItems.SRAKER.get());

        buttonBuilder(ModBlocks.SRAKER_BUTTON.get(), Ingredient.of(ModItems.SRAKER))
                .unlockedBy("has_sraker", has(ModItems.SRAKER)).save(recipeOutput);

        pressurePlate(recipeOutput, ModBlocks.SRAKER_PRESSURE_PLATE.get(), ModItems.SRAKER.get());

        fenceBuilder(ModBlocks.SRAKER_FENCE.get(), Ingredient.of(ModItems.SRAKER))
                .unlockedBy("has_sraker", has(ModItems.SRAKER)).save(recipeOutput);

        fenceGateBuilder(ModBlocks.SRAKER_FENCE_GATE.get(), Ingredient.of(ModItems.SRAKER))
                .unlockedBy("has_sraker", has(ModItems.SRAKER)).save(recipeOutput);

        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SRAKER_WALL.get(), ModItems.SRAKER.get());

        doorBuilder(ModBlocks.SRAKER_DOOR.get(), Ingredient.of(ModItems.SRAKER))
                .unlockedBy("has_sraker", has(ModItems.SRAKER)).save(recipeOutput);

        trapdoorBuilder(ModBlocks.SRAKER_TRAPDOOR.get(), Ingredient.of(ModItems.SRAKER))
                .unlockedBy("has_sraker", has(ModItems.SRAKER)).save(recipeOutput);

    }
}

