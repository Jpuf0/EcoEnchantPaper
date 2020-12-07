package xyz.jpuf.ecoenchants.Enchantments;

import net.minecraft.enchantment.Enchantment.Rarity;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import xyz.jpuf.ecoenchants.EcoEnchants;
import xyz.jpuf.ecoenchants.Enchantments.normal.*;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


public class EcoEnchantments {
    private static final Set<ItemStack> ecoEnchants = new HashSet<>();

    private static final EquipmentSlot[] ALL_ARMOR;
    public static final Enchantment STRAY_ASPECT;
    public static final Enchantment LAUNCH;
    public static final Enchantment ABATTOIR;
    public static final Enchantment ABRASION;
    public static final Enchantment TELEKINESIS;

    private static Enchantment register(String name, Enchantment enchantment) {
        return (Enchantment)Registry.register(Registry.ENCHANTMENT, new Identifier(EcoEnchants.MODID, name), enchantment);
    }

    static {
        ALL_ARMOR = new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET};
        ABATTOIR = register("abattoir", new Abattoir());
        ABRASION = register("abrasion", new Abrasion());
        LAUNCH = register("launch", new Launch(Rarity.RARE, EquipmentSlot.CHEST));
        STRAY_ASPECT = register("stray_aspect", new StrayAspect());
        TELEKINESIS = register("telekinesis", new Telekinesis(Rarity.VERY_RARE, EquipmentSlot.MAINHAND));
    }

    public static void register() {
    }

    public static Set<Identifier> all() {
        return Registry.ENCHANTMENT.getIds().stream().filter(entry -> entry.toString().contains("ecoenchants")).collect(Collectors.toSet());
//        return Registry.ENCHANTMENT.getEntries().stream().filter(entry -> entry.getKey().toString().contains("ecoenchants"));
    }

    public static Enchantment getByName(String name) {
        return Registry.ENCHANTMENT.get(Registry.ENCHANTMENT.getIds().stream().filter(entry -> entry.getPath().equalsIgnoreCase(name)).findFirst().get());
    }

    public static Set<ItemStack> getBooks() {
        ecoEnchants.clear();
        for(Identifier enchantment : new HashSet<>(all())){
//            System.out.println("Path: " + enchantment.getPath());
            System.out.println(getByName(enchantment.getPath()));
            ItemStack ebook = new ItemStack(Items.ENCHANTED_BOOK);
            ebook.addEnchantment(getByName(enchantment.getPath()), getByName(enchantment.getPath()).getMaxLevel());
            System.out.println(ebook);
            ecoEnchants.add(ebook);
        }
        return ecoEnchants;
        //        new ItemStack(Items.ENCHANTED_BOOK).addEnchantment();
//        return Registry.ENCHANTMENT.getIds().stream().filter()
    }
}
