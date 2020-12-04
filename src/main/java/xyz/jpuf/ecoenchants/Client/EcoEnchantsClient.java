package xyz.jpuf.ecoenchants.Client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import xyz.jpuf.ecoenchants.Blocks.EcoEnchantBlockEntities;
import xyz.jpuf.ecoenchants.Utils.Screen.BoxScreen;

@Environment(EnvType.CLIENT)
public class EcoEnchantsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(EcoEnchantBlockEntities.BOX_SCREEN_HANDLER, BoxScreen::new);
    }
}
