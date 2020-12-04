package xyz.jpuf.ecoenchants.Items;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import xyz.jpuf.ecoenchants.Blocks.EcoEnchantBlocks;
import xyz.jpuf.ecoenchants.EcoEnchants;

public class EcoEnchantsItems {

    public static final Item DECODER_TABLE;

    private static Item register(Block block){
        return register(new BlockItem(block, new Item.Settings()));
    }
    private static Item register(Block block, ItemGroup group) {
        return register(new BlockItem(block, (new Item.Settings()).group(group)));
    }
    private static Item register(BlockItem item){
        return register((Block)item.getBlock(), (Item)item);
    }
    protected static Item register(Block block, Item item){
        return register(Registry.BLOCK.getId(block), item);
    }
    private static Item register(String id, Item item){
        return register(new Identifier(id), item);
    }
    private static Item register(Identifier id, Item item){
        if (item instanceof BlockItem){
            ((BlockItem)item).appendBlocks(Item.BLOCK_ITEMS, item);
        }

        return (Item)Registry.register(Registry.ITEM, (Identifier)id, item);
    }

    static {
        DECODER_TABLE = register(EcoEnchantBlocks.DECODER_TABLE, EcoEnchants.ECOENCHANTS);
    }

    public static void register(){

    }

}
