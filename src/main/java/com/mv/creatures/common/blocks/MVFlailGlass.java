package com.mv.creatures.common.blocks;

import com.mv.creatures.enums.GlassVariant;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nonnull;
import java.util.Random;

public class MVFlailGlass extends Block {
    private static final VoxelShape Flail_Glass_Shape = makeCuboidShape(0, 0, 0, 16, 1, 16);

    public final GlassVariant glassVariant;

    public MVFlailGlass(GlassVariant glass, AbstractBlock.Properties properties) {
        super(properties);
        glassVariant = glass;
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader world, BlockPos pos) {
        BlockState block = world.getBlockState(pos.down());
        switch (glassVariant) {
            case flail_glass:
                return block.isSolidSide(world, pos, Direction.UP);
            default:
                return (world.isAirBlock(pos));
        }
    }

    @Override
    @Deprecated
    public VoxelShape getShape(BlockState state, IBlockReader access, BlockPos pos, ISelectionContext context) {
        if (glassVariant == GlassVariant.flail_glass) {
            return Flail_Glass_Shape;

        }
        return VoxelShapes.fullCube();
    }

   /* public static boolean canPlaceGlassAt(IWorldReader world, BlockPos pos){
        BlockState state = world.getBlockState((pos.down()));
        if (state.getMaterial() == Material.EARTH || state.getMaterial() == Material.ORGANIC) {
            return true;
        } else {
            return false;
        }
    }*/

    @Override
    @Deprecated
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entityIn) {
        super.onEntityCollision(state, world, pos, entityIn);
        if(world.isRemote && entityIn instanceof LivingEntity && (entityIn.getMotion().getX() != 0 || entityIn.getMotion().getZ() != 0) && RANDOM.nextBoolean());

    }
    @Override
    @Deprecated
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        if (worldIn.getLightFor(LightType.BLOCK, pos) > 5) {
            this.turnIntoDriedMucus(state, worldIn, pos);
        }

    }

    public void turnIntoDriedMucus(BlockState state, World world, BlockPos pos) {
        if (world.func_230315_m_().func_236040_e_()) {
            world.removeBlock(pos, false);
        } else {
            world.setBlockState(pos, MVBlocks.earth_block.get().getDefaultState());
            System.out.println("Block Changed!!");
        }
    }

}

