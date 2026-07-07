package net.pidyad.respborder.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.pidyad.respborder.RespBorder;
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
    }
}
