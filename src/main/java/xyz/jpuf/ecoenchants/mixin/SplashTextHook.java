package xyz.jpuf.ecoenchants.mixin;

import net.minecraft.client.gui.screen.TitleScreen;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class SplashTextHook {
    @Shadow private @Nullable String splashText;

    @Inject(at = @At("HEAD"), method = "init()V")
    private void init(CallbackInfo callbackInfo){
        splashText = "I have Hooked into the Splash Text";
    }
}
