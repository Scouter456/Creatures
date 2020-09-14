package com.mv.creatures.core.registry.util;

import com.mv.creatures.common.entities.MVEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;

import java.util.List;

public class MVSpawnRegistry {
    public static void MVSpawnRegistry (EntityType<?> entity, List<Biome> biomes){
        
        if(entity == MVEntities.sand_worm){
            for(Biome biome : biomes){
                if(biome == Biomes.DESERT){
                    biome.getSpawns(entity.getClassification()).add(new Biome.SpawnListEntry(entity, 25, 2,4));
                }
            }
        }
    }

}
