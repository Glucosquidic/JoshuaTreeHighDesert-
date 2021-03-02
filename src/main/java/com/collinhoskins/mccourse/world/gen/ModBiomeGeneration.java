package com.collinhoskins.mccourse.world.gen;


import com.collinhoskins.mccourse.MCCourseMod;
import com.collinhoskins.mccourse.world.biome.ModBiomes;
import com.collinhoskins.mccourse.world.biome.ModConfiguredSurfaceBuilders;
import com.collinhoskins.mccourse.world.biome.ModSurfaceBuilders;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

import static net.minecraftforge.common.BiomeDictionary.Type.*;

@Mod.EventBusSubscriber(modid = MCCourseMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBiomeGeneration
{
    @SubscribeEvent(priority = EventPriority.LOW)
    public static void register(final RegistryEvent.Register<SurfaceBuilder<?>> event)
    {
        registerBiome(ModConfiguredSurfaceBuilders.OIL_SURFACE.getLocation(),
                Blocks.PODZOL.getDefaultState(), Blocks.DIRT.getDefaultState(), Blocks.DIAMOND_ORE.getDefaultState());
    }

    @SubscribeEvent
    public static void setupBiome(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() ->
        {
            addBiome(ModBiomes.OIL_BIOME.get(), BiomeManager.BiomeType.COOL, 100, COLD, FOREST, WET);
        });
    }

    private static void registerBiome(ResourceLocation biomeRL, BlockState topBlock, BlockState fillerBlock, BlockState underwaterBlock)
    {
        Registry.register(WorldGenRegistries.CONFIGURED_SURFACE_BUILDER, biomeRL, ModSurfaceBuilders.LOGGING_DEFAULT.get().func_242929_a(
                new SurfaceBuilderConfig(topBlock, fillerBlock, underwaterBlock)));
    }

    private static void addBiome(Biome biome, BiomeManager.BiomeType type, int weight, BiomeDictionary.Type... types)
    {
        RegistryKey<Biome> key = RegistryKey.getOrCreateKey(ForgeRegistries.Keys.BIOMES,
                Objects.requireNonNull(ForgeRegistries.BIOMES.getKey(biome)));

        BiomeDictionary.addTypes(key, types);
        BiomeManager.addBiome(type, new BiomeManager.BiomeEntry(key, weight));
    }

    // JENNA BIOME

    @SubscribeEvent(priority = EventPriority.LOW)
    public static void registerJenna(final RegistryEvent.Register<SurfaceBuilder<?>> event)
    {
        registerJennaBiome(ModConfiguredSurfaceBuilders.JENNA_SURFACE.getLocation(),
              Blocks.RED_SAND.getDefaultState(), Blocks.SAND.getDefaultState(),
                Blocks.EMERALD_BLOCK.getDefaultState());
    }

    @SubscribeEvent
    public static void setupJennaBiome(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() ->
        {
            addJennaBiome(ModBiomes.JENNA_BIOME.get(), BiomeManager.BiomeType.WARM, 150, HOT, DRY, DEAD);
        });
    }

    private static void registerJennaBiome(ResourceLocation biomeRL, BlockState topBlock, BlockState fillerBlock, BlockState underwaterBlock)
    {
        Registry.register(WorldGenRegistries.CONFIGURED_SURFACE_BUILDER, biomeRL, ModSurfaceBuilders.LOGGING_DEFAULT.get().func_242929_a(
                new SurfaceBuilderConfig(topBlock, fillerBlock, underwaterBlock)));
    }

    private static void addJennaBiome(Biome biome, BiomeManager.BiomeType type, int weight, BiomeDictionary.Type... types)
    {
        RegistryKey<Biome> key = RegistryKey.getOrCreateKey(ForgeRegistries.Keys.BIOMES,
                Objects.requireNonNull(ForgeRegistries.BIOMES.getKey(biome)));

        BiomeDictionary.addTypes(key, types);
        BiomeManager.addBiome(type, new BiomeManager.BiomeEntry(key, weight));
    }
}
