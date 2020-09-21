package com.mv.creatures.common.entities;

import com.google.common.collect.Lists;
import com.mv.creatures.client.renderer.entity.RenderMVFlailSnail;
import com.mv.creatures.client.renderer.entity.RenderMVWorm;

import com.mv.creatures.common.entities.model.FlailSnail;
import com.mv.creatures.common.entities.model.ModelMVWorm;
import com.mv.creatures.common.items.MVItems;
import com.mv.creatures.core.MVCreatures;
import com.mv.creatures.core.registry.util.MVEntityNames;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.fml.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Mod.EventBusSubscriber(modid = MVCreatures.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MVEntities {
    //listing entity
    public static final List<EntityType<?>> ALL = new ArrayList<>();
    public static final EntityType<EntityMVWorm> sand_worm = make(MVEntityNames.SAND_WORM, EntityMVWorm::new, EntityClassification.MONSTER, 0.9F, 0.9F);
    public static final EntityType<EntityMVFlailSnail> flail_snail = make(MVEntityNames.FLAIL_SNAIL, EntityMVFlailSnail::new, EntityClassification.MONSTER, 1F, 2.5F);

    private static <E extends Entity> EntityType<E> make(ResourceLocation id, EntityType.IFactory<E> factory, EntityClassification classification, float width, float height) {
        return build(id, makeBuilder(factory, classification).size(width, height));
    }

    private static <E extends Entity> EntityType<E> make(ResourceLocation id, EntityType.IFactory<E> factory, EntityClassification classification) {
        return make(id, factory, classification, 0.6F, 1.8F);
    }

    @SuppressWarnings("unchecked")
    private static <E extends Entity> EntityType<E> build(ResourceLocation id, EntityType.Builder<E> builder) {
        EntityType<E> ret = (EntityType<E>) builder.build(id.toString()).setRegistryName(id);
        ALL.add(ret);
        return ret;
    }

    private static <E extends Entity> EntityType.Builder<E> makeCastedBuilder(@SuppressWarnings("unused") Class<E> cast, EntityType.IFactory<E> factory, EntityClassification classification) {
        return makeBuilder(factory, classification);
    }

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

    //registering spawn eggs
    @SubscribeEvent
    public static void registerSpawnEggs(RegistryEvent.Register<Item> evt) {
        IForgeRegistry<Item> r = evt.getRegistry();
        r.register(spawnEgg(sand_worm, 0x83653b, 0xffefca));
        r.register(spawnEgg(flail_snail, 0x84653b, 0xffecca));

    }

    //registering entities for spawning
    @SubscribeEvent
    public static void RegisterEntities(RegistryEvent.Register<EntityType<?>> evt) {
        evt.getRegistry().registerAll(ALL.toArray(new EntityType<?>[0]));
        registerCustomSpawnEntry(sand_worm, getSandWormBiomes,2000,2,4 , EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::canMonsterSpawn);

    }

    //registering entity attributes
    public static void addEntityAttributes() {
        GlobalEntityTypeAttributes.put(sand_worm, EntityMVWorm.registerAttributes().create());
        GlobalEntityTypeAttributes.put(flail_snail, EntityMVFlailSnail.registerAttributes().create());


    }

    //Entity biome spawnlist
    public static final List<Biome> getSandWormBiomes = Lists.newArrayList(Biomes.DESERT, Biomes.DESERT_HILLS, Biomes.DESERT_LAKES, Biomes.PLAINS);

    // registering entity renderer
    @OnlyIn(Dist.CLIENT)
    public static void registerEntityRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(sand_worm, m -> new RenderMVWorm(m, new ModelMVWorm(), 4.0F));
        RenderingRegistry.registerEntityRenderingHandler(flail_snail, m -> new RenderMVFlailSnail(m, new FlailSnail(), 1.0F));

    }

    private static <T extends MobEntity> void registerCustomSpawnEntry(EntityType<T> entity, List<Biome> biomes, int frequency, int minAmount, int maxAmount, EntitySpawnPlacementRegistry.PlacementType placementType, Heightmap.Type heightMapType, @SuppressWarnings("rawtypes") EntitySpawnPlacementRegistry.IPlacementPredicate canSpawnHere) {
        registerBiomeSpawnEntry(entity, frequency, minAmount, maxAmount, biomes);
        EntitySpawnPlacementRegistry.register(entity, placementType, heightMapType, canSpawnHere);
    }

    private static void registerBiomeSpawnEntry(EntityType<?> entity, int frequency, int minAmount, int maxAmount, List<Biome> biomes) {
        biomes.stream().filter(Objects::nonNull).forEach(biome -> biome.getSpawns(entity.getClassification()).add(new Biome.SpawnListEntry(entity, frequency, minAmount, maxAmount)));
    }


}