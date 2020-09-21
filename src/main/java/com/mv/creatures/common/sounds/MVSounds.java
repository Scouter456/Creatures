package com.mv.creatures.common.sounds;

import com.mv.creatures.core.MVCreatures;
import net.minecraft.block.SoundType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MVCreatures.MOD_ID)

public class MVSounds {

    public static final SoundEvent MUCUS = createEvent("mucus_mine");


    private static SoundEvent createEvent(String sound) {
        ResourceLocation name = MVCreatures.prefix(sound);
        return new SoundEvent(name).setRegistryName(name);
    }
    /*
    private static SoundType createType(String sound){
        ResourceLocation name = MVCreatures.prefix(sound);
        return new SoundType(name)
    }
    */
    @SubscribeEvent
    public static void registerSounds(RegistryEvent.Register<SoundEvent> event) {
        event.getRegistry().registerAll(MUCUS);
    }

    private MVSounds() {}


}
