package com.mv.creatures.common.data;

import com.mv.creatures.common.blocks.MVBlocks;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.loot.*;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.loot.conditions.TableBonus;
import net.minecraft.loot.functions.SetCount;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import java.util.HashSet;
import java.util.Set;

public class LootTableBlocks extends net.minecraft.data.loot.BlockLootTables{
    private final Set<Block> knownBlocks = new HashSet<>();

    @Override
    protected void registerLootTable(Block block, LootTable.Builder builder) {
        super.registerLootTable(block, builder);
        knownBlocks.add(block);


    }

    @Override
    protected void addTables() {
        registerDropSelfLootTable(MVBlocks.earth_block.get());
        registerDropSelfLootTable(MVBlocks.jink_block.get());
        registerSilkTouch(MVBlocks.mucus.get());
        registerSilkTouch(MVBlocks.dried_mucus.get());

    }
    private void registerLeavesNoSapling(Block leaves) {
        LootEntry.Builder<?> sticks = withExplosionDecay(leaves, ItemLootEntry.builder(Items.STICK)
                .acceptFunction(SetCount.builder(RandomValueRange.of(1.0F, 2.0F)))
                .acceptCondition(TableBonus.builder(Enchantments.FORTUNE, 0.02F, 0.022222223F, 0.025F, 0.033333335F, 0.1F)));
        registerLootTable(leaves, droppingWithSilkTouchOrShears(leaves, sticks));
    }


    // [VanillaCopy] super.droppingWithChancesAndSticks, but non-silk touch parameter can be an item instead of a block
    private static LootTable.Builder silkAndStick(Block block, IItemProvider nonSilk, float... nonSilkFortune) {
        ILootCondition.IBuilder NOT_SILK_TOUCH_OR_SHEARS = ObfuscationReflectionHelper.getPrivateValue(net.minecraft.data.loot.BlockLootTables.class, null, "field_218577_e");
        return droppingWithSilkTouchOrShears(block, withSurvivesExplosion(block, ItemLootEntry.builder(nonSilk.asItem())).acceptCondition(TableBonus.builder(Enchantments.FORTUNE, nonSilkFortune))).addLootPool(LootPool.builder().rolls(ConstantRange.of(1)).acceptCondition(NOT_SILK_TOUCH_OR_SHEARS).addEntry(withExplosionDecay(block, ItemLootEntry.builder(Items.STICK).acceptFunction(SetCount.builder(RandomValueRange.of(1.0F, 2.0F)))).acceptCondition(TableBonus.builder(Enchantments.FORTUNE, 0.02F, 0.022222223F, 0.025F, 0.033333335F, 0.1F))));
    }

    private void registerEmpty(Block b) {
        registerLootTable(b, LootTable.builder());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return knownBlocks;
    }
}
