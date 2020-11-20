package xyz.jpuf.ecoenchants.Enchantments;

import net.minecraft.enchantment.Enchantment.Rarity;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class EcoEnchantments {
    public static String MODID = "ecoenchants";

    private static final EquipmentSlot[] ALL_ARMOR;
    public static final Enchantment STRAY_ASPECT;
    public static final Enchantment LAUNCH;

    private static Enchantment register(String name, Enchantment enchantment) {
        return (Enchantment)Registry.register(Registry.ENCHANTMENT, new Identifier(MODID, name), enchantment);
    }

    static {
        ALL_ARMOR = new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET};
        STRAY_ASPECT = register("stray_aspect", new Stray_Aspect(Rarity.UNCOMMON, EquipmentSlot.MAINHAND));
        LAUNCH = register("launch", new Launch(Rarity.RARE, EquipmentSlot.CHEST));
    }
}
