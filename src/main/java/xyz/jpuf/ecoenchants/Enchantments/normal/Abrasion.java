package xyz.jpuf.ecoenchants.Enchantments.normal;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;

public class Abrasion extends Enchantment {
    public Abrasion(){
        super(Rarity.UNCOMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinPower(int level) {
        return 1;
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
//        if(!(target instanceof PlayerEntity)) return;
//        PlayerEntity player = (PlayerEntity) target;
//
//        DefaultedList<ItemStack> armor = ((PlayerEntity) target).inventory.armor;
//        if(armor.isEmpty()) return;
//
//        for(ItemStack armorPiece : armor) {
//            if(armorPiece == null) continue;
//
//            if(armorPiece.equals(player.inventory.armor.get(1))) {
//            }
//        }

        super.onTargetDamaged(user, target, level);
    }
}
