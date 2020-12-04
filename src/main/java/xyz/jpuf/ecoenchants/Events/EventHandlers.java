package xyz.jpuf.ecoenchants.Events;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;
import xyz.jpuf.ecoenchants.Enchantments.normal.Telekinisis;
import xyz.jpuf.ecoenchants.Enchantments.normal.TelekinisisLogic;
import xyz.jpuf.ecoenchants.Events.Events.OnBlockBreakAttemptEvent;

public final class EventHandlers {
    private EventHandlers(){

    }

    public static void init(){
        OnBlockBreakAttemptEvent.EVENT.register(((manager, pos, reason) -> {
            if(reason.isSuccessfulAndEffective() && !manager.player.isCreative()){
                PlayerEntity playerEntity = manager.player;
                World world = playerEntity.getEntityWorld();
                TelekinisisLogic.tryTelekinis(world, pos, world.getBlockState(pos), playerEntity);
            }
            return ActionResult.PASS;
        }));
    }
}
