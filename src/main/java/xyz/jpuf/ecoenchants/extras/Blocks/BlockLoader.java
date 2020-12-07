package xyz.jpuf.ecoenchants.extras.Blocks;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import xyz.jpuf.ecoenchants.Utils.Screen.BoxScreenHandler;
import xyz.jpuf.ecoenchants.extras.Blocks.Blocks.BoxBlock;
import xyz.jpuf.ecoenchants.extras.Blocks.Blocks.BoxBlockEntity;
import xyz.jpuf.ecoenchants.extras.Blocks.Blocks.exampleBlock;
import xyz.jpuf.ecoenchants.EcoEnchants;

public class BlockLoader {
    public static final Block EXAMPLE_BLOCK;
    public static final Block BOX = new BoxBlock();
    public static final BlockEntityType<BoxBlockEntity> BOX_ENTITY = BlockEntityType.Builder.create(BoxBlockEntity::new, BOX).build(null);
    public static final ScreenHandlerType<BoxScreenHandler> BOX_SCREEN_HANDLER = ScreenHandlerRegistry.registerExtended(id("box"), BoxScreenHandler::new);

    private static Block register(String name, Block block) {
        Registry.register(Registry.ITEM, id(name), new BlockItem(block, new Item.Settings().group(EcoEnchants.ECOENCHANTS)));
        return (Block) Registry.register(Registry.BLOCK, id(name), block);
    }

    public static Identifier id(String path) {
        return new Identifier(EcoEnchants.MODID, path);
    }

    static {
        EXAMPLE_BLOCK = register("example_block", new exampleBlock());
        register("box", new BoxBlock());
        Registry.register(Registry.BLOCK_ENTITY_TYPE, id("box"), BOX_ENTITY);
    }

    public static void load(){
    }
}
