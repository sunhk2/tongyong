package com.example.enchantmentmod.enchantments;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;

import java.util.Random;

public class LightningStrikeEnchantment extends Enchantment {
    private static final Random RANDOM = new Random();

    public LightningStrikeEnchantment() {
        super(Rarity.VERY_RARE, EnchantmentCategory.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinCost(int level) {
        return 30 + (level - 1) * 20;
    }

    @Override
    public int getMaxCost(int level) {
        return 60 + (level - 1) * 25;
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }

    @Override
    public void doPostAttack(LivingEntity attacker, LivingEntity target, int level) {
        Level levelWorld = attacker.level();
        if (!levelWorld.isClientSide && RANDOM.nextFloat() < 0.1f * level) {
            Vec3 targetPos = target.position();
            levelWorld.strikeLightning(targetPos);
            levelWorld.gameEvent(attacker, GameEvent.LIGHTNING_STRIKE, targetPos);
        }
        super.doPostAttack(attacker, target, level);
    }
}
