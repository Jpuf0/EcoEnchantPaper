package xyz.jpuf.ecoenchants;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;

import xyz.jpuf.ecoenchants.Enchantments.EcoEnchantments;
import xyz.jpuf.ecoenchants.Events.EventHandlers;

public class EcoEnchants implements ModInitializer {
    public static String MODID = "ecoenchants";

//    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(new Identifier(MODID, "enchantments")).icon(() -> new ItemStack(Items.ENCHANTED_BOOK)).appendItems(itemStacks -> {})            .build();

    @Override
    public void onInitialize() {
        EcoEnchantments.register();
        EventHandlers.init();
        System.out.println("All Enchants: " + String.valueOf(EcoEnchantments.all()));
    }
}
