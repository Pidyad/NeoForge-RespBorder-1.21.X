package net.pidyad.respborder.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties KOBLBAS = new FoodProperties.Builder().nutrition(3).saturationModifier(0.25f)
            .usingConvertsTo(ModItems.SRAKER.get()).effect(() -> new MobEffectInstance(MobEffects.JUMP, 400), 0.35f).build();

}
