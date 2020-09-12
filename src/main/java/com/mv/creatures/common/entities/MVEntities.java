package com.mv.creatures.common.entities;

import com.mv.creatures.client.renderer.entity.RenderMVWorm;
import com.mv.creatures.common.entities.model.ModelMVWorm;
import com.mv.creatures.common.items.MVItems;
import com.mv.creatures.core.MVCreatures;
import com.mv.creatures.core.registry.util.MVEntityNames;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = MVCreatures.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MVEntities {
    public static final List<EntityType<?>> ALL = new ArrayList<>();
    public static final EntityType<EntityMVWorm> sand_worm = make(MVEntityNames.SAND_WORM, EntityMVWorm::new, EntityClassification.MONSTER,0.9F,0.9F);


    private static <E extends Entity> EntityType<E> make(ResourceLocation id, EntityType.IFactory<E> factory, EntityClassification classification, float width, float height) {
        return build(id, makeBuilder(factory, classification).size(width, height));
    }

   /* private static <E extends Entity> EntityType<E> make(ResourceLocation id, EntityType.IFactory<E> factory, EntityClassification classification) {
        return make(id, factory, classification, 0.6F, 1.8F);
    }
*/
    @SuppressWarnings("unchecked")
    private static <E extends Entity> EntityType<E> build(ResourceLocation id, EntityType.Builder<E> builder) {
        EntityType<E> ret = (EntityType<E>) builder.build(id.toString()).setRegistryName(id);
        ALL.add(ret);
        return ret;
    }
/*
    private static <E extends Entity> EntityType.Builder<E> makeCastedBuilder(@SuppressWarnings("unused") Class<E> cast, EntityType.IFactory<E> factory, EntityClassification classification) {
        return makeBuilder(factory, classification);
    }
*/
    private static <E extends Entity> EntityType.Builder<E> makeBuilder(EntityType.IFactory<E> factory, EntityClassification classification) {
        return EntityType.Builder.create(factory, classification).
                size(0.6F, 1.8F).
                setTrackingRange(80).
                setUpdateInterval(3).
                setShouldReceiveVelocityUpdates(true);
    }

    private static Item spawnEgg(EntityType<?> type, int color, int color2) {
        ResourceLocation eggId = new ResourceLocation(type.getRegistryName().getNamespace(), type.getRegistryName().getPath() + "_spawn_egg");
        return new SpawnEggItem(type, color, color2, MVItems.defaultBuilder()).setRegistryName(eggId);
    }

    @SubscribeEvent
    public static void registerSpawnEggs(RegistryEvent.Register<Item> evt){
        IForgeRegistry<Item> r = evt.getRegistry();
        r.register(spawnEgg(sand_worm, 0x83653b, 0xffefca));

    }

    @SubscribeEvent
    public static void RegisterEntities(RegistryEvent.Register<EntityType<?>> evt) {
        evt.getRegistry().registerAll(ALL.toArray(new EntityType<?>[0]));
        EntitySpawnPlacementRegistry.register(sand_worm, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::canMonsterSpawn);
    }

    public static void addEntityAttributes(){
        GlobalEntityTypeAttributes.put(sand_worm, EntityMVWorm.registerAttributes().create());

    }
    @OnlyIn(Dist.CLIENT)
    public static void registerEntityRenderer(){
        RenderingRegistry.registerEntityRenderingHandler(sand_worm, m -> new RenderMVWorm(m, new ModelMVWorm(),4.0F));

    }
}
