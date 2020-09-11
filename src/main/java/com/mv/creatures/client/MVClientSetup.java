package com.mv.creatures.client;

import com.mv.creatures.common.entities.MVEntities;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MVClientSetup {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent evt) {

        MVEntities.registerEntityRenderer();
    }

    @SubscribeEvent
    public static void loadComplete(FMLLoadCompleteEvent evt) {
        Minecraft.getInstance().getRenderManager().renderers.values().forEach(r -> {
            if (r instanceof LivingRenderer){

            }
        });

    }
}
