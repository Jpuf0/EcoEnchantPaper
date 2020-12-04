package xyz.jpuf.ecoenchants.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;


@Mixin(InGameHud.class)
public abstract class SpeedDisplay {

    Vec3d prevpos;


    @Inject(at = @At("TAIL"), method = "render", cancellable = true, locals = LocalCapture.NO_CAPTURE)
    private void render_speed(MatrixStack matrixStack, float f, CallbackInfo ci)
    {
        MinecraftClient.getInstance().getTickDelta();
        TextRenderer textRenderer = this.getFontRenderer();
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        textRenderer.draw(matrixStack, String.format("Speed: %.2f m/s", player.getPos().distanceTo(new Vec3d(player.prevX, player.prevY, player.prevZ))/(1f/20f)),0,100 , 0xFFFFFF);
        textRenderer.draw(matrixStack, String.format("X: %.2f m/s", Math.abs(player.getX()-player.prevX)/(1f/20f)),0,110 , 0xFFFFFF);
        textRenderer.draw(matrixStack, String.format("Y: %.2f m/s", Math.abs(player.getY()-player.prevY)/(1f/20f)),0,120 , 0xFFFFFF);
        textRenderer.draw(matrixStack, String.format("Z: %.2f m/s", Math.abs(player.getZ()-player.prevZ)/(1f/20f)),0,130 , 0xFFFFFF);
    }

    @Shadow
    public native TextRenderer getFontRenderer();

}
