package com.example.enchantmentmod;

import com.example.enchantmentmod.enchantments.ModEnchantments;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(EnchantmentMod.MOD_ID)
public class EnchantmentMod {
    public static final String MOD_ID = "enchantmentmod";

    public EnchantmentMod(IEventBus eventBus) {
        eventBus.addListener(this::commonSetup);
        eventBus.addListener(this::clientSetup);
        ModEnchantments.register(eventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    private void clientSetup(final FMLClientSetupEvent event) {
    }
}
