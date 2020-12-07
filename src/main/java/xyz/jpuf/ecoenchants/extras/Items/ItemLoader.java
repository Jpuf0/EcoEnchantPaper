package xyz.jpuf.ecoenchants.extras.Items;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import xyz.jpuf.ecoenchants.EcoEnchants;
import xyz.jpuf.ecoenchants.extras.Blocks.Blocks.exampleBlock;

public class ItemLoader {

    public static final BlockItem EXAMPLE_BLOCKITEM;


    private static BlockItem register(String name, Block block) {
        return (BlockItem) Registry.register(Registry.ITEM, new Identifier(EcoEnchants.MODID, name), new BlockItem(block, new Item.Settings().group(EcoEnchants.ECOENCHANTS)));
    }

    static {
        EXAMPLE_BLOCKITEM = register("example_block", new exampleBlock());
    }

    public static void load(){
    }
}
