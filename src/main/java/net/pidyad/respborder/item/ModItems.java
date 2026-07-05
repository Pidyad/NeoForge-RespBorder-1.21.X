package net.pidyad.respborder.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.pidyad.respborder.RespBorder;
import net.pidyad.respborder.block.custom.FuelItem;
import net.pidyad.respborder.item.custom.ChiselItem;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(RespBorder.MOD_ID);

    public static final DeferredItem<Item> SRAKER = ITEMS.register("sraker",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SWING = ITEMS.register("swing",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SHIT = ITEMS.register("shit",
            () -> new FuelItem(new Item.Properties(), 100));

    public static final DeferredItem<Item> KOLBAS = ITEMS.register("kolbas",
            () -> new Item(new Item.Properties().food(ModFoodProperties.KOBLBAS)));
;
    public static final DeferredItem<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties().durability(32)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
