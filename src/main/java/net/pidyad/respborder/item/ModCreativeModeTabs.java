package net.pidyad.respborder.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.pidyad.respborder.RespBorder;
import net.pidyad.respborder.block.ModBlocks;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RespBorder.MOD_ID);

    public static final Supplier<CreativeModeTab> RESPBORDER_ITEMS_TAB = CREATIVE_MODE_TAB.register("respborder_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SRAKER.get()))
                    .title(Component.translatable("creativetab.pidrespborder.respborder_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.SRAKER);
                        output.accept(ModBlocks.SRAKER_BLOCK);
                    })

                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
