package com.miningmark48.breathmint.events;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class EventInteract {

    @SubscribeEvent
    public void onPlayerInteract(PlayerInteractEvent event) {
        BlockState clickedState = event.getWorld().getBlockState(event.getPos());
        if ((clickedState.getBlock() == Blocks.DRAGON_HEAD || clickedState.getBlock() == Blocks.DRAGON_WALL_HEAD) && event.getWorld().isBlockPowered(event.getPos()) && event.getItemStack().getItem() == Items.GLASS_BOTTLE) {
            ItemEntity itemEntity = new ItemEntity(event.getWorld(), event.getPlayer().posX, event.getPlayer().posY, event.getPlayer().posZ);
            itemEntity.setItem(new ItemStack(Items.DRAGON_BREATH));
            event.getWorld().addEntity(itemEntity);
            event.getItemStack().shrink(1);
//            event.getPlayer().sendStatusMessage(new StringTextComponent("CLICKED HEAD"), false);
        }
    }

//    public void onDispenser()

}
