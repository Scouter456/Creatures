package com.mv.creatures.common.data;

import com.mv.creatures.core.MVCreatures;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = MVCreatures.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent evt){
        if(evt.includeServer())
            registerServerProviders(evt.getGenerator(), evt);

        if(evt.includeClient())
            registerClientProviders(evt.getGenerator(), evt);

    }

    private static void registerClientProviders(DataGenerator generator, GatherDataEvent evt) {
        ExistingFileHelper helper = evt.getExistingFileHelper();
        generator.addProvider(new LootGenerator(generator));
    }

    private static void registerServerProviders(DataGenerator generator, GatherDataEvent evt) {
        ExistingFileHelper helper = evt.getExistingFileHelper();
        generator.addProvider(new BlockstateGenerator(generator, helper));
        generator.addProvider(new ItemModelGenerator(generator, helper));
        generator.addProvider(new LanguageGenerator(generator));

    }

}