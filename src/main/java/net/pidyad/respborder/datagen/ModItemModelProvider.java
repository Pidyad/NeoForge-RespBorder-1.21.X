package net.pidyad.respborder.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.pidyad.respborder.RespBorder;
import net.pidyad.respborder.block.ModBlocks;
import net.pidyad.respborder.item.ModItems;
import net.pidyad.respborder.item.custom.ChiselItem;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, RespBorder.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.SRAKER.get());
        basicItem(ModItems.SHIT.get());
        basicItem(ModItems.SWING.get());
        basicItem(ModItems.CHISEL.get());
        basicItem(ModItems.KOLBAS.get());

        buttonItem(ModBlocks.SRAKER_BUTTON, ModBlocks.SRAKER_BLOCK);
        fenceItem(ModBlocks.SRAKER_FENCE, ModBlocks.SRAKER_BLOCK);
        wallItem(ModBlocks.SRAKER_WALL, ModBlocks.SRAKER_BLOCK);

        basicItem(ModBlocks.SRAKER_DOOR.asItem());
    }

    public void buttonItem(DeferredBlock<?> block, DeferredBlock<?> baseBlock)
    {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(RespBorder.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<?> block, DeferredBlock<?> baseBlock)
    {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(RespBorder.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void wallItem(DeferredBlock<?> block, DeferredBlock<?> baseBlock)
    {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(RespBorder.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }
}
