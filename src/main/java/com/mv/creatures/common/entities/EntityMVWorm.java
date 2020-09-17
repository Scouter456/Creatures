package com.mv.creatures.common.entities;

import com.mv.creatures.common.blocks.MVBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

public class EntityMVWorm extends MonsterEntity
{

    public EntityMVWorm(EntityType<? extends EntityMVWorm> type, World worldIn) { super(type, worldIn);}


    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(1, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(2, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
    }

        public static AttributeModifierMap.MutableAttribute registerAttributes() {
            return MonsterEntity.func_234295_eP_()
                    .createMutableAttribute(Attributes.MAX_HEALTH, 40.0D)
                    .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.28D);
        }

    @Override
    public void livingTick(){
        super.livingTick();
        BlockPos pos = new BlockPos(MathHelper.floor(this.getPosX()), MathHelper.floor(this.getPosY()), MathHelper.floor(this.getPosZ()));
        BlockState blockstate = MVBlocks.flail_glass.get().getDefaultState();
        if(this.isOnGround() && this.world.isAirBlock(pos) && this.world.getGameRules().getBoolean(GameRules.MOB_GRIEFING) && blockstate.isValidPosition(this.world, pos) && this.world.getBiome(pos).getTemperature(pos) < 1.2F){
            this.world.setBlockState(pos, blockstate);

        }
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source)   { return SoundEvents.ENTITY_SPIDER_HURT;
    }
    @Override
    protected SoundEvent getDeathSound()   { return SoundEvents.ENTITY_SPIDER_DEATH;
    }
}