package net.noamr.rotandburn.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent BLUEBERRY = new FoodComponent.Builder().nutrition(1).saturationModifier(0.1f).snack()
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,50 , 1), 0.20f).build();
    public static final FoodComponent BLUEBERRY_PIE = new FoodComponent.Builder().nutrition(4).saturationModifier(0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,80 , 2), 0.25f).build();
}
