package xyz.jpuf.ecoenchants.mixin.Events;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.network.ServerPlayerInteractionManager;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.layer.ScaleLayer;
import org.apache.logging.log4j.core.jmx.Server;
import org.lwjgl.system.CallbackI;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import xyz.jpuf.ecoenchants.Events.Events.OnBlockBreakAttemptEvent;
import xyz.jpuf.ecoenchants.Events.Events.OnBlockBreakAttemptEvent.Reason;

@Mixin(ServerPlayerInteractionManager.class)
public abstract class OnBlockBreakAttemptMixin {
    @Shadow public abstract boolean isCreative();

    @Shadow public ServerPlayerEntity player;

    @Inject(at = @At(value = "RETURN", ordinal = 0), method = "tryBreakBlock", cancellable = true)
    public void tryBreakBlockEvent_ItemCantMine(BlockPos pos, CallbackInfoReturnable<Boolean> callbackInfo){
        if(OnBlockBreakAttemptEvent.EVENT.invoker().onBreak((ServerPlayerInteractionManager)(Object)this, pos, Reason.ITEM_CANNOT_MINE) == ActionResult.SUCCESS){
            callbackInfo.setReturnValue(true);
        }
    }
    @Inject(at = @At(value = "RETURN", ordinal = 0), method = "tryBreakBlock", cancellable = true)
    public void tryBreakBlockEvent_CreativeBlock(BlockPos pos, CallbackInfoReturnable<Boolean> callbackInfo){
        if(OnBlockBreakAttemptEvent.EVENT.invoker().onBreak((ServerPlayerInteractionManager)(Object)this, pos, Reason.CREATIVE_BLOCK) == ActionResult.SUCCESS){
            callbackInfo.setReturnValue(true);
        }
    }
    @Inject(at = @At(value = "RETURN", ordinal = 0), method = "tryBreakBlock", cancellable = true)
    public void tryBreakBlockEvent_PlayerCantMine(BlockPos pos, CallbackInfoReturnable<Boolean> callbackInfo){
        if(OnBlockBreakAttemptEvent.EVENT.invoker().onBreak((ServerPlayerInteractionManager)(Object)this, pos, Reason.PLAYER_CANNOT_MINE) == ActionResult.SUCCESS){
            callbackInfo.setReturnValue(true);
        }
    }

    @Inject(at = @At(value = "INVOKE", target = "net/minecraft/block/Block.onBreak(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;Lnet/minecraft/entity/player/PlayerEntity;)V", ordinal = 0, shift = At.Shift.BEFORE), method = "tryBreakBlock", cancellable = true, locals = LocalCapture.CAPTURE_FAILHARD)
    public void tryBreakBlockEvent_SuccessSurvival(BlockPos pos, CallbackInfoReturnable<Boolean> callbackInfo, BlockState blockState, BlockEntity blockEntity, Block block){
        if(this.isCreative() && OnBlockBreakAttemptEvent.EVENT.invoker().onBreak((ServerPlayerInteractionManager)(Object)this, pos, Reason.SUCCESS_CREATIVE) == ActionResult.FAIL) callbackInfo.setReturnValue(false);

        boolean usingEffectiveTool = this.player.isUsingEffectiveTool(blockState);
        ActionResult result = OnBlockBreakAttemptEvent.EVENT.invoker().onBreak((ServerPlayerInteractionManager)(Object)this, pos, usingEffectiveTool ? Reason.SUCCESS_SURVIVAL_EFFECIVE_TOOL : Reason.SUCCESS_SURVIVAL);
        if(result == ActionResult.FAIL) callbackInfo.setReturnValue(false);
    }
}
