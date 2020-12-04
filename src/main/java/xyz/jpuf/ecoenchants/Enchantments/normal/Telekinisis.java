package xyz.jpuf.ecoenchants.Enchantments.normal;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;


public class Telekinisis extends Enchantment {
    public Telekinisis(Rarity weight, EquipmentSlot... slotTypes){
        super(weight, EnchantmentTarget.BREAKABLE, slotTypes);
    }
}
