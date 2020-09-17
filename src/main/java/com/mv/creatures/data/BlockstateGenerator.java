/*package com.mv.creatures.data;

import com.mv.creatures.common.blocks.MVBlocks;
import com.mv.creatures.core.MVCreatures;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.client.model.generators.ExistingFileHelper;

import static com.mv.creatures.core.MVCreatures.prefix;


public class BlockstateGenerator extends BlockStateProvider {
    public BlockstateGenerator(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, MVCreatures.MOD_ID, exFileHelper);
    }
    @Override
    protected void registerStatesAndModels(){
        simpleBlock(MVBlocks.earth_block.get(), cubeAllTinted(MVBlocks.earth_block.getId().getPath(), MVBlocks.earth_block.getId().getPath()));
    }

    private BlockModelBuilder cubeAllTinted(String name, String all, boolean flipV) {
        String parent = flipV ? "block/util/cube_tinted_all_z" : "block/util/cube_tinted_all";
        return models().withExistingParent(name, prefix(parent)).texture("all", "block/" + all);
    }
    private BlockModelBuilder cubeAllTinted(String name, String all) {
        return cubeAllTinted(name, all, false);
    }
}
*/