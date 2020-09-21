package com.mv.creatures.common.data;

import com.mv.creatures.common.blocks.MVBlocks;
import com.mv.creatures.core.MVCreatures;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.*;

import static com.mv.creatures.core.MVCreatures.prefix;
public class ItemModelGenerator extends ItemModelProvider {
    public ItemModelGenerator(DataGenerator generator, ExistingFileHelper existingFileHelper){
        super(generator, MVCreatures.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels(){
        for(Item i : Registry.ITEM){
            if (i instanceof SpawnEggItem && i.getRegistryName().getNamespace().equals(MVCreatures.MOD_ID)){
                getBuilder(i.getRegistryName().getPath()).parent((getExistingFile(new ResourceLocation("item/template_spawn_egg"))));
            }
        }
        toBlock(MVBlocks.earth_block.get());
        toBlock(MVBlocks.jink_block.get());
        toBlock(MVBlocks.mucus.get());
        toBlock(MVBlocks.dried_mucus.get());

    }
    private void toBlock(Block b) {
        toBlockModel(b, b.getRegistryName().getPath());
    }

    private void toBlockModel(Block b, String model) {
        toBlockModel(b, prefix("block/" + model));
    }

    private void toBlockModel(Block b, ResourceLocation model) {
        withExistingParent(b.getRegistryName().getPath(), model);
    }
}
