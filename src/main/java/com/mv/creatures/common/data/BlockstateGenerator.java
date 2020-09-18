package com.mv.creatures.common.data;

import com.mv.creatures.common.blocks.MVBlocks;
import com.mv.creatures.core.MVCreatures;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ExistingFileHelper;

public class BlockstateGenerator extends BlockStateProvider {
    public BlockstateGenerator(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, MVCreatures.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels(){
        simpleBlock(MVBlocks.earth_block.get());
        simpleBlock(MVBlocks.flail_mucus.get());
        simpleBlock(MVBlocks.dried_flail_mucus.get());

    }
}
