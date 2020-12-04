package xyz.jpuf.ecoenchants.Blocks;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import xyz.jpuf.ecoenchants.Blocks.BlockEntities.Decoder_TableEntity;
import xyz.jpuf.ecoenchants.EcoEnchants;
import xyz.jpuf.ecoenchants.Utils.Screen.BoxScreenHandler;

public class EcoEnchantBlockEntities {

    public static final ScreenHandlerType<BoxScreenHandler> BOX_SCREEN_HANDLER;
    public static final BlockEntityType DECODER_TABLE_ENTITY;


    private static BlockEntityType register(String name) {
        return Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(EcoEnchants.MODID, name), BlockEntityType.Builder.create(Decoder_TableEntity::new, EcoEnchantBlocks.DECODER_TABLE).build(null));
    }

    static {
        BOX_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(EcoEnchants.MODID, "decoder_table"), BoxScreenHandler::new));
        DECODER_TABLE_ENTITY = register("decoder_table");
    }

    public static void register() {

    }
}
