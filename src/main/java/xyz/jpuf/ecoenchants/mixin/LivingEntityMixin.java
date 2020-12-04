package xyz.jpuf.ecoenchants.mixin;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
    private int elytraboost$timer = 0;
    private boolean doneOnce = false;
    private double boost = 0D;

    @Redirect(method = "travel(Lnet/minecraft/util/math/Vec3d;)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;setFlag(IZ)V"))
    public void travel(LivingEntity entity, int idx, boolean val) { }

    @Redirect(method = "initAi()V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;setFlag(IZ)V"))
    public void initAi(LivingEntity entity, int idx, boolean val) {
        if(entity.isFallFlying()){
            if(elytraboost$timer > 1){
                ((EntityAccessor) entity).callSetFlag(7, val);
                if(!doneOnce){
                    ItemStack itemStack = entity.getEquippedStack(EquipmentSlot.CHEST);
                    if(itemStack.getEnchantments().stream().anyMatch(name -> name.asString().contains("ecoenchants:launch"))){
                        if(itemStack.getItem() == Items.ELYTRA && ElytraItem.isUsable(itemStack)) {
                            Vec3d vec3d = entity.getRotationVector();
                            Vec3d vec3d2 = entity.getVelocity();
                            entity.addVelocity(vec3d.x * 0.1D + (vec3d.x * 2.5D - vec3d2.x) * 0.5D, vec3d.y * 0.1D + (vec3d.y * 2.5D - vec3d2.y) * 0.5D, vec3d.z * 0.1D + (vec3d.z * 2.5D - vec3d2.z) * 0.5D);
                            ((ScheduleAccessor) entity).callScheduleVelocityUpdate();
                            System.out.println("Boost");
                            doneOnce = true;
                        }
                    }
                }
            }
            elytraboost$timer += 1;
        } else {
            elytraboost$timer = 0;
            doneOnce = false;
        }
    }
}
