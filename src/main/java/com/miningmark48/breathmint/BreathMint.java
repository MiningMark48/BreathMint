package com.miningmark48.breathmint;

import com.miningmark48.breathmint.behavior.DispenseBottleBehavior;
import com.miningmark48.breathmint.events.EventInteract;
import net.minecraft.block.DispenserBlock;
import net.minecraft.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("breathmint")
public class BreathMint {

    private static BreathMint instance = null;

    public static BreathMint getInstance() {
        assert instance != null;
        return instance;
    }

    public BreathMint() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

//        ModLoadingContext.get().registerConfig(Type.SERVER, ModConfig.serverSpec);
//        ModLoadingContext.get().registerConfig(Type.CLIENT, ModConfig.clientSpec);
//        ModLoadingContext.get().registerConfig(Type.COMMON, ModConfig.commonSpec);

        eventBus.addListener(this::setup);
        eventBus.addListener(this::finishLoad);
        eventBus.addListener(this::setupClient);

//        eventBus.addListener(ModConfig::onLoad);
//        eventBus.addListener(ModConfig::onFileChange);

        MinecraftForge.EVENT_BUS.register(new EventInteract());
        DispenserBlock.registerDispenseBehavior(Items.GLASS_BOTTLE, new DispenseBottleBehavior());

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }


    private void setup(FMLCommonSetupEvent event) {
        instance = (BreathMint) ModLoadingContext.get().getActiveContainer().getMod();
    }

    private void setupClient(final FMLClientSetupEvent event) {

    }

    private void finishLoad(FMLLoadCompleteEvent event) {

    }

}
