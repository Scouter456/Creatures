package com.mv.creatures.common.data;

import com.mv.creatures.common.entities.MVEntities;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.loot.*;
import net.minecraft.loot.functions.LootingEnchantBonus;
import net.minecraft.loot.functions.SetCount;

import java.util.HashSet;
import java.util.Set;

public class EntityLootTables extends net.minecraft.data.loot.EntityLootTables{

    private final Set<EntityType<?>> knownEntities = new HashSet<>();

    @Override
    protected void registerLootTable(EntityType<?> entity, LootTable.Builder builder) {
        super.registerLootTable(entity, builder);
        knownEntities.add(entity);


    }
    @Override
    protected void addTables() {
        registerLootTable(MVEntities.sand_worm, LootTable.builder()
                                                        .addLootPool(LootPool.builder()
                                                                .rolls(ConstantRange.of(1))
                                                                .addEntry((ItemLootEntry.builder(Blocks.SAND))
                                                                        .acceptFunction(SetCount.builder(RandomValueRange.of(0.0F, 2.0F)))
                                                                        .acceptFunction(LootingEnchantBonus.builder(RandomValueRange.of(0.0F, 2.0F))))));

    }
    public LootTable.Builder emptyLootTable() {
        return LootTable.builder();
    }

    public LootTable.Builder fromEntityLootTable(EntityType<?> parent) {
        return LootTable.builder()
                .addLootPool(LootPool.builder()
                        .rolls(ConstantRange.of(1))
                        .addEntry(TableLootEntry.builder(parent.getLootTable())));
    }

    @Override
    public Set<EntityType<?>> getKnownEntities() {
        return knownEntities;
    }
}
