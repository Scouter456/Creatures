package com.mv.creatures.common.blocks;

import com.mv.creatures.common.entities.EntityMVWorm;
import com.mv.creatures.common.entities.MVEntities;
import com.mv.creatures.core.MVCreatures;
import com.mv.creatures.enums.MucusVariant;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.PushReaction;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.*;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nonnull;
import java.util.Random;

public class MVMucus extends Block {
    public static final IntegerProperty LAYERS = BlockStateProperties.LAYERS_1_8;
    private static final VoxelShape[] MUCUS_SHAPE = new VoxelShape[]{VoxelShapes.empty(), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};

    public final MucusVariant mucusVariant;

    public MVMucus(MucusVariant mucus, AbstractBlock.Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(LAYERS, 1));
        mucusVariant = mucus;


    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader world, BlockPos pos) {
        BlockState block = world.getBlockState(pos.down());
        switch (mucusVariant) {
            case mucus_layers:
            case dried_mucus_layers:
                return block.isSolidSide(world, pos, Direction.UP);
            default:
                return (world.isAirBlock(pos));

        }
    }

    @Override
    @Deprecated
    public VoxelShape getShape(BlockState state, IBlockReader access, BlockPos pos, ISelectionContext context) {
        if (mucusVariant == mucusVariant.mucus_layers) {
            return MUCUS_SHAPE[state.get(LAYERS)];
        } else if (mucusVariant == mucusVariant.dried_mucus_layers) {
            return MUCUS_SHAPE[state.get(LAYERS)];
        }
        return MUCUS_SHAPE[state.get(LAYERS)];
    }

    @Override
    @Deprecated
    public VoxelShape getCollisionShape(@Nonnull BlockState state, @Nonnull IBlockReader reader, @Nonnull BlockPos pos, ISelectionContext context) {
        return MUCUS_SHAPE[state.get(LAYERS) - 1];
    }

    @Override
    @Deprecated
    public boolean allowsMovement(@Nonnull BlockState state, @Nonnull IBlockReader reader, @Nonnull BlockPos pos, PathType pathType) {
        if (pathType == PathType.LAND) {
            return state.get(LAYERS) < 5;
        } else {
            return false;
        }
    }
    @Override
    @Deprecated
    public boolean isReplaceable(BlockState state, BlockItemUseContext context) {
        int i = state.get(LAYERS);
        if (context.getItem().getItem() == this.asItem() && i < 8) {
            if (context.replacingClickedOnBlock()) {
                return context.getFace() == Direction.UP;
            } else {
                return true;
            }
        } else {
            return i == 1;
        }
    }

    @Override
    @Nonnull
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockState state = context.getWorld().getBlockState(context.getPos());
        if (state.getBlock() == this) {
            int layer = state.get(LAYERS);
            if(mucusVariant == MucusVariant.mucus_layers) {
                return layer == 7 ? MVBlocks.mucus.get().getDefaultState() : state.with(LAYERS, Math.min(7, layer + 1));
            }
            else{
                return layer == 7 ? MVBlocks.dried_mucus.get().getDefaultState() : state.with(LAYERS, Math.min(7, layer + 1));
            }

        }
        else {
            return super.getStateForPlacement(context);
        }
    }

    @Override
    @Deprecated
    public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld world, BlockPos pos, BlockPos facingPos) {
        BlockState blockstate = super.updatePostPlacement(state, facing, facingState,world, pos, facingPos);
        if(mucusVariant == mucusVariant.mucus_layers) {
            return !state.isValidPosition(world, pos) ? Blocks.AIR.getDefaultState() : super.updatePostPlacement(state, facing, facingState, world, pos, facingPos);
        }
        else {
            return blockstate;
        }

    }

    @Override
    @Deprecated
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        if (worldIn.getLightFor(LightType.BLOCK, pos) > 8 ) {
            if(mucusVariant == mucusVariant.mucus_layers) {
                this.turnIntoDriedMucus(state, worldIn, pos);
            }
        }
    }

    public void turnIntoDriedMucus(BlockState state, World world, BlockPos pos) {
        int i = state.get(LAYERS);
        if (world.func_230315_m_().func_236040_e_()) {
            world.removeBlock(pos, false);
        } else {
            world.setBlockState(pos, MVBlocks.dried_mucus_layers.get().getDefaultState().with(LAYERS, i));
            world.neighborChanged(pos, MVBlocks.dried_mucus_layers.get(), pos);
            this.setDefaultState(this.stateContainer.getBaseState().with(LAYERS, 1));
        }

    }
    @Override
    @Deprecated
    public PushReaction getPushReaction(BlockState state) {
        return PushReaction.NORMAL;

    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> container) {
        container.add(LAYERS);
    }

}
