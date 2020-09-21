package com.mv.creatures.common.data;

import com.mv.creatures.common.blocks.MVBlocks;
import com.mv.creatures.common.entities.MVEntities;
import com.mv.creatures.core.MVCreatures;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class LanguageGenerator extends LanguageProvider {
    public LanguageGenerator(DataGenerator gen){
        super(gen, MVCreatures.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations(){
        addBlock(MVBlocks.dried_mucus, "Dried Mucus Block");
        addBlock(MVBlocks.dried_mucus_layers, "Dried Mucus");
        addBlock(MVBlocks.mucus, "Mucus Block");
        addBlock(MVBlocks.mucus_layers, "Mucus");
        addBlock(MVBlocks.earth_block, "Earth Block");
        addBlock(MVBlocks.jink_block, "Jink Block");
    }
}
