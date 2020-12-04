package xyz.jpuf.ecoenchants.Enchantments.normal;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.Monster;
import net.minecraft.text.Text;

import java.util.UUID;

public class Abattoir extends Enchantment {
    public Abattoir() {
        super(Rarity.UNCOMMON, EnchantmentTarget.TRIDENT, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinPower(int level) {
        return 1;
    }

    @Override
    public int getMaxLevel() {
        return 10;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(target instanceof Monster) return;
        target.damage(DamageSource.GENERIC, (2.5F * (level + 1) + 1));
        super.onTargetDamaged(user, target, level);
    }
}
