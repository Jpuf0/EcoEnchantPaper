package xyz.jpuf.ecoenchants;

import net.fabricmc.api.ModInitializer;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EcoEnchants implements ModInitializer {

    public static String MODID = "EcoEnchants";

    private static Enchantment STRAY_ASPECT = Registry.register(
            Registry.ENCHANTMENT,
            new Identifier(MODID, "stray_aspect"),
            new StrayAspect()
    );

    @Override
    public void onInitialize() {

    }
}
