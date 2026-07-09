package net.pidyad.respborder.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.pidyad.respborder.RespBorder;
import net.pidyad.respborder.block.ModBlocks;
import net.pidyad.respborder.block.custom.SrakerLampBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, RespBorder.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.MAGIC_BLOCK);
        blockWithItem(ModBlocks.SRAKER_ORE);
        blockWithItem(ModBlocks.SRAKER_BLOCK);
        stairsBlock(ModBlocks.SRAKER_STAIRS.get(), blockTexture(ModBlocks.SRAKER_BLOCK.get()));
        slabBlock(ModBlocks.SRAKER_SLAB.get(), blockTexture(ModBlocks.SRAKER_BLOCK.get()), blockTexture(ModBlocks.SRAKER_BLOCK.get()));

        buttonBlock(ModBlocks.SRAKER_BUTTON.get(), blockTexture(ModBlocks.SRAKER_BLOCK.get()));
        pressurePlateBlock(ModBlocks.SRAKER_PRESSURE_PLATE.get(), blockTexture(ModBlocks.SRAKER_BLOCK.get()));
        fenceBlock(ModBlocks.SRAKER_FENCE.get(), blockTexture(ModBlocks.SRAKER_BLOCK.get()));
        fenceGateBlock(ModBlocks.SRAKER_FENCE_GATE.get(), blockTexture(ModBlocks.SRAKER_BLOCK.get()));
        wallBlock(ModBlocks.SRAKER_WALL.get(), blockTexture(ModBlocks.SRAKER_BLOCK.get()));

        doorBlockWithRenderType(ModBlocks.SRAKER_DOOR.get(), modLoc("block/sraker_door_bottom"), modLoc("block/sraker_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.SRAKER_TRAPDOOR.get(), modLoc("block/sraker_trapdoor"),true, "cutout");

        blockItem(ModBlocks.SRAKER_STAIRS);
        blockItem(ModBlocks.SRAKER_SLAB);
        blockItem(ModBlocks.SRAKER_PRESSURE_PLATE);
        blockItem(ModBlocks.SRAKER_FENCE_GATE);
        blockItem(ModBlocks.SRAKER_TRAPDOOR, "_bottom");
        customLamp();

    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock)
    {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("pidrespborder:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix)
    {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("pidrespborder:block/" + deferredBlock.getId().getPath() + appendix));
    }

    private void customLamp() {
        getVariantBuilder(ModBlocks.SRAKER_LAMP.get()).forAllStates(state -> {
            if(state.getValue(SrakerLampBlock.CLICKED)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("sraker_lamp_on",
                        ResourceLocation.fromNamespaceAndPath(RespBorder.MOD_ID, "block/" + "sraker_lamp_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("sraker_lamp_off",
                        ResourceLocation.fromNamespaceAndPath(RespBorder.MOD_ID, "block/" + "sraker_lamp_off")))};
            }

        });
        simpleBlockItem(ModBlocks.SRAKER_LAMP.get(), models().cubeAll("sraker_lamp_on",
                ResourceLocation.fromNamespaceAndPath(RespBorder.MOD_ID, "block/" + "sraker_lamp_on")));
    }
}
