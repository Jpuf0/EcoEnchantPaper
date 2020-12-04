package xyz.jpuf.ecoenchants.Enchantments.normal;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TelekinisisLogic {
    public static void tryTelekinis(World world, BlockPos blockPos, BlockState blockState, PlayerEntity playerEntity) {
        if(world.isClient) return;
        if(playerEntity == null) return;

        ItemStack Item = playerEntity.getMainHandStack();
        if(Item == ItemStack.EMPTY || !Item.hasEnchantments()) return;

//        boolean hasAutoSmelt = Registry.ENCHANTMENT.AUTOSMELT.hasEnchantment(Item);

        Block currentBlock = blockState.getBlock();
        doTelekinisis(world,blockPos,blockState,playerEntity,Item);
    }

    private static int doTelekinisis(World world, BlockPos blockPos, BlockState blockState, PlayerEntity playerEntity, ItemStack item) {
        //Block.dropStacks(blockState, world, playerEntity.getBlockPos(), null, playerEntity, item);
        System.out.println(blockState.getBlock().asItem().getDefaultStack().toString());
        playerEntity.giveItemStack(/*blockState.getBlock().asItem().getDefaultStack()*/BlockCheckLogic(blockState)); /*Corrects the Item Given from blockState.getBlock().asItem().getDefaultStack().finishUsing(world, playerEntity) to the correct item given the item and enchants*/
        world.breakBlock(blockPos, false);
        item.postMine(world, blockState, blockPos, playerEntity);

        item.damage(1, playerEntity,playerEntity1 -> {
            playerEntity1.sendToolBreakStatus(playerEntity.getActiveHand());
        });

        playerEntity.addExhaustion(0.005F * 1);
        return 1;
    }
    private static ItemStack BlockCheckLogic(BlockState block){
        String item = block.getBlock().asItem().getDefaultStack().toString();
        if (item.equals("1 stone")) {
            return new ItemStack(Items.COBBLESTONE);
        } else if (item.equals("1 grass_block")) {
            return new ItemStack(Items.DIRT);
        }
        return block.getBlock().asItem().getDefaultStack();
    }
}
