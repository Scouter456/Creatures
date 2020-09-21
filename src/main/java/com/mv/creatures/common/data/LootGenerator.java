package com.mv.creatures.common.data;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.loot.LootParameterSet;
import net.minecraft.loot.LootParameterSets;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.ValidationTracker;
import net.minecraft.util.ResourceLocation;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class LootGenerator extends LootTableProvider {
    public LootGenerator(DataGenerator generator){
        super(generator);
    }
    private final List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> tables = ImmutableList.of(
            Pair.of(LootTableBlocks::new, LootParameterSets.BLOCK),
            Pair.of(EntityLootTables::new, LootParameterSets.ENTITY)
    );

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationTracker validationtracker) {
        // [VanillaCopy] super, but remove call that checks that all vanilla tables are accounted for, because we aren't vanilla.
        // Except validation issues occur when attempting to generate loot tables from other loot tables (see: EntityLootTables)
        //map.forEach((id, builder) -> LootTableManager.func_227508_a_(validationtracker, id, builder));
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> getTables() {
        return tables;
    }

    @Override
    public String getName() {
        return "MVCreatures loot tables";
    }
}
