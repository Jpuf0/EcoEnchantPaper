package xyz.jpuf.ecoenchants.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import xyz.jpuf.ecoenchants.extras.Blocks.BlockLoader;

public class ClientScreenHandler implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(BlockLoader.BOX_SCREEN_HANDLER, PositionedScreen::new);
    }
}
