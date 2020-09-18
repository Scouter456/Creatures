package com.mv.creatures.common.blocks;

import com.mv.creatures.enums.MucusVariant;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.material.PushReaction;
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
import net.minecraft.world.*;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nonnull;
import java.util.Random;

public class MVFlailMucus extends Block {
    private static final VoxelShape Flail_Mucus_Shape = makeCuboidShape(0, 0, 0, 16, 1, 16);

    public final MucusVariant mucusVariant;

    public MVFlailMucus(MucusVariant mucus, AbstractBlock.Properties properties) {
        super(properties);
        mucusVariant = mucus;
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader world, BlockPos pos) {
        BlockState block = world.getBlockState(pos.down());
        switch (mucusVariant) {
            case flail_mucus:
            case dried_flail_mucus:
                return block.isSolidSide(world, pos, Direction.UP);
            default:
                return (world.isAirBlock(pos));

        }
    }

    @Override
    @Deprecated
    public VoxelShape getShape(BlockState state, IBlockReader access, BlockPos pos, ISelectionContext context) {
        if (mucusVariant == mucusVariant.flail_mucus) {
            return Flail_Mucus_Shape;
        }
        else if (mucusVariant == mucusVariant.dried_flail_mucus){
            return Flail_Mucus_Shape;
            }
        else {
            return VoxelShapes.fullCube();
        }
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

        if(world.isRemote && entityIn instanceof LivingEntity && (entityIn.getMotion().getX() != 0 || entityIn.getMotion().getZ() != 0) && RANDOM.nextBoolean()){
            if(mucusVariant == mucusVariant.flail_mucus){
                entityIn.setMotion(entityIn.getMotion().mul(0.6D, 1.0D, 0.6D));
            }
            else if(mucusVariant == mucusVariant.dried_flail_mucus) {
                return;
            }
        }


    }

    @Override
    @Deprecated
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld world, BlockPos pos, BlockPos facingPos) {
        BlockState blockstate = super.updatePostPlacement(stateIn, facing, facingState,world, pos, facingPos);
        if(mucusVariant == mucusVariant.flail_mucus) {
            return !stateIn.isValidPosition(world, pos) ? Blocks.AIR.getDefaultState() : super.updatePostPlacement(stateIn, facing, facingState, world, pos, facingPos);
        }
        else {
            return blockstate;
        }

    }

    @Override
    @Deprecated
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        if (worldIn.getLightFor(LightType.BLOCK, pos) > 8 ) {
            if(mucusVariant == mucusVariant.flail_mucus) {
                this.turnIntoDriedMucus(state, worldIn, pos);
            }
        }
    }

    public void turnIntoDriedMucus(BlockState state, World world, BlockPos pos) {
        if (world.func_230315_m_().func_236040_e_()) {
            world.removeBlock(pos, false);
        } else {
            world.setBlockState(pos, MVBlocks.dried_flail_mucus.get().getDefaultState());
            world.neighborChanged(pos, MVBlocks.dried_flail_mucus.get(), pos);
            System.out.println("Block Changed!!");
        }
    }
    @Override
    public PushReaction getPushReaction(BlockState state) {
        return PushReaction.NORMAL;
    }

}

