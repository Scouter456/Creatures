package com.mv.creatures.common.blocks;

import com.mv.creatures.common.items.MVItems;
import com.mv.creatures.core.MVCreatures;
import com.mv.creatures.enums.GlassVariant;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.List;


@SuppressWarnings({"WeakerAccess", "unused"})
@Nonnull
@Mod.EventBusSubscriber(modid = MVCreatures.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MVBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MVCreatures.MOD_ID);

    public static final RegistryObject<Block> earth_block                = BLOCKS.register("earth_block", () -> new Block(AbstractBlock.Properties.create(Material.EARTH).hardnessAndResistance(3.0F,2.0F).sound(SoundType.GROUND).harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool()));
    public static final RegistryObject<Block> jink_block                 = BLOCKS.register("jink_block", () -> new Block(AbstractBlock.Properties.create(Material.EARTH).hardnessAndResistance(3.0F,2.0F).sound(SoundType.GROUND).harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool()));
    public static final RegistryObject<Block> flail_glass           = BLOCKS.register("flail_glass", () -> new MVFlailGlass(GlassVariant.flail_glass, Block.Properties.create(Material.GLASS).hardnessAndResistance(3.0F, 10.0F).sound(SoundType.GLASS).notSolid().harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool()));
    @SubscribeEvent

    public static void registerItemblocks(RegistryEvent.Register<Item> evt) {
        IForgeRegistry<Item> r = evt.getRegistry();
        List<RegistryObject<? extends Block>> standard = Arrays.asList(earth_block, jink_block, flail_glass);

        for (RegistryObject<? extends Block> b : standard) {
            r.register(new BlockItem(b.get(), MVItems.defaultBuilder()).setRegistryName(b.get().getRegistryName()));
        }
    }
}
