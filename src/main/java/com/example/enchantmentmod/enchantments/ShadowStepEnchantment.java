package com.example.enchantmentmod.enchantments;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.level.Level;

public class ShadowStepEnchantment extends Enchantment {
    public ShadowStepEnchantment() {
        super(Rarity.RARE, EnchantmentCategory.ARMOR_FEET, new EquipmentSlot[]{EquipmentSlot.FEET});
    }

    @Override
    public int getMinCost(int level) {
        return 25 + (level - 1) * 15;
    }

    @Override
    public int getMaxCost(int level) {
        return 55 + (level - 1) * 20;
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }

    @Override
    public void doTick(LivingEntity entity, int level) {
        Level levelWorld = entity.level();
        if (!levelWorld.isClientSide) {
            boolean isInDarkness = levelWorld.getMaxLocalRawBrightness(entity.blockPosition()) < 7;
            if (isInDarkness) {
                entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 20, 0, false, false));
                entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20, level - 1, false, false));
            }
        }
        super.doTick(entity, level);
    }
}
