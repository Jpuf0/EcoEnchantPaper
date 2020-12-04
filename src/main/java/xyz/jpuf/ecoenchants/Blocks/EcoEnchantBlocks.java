package xyz.jpuf.ecoenchants.Blocks;

import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import xyz.jpuf.ecoenchants.Blocks.Blocks.Decoder_Table;
import xyz.jpuf.ecoenchants.EcoEnchants;

public class EcoEnchantBlocks {

    public static final Block DECODER_TABLE;


    private static Block register(String name, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier(EcoEnchants.MODID, name), block);
    }

    static {
        DECODER_TABLE = register("decoder_table", new Decoder_Table());
    }

    public static void register(){

    }

}
