package com.mv.creatures.common.items;

import com.mv.creatures.common.blocks.MVBlocks;
import com.mv.creatures.core.MVCreatures;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import javax.annotation.Nullable;
import java.util.UUID;
public class MVItems {


    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MVCreatures.MOD_ID);


    public static ItemGroup creativeTab = new ItemGroup(MVCreatures.MOD_ID) {
        @Override
        public ItemStack createIcon() {return new ItemStack(MVBlocks.earth_block.get());}

    };

    public static Item.Properties defaultBuilder() {
        return new Item.Properties().group(creativeTab);
    }

    public static Item.Properties unstackable() {
        return defaultBuilder().maxStackSize(1);
    }
}
