package xyz.jpuf.ecoenchants.Enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class Launch extends Enchantment {
    protected Launch(Rarity weight, EquipmentSlot... slotTypes) {
        super(weight, EnchantmentTarget.WEARABLE, slotTypes);
    }

    @Override
    public int getMinPower(int level) {
        return 1;
    }

    @Override
    public int getMaxLevel() {
        return 8;
    }

}
