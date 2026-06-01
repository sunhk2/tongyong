package com.example.enchantmentmod.enchantments;

import com.example.enchantmentmod.EnchantmentMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.Enchantment;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS =
            DeferredRegister.create(Registries.ENCHANTMENT, EnchantmentMod.MOD_ID);

    public static final Supplier<Enchantment> INFERNO = ENCHANTMENTS.register("inferno", InfernoEnchantment::new);
    public static final Supplier<Enchantment> FROST_ASPECT = ENCHANTMENTS.register("frost_aspect", FrostAspectEnchantment::new);
    public static final Supplier<Enchantment> LIGHTNING_STRIKE = ENCHANTMENTS.register("lightning_strike", LightningStrikeEnchantment::new);
    public static final Supplier<Enchantment> VAMPIRIC = ENCHANTMENTS.register("vampiric", VampiricEnchantment::new);
    public static final Supplier<Enchantment> SHADOW_STEP = ENCHANTMENTS.register("shadow_step", ShadowStepEnchantment::new);

    public static void register(IEventBus eventBus) {
        ENCHANTMENTS.register(eventBus);
    }
}
