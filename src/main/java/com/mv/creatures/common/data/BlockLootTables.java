package com.mv.creatures.common.data;

import com.mv.creatures.common.blocks.MVBlocks;
import com.mv.creatures.core.MVCreatures;
import net.minecraft.block.Block;
import net.minecraft.loot.LootTable;

import java.util.HashSet;
import java.util.Set;

public class BlockLootTables extends net.minecraft.data.loot.BlockLootTables{
    private final Set<Block> knownBlocks = new HashSet<>();

    @Override
    protected void registerLootTable(Block block, LootTable.Builder builder){
        super.registerLootTable(block, builder);
        knownBlocks.add(block);
    }

    @Override
    protected void addTables(){

        registerDropSelfLootTable(MVBlocks.earth_block.get());
        registerSilkTouch(MVBlocks.flail_glass.get());
    }
}
