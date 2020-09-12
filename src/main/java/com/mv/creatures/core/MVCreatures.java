package com.mv.creatures.core;


import com.mv.creatures.common.blocks.MVBlocks;
import com.mv.creatures.common.entities.MVEntities;
import com.mv.creatures.common.items.MVItems;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerAboutToStartEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(value = MVCreatures.MOD_ID)
public class MVCreatures
{
    public static final String MOD_ID = "mvcreatures";

    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
    private static final String MODEL_DIR = "textures/model/";


    public MVCreatures() {

        MinecraftForge.EVENT_BUS.addListener(this::startServer);

        IEventBus modbus = FMLJavaModLoadingContext.get().getModEventBus();
        MVBlocks.BLOCKS.register(modbus);
        MVItems.ITEMS.register(modbus);

    }

    @SubscribeEvent
    public static void init(FMLCommonSetupEvent evt){
        System.out.println("Worm Attributes getting loaded 2");
        MVEntities.addEntityAttributes();
    }
    public void startServer(FMLServerAboutToStartEvent event) {
    }

    public static ResourceLocation prefix(String name) {
        return new ResourceLocation(MOD_ID, name);
    }

    public static ResourceLocation getModelTexture(String name) {
        return new ResourceLocation(MOD_ID, MODEL_DIR + name);
    }
}
