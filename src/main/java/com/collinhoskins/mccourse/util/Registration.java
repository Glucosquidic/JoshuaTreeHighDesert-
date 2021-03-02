package com.collinhoskins.mccourse.util;

import com.collinhoskins.mccourse.MCCourseMod;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Registration {
    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, MCCourseMod.MOD_ID);
    public static final DeferredRegister<Item> ITEMS
            = DeferredRegister.create(ForgeRegistries.ITEMS, MCCourseMod.MOD_ID);
//    public static final DeferredRegister<EntityType<?>> ENTITIES
//            = DeferredRegister.create(ForgeRegistries.ENTITIES, MCCourseMod.MOD_ID);

    public static final DeferredRegister<Biome> BIOMES
            = DeferredRegister.create(ForgeRegistries.BIOMES, MCCourseMod.MOD_ID);

    public static final DeferredRegister<SurfaceBuilder<?>> SURFACE_BUILDERS
            = DeferredRegister.create(ForgeRegistries.SURFACE_BUILDERS, MCCourseMod.MOD_ID);
    public static final DeferredRegister<Fluid> FLUIDS
            = DeferredRegister.create(ForgeRegistries.FLUIDS, MCCourseMod.MOD_ID);

    public static void init()
    {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
//        ENTITIES.register(eventBus);
        BIOMES.register(eventBus);
        SURFACE_BUILDERS.register(eventBus);
        FLUIDS.register(eventBus);

    }
}
