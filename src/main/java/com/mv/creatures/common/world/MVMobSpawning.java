/*package com.mv.creatures.common.world;

import com.mv.creatures.common.entities.MVEntities;
import com.mv.creatures.core.MVCreatures;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = MVCreatures.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MVMobSpawning {
    @SubscribeEvent
    public static void generateMobs(FMLLoadCompleteEvent event) {
        // Nether Mobs
        for (Biome biome : ForgeRegistries.BIOMES) {
            if (biome.getCategory() == Biome.Category.NETHER) {
            }

            // End Mobs
            else if (biome.getCategory() == Biome.Category.THEEND) {
            }

            // Overworld Mobs
            else {
                if (biome.getCategory() != Biome.Category.OCEAN) {
                    biome.getSpawns(EntityClassification.MONSTER)
                            .add(new Biome.SpawnListEntry(MVEntities.sand_worm, 1000, 3, 5));
                }
            }
        }
    }
}

*/

