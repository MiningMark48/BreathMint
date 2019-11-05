package com.miningmark48.breathmint;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DispenseBottleBehavior extends DefaultDispenseItemBehavior {

    @Override
    protected ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
        World world = source.getWorld();
        IPosition iposition = DispenserBlock.getDispensePosition(source);
//        Direction direction = source.getBlockState().get(DispenserBlock.FACING);
        BlockPos pos = new BlockPos(iposition);
        Block block = world.getBlockState(pos).getBlock();

        if ((block == Blocks.DRAGON_HEAD || block == Blocks.DRAGON_WALL_HEAD) && world.isBlockPowered(pos)) {
            ItemEntity itemEntity = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ());
            itemEntity.setItem(new ItemStack(Items.DRAGON_BREATH));
            world.addEntity(itemEntity);
            stack.shrink(1);
        }
        return stack;
    }

}
