package com.collinhoskins.mccourse.world.feature;

import com.collinhoskins.mccourse.MCCourseMod;
import com.collinhoskins.mccourse.block.ModBlocks;
import com.collinhoskins.mccourse.block.ModFluids;
import com.collinhoskins.mccourse.block.RedwoodTree;
import com.collinhoskins.mccourse.world.gen.ModTreeGeneration;
import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.trees.Tree;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.World;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.blockplacer.ColumnBlockPlacer;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.DarkOakFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.MegaPineFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.NoPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.treedecorator.BeehiveTreeDecorator;
import net.minecraft.world.gen.trunkplacer.DarkOakTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.GiantTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;
import net.minecraftforge.fml.config.ModConfig;

import javax.annotation.Nullable;
import java.util.OptionalInt;
import java.util.Random;

import static net.minecraft.util.registry.Registry.register;

public class RedwoodTreeFeature
{
//    public static RedwoodTreeFeature REDWOODTREE;
//
//    public RedwoodTreeFeature(Codec<BaseTreeFeatureConfig> codec) {
//        super(codec);
//
//    }
//    public ConfiguredFeature<?, ?> configure()
//    {
//        return this.setConfiguration().withPlacement(Placement.DARK_OAK_TREE
//                .configure(new NoPlacementConfig()));
//    }
//
//
//
//    public ConfiguredFeature<BaseTreeFeatureConfig, ?> setConfiguration() {
//        return this.withConfiguration(
//                new BaseTreeFeatureConfig.Builder (
//                        new SimpleBlockStateProvider(ModBlocks.REDWOOD_LOG.get().getDefaultState()),
//                        new SimpleBlockStateProvider(ModBlocks.REDWOOD_LEAVES.get().getDefaultState()),
//                        new MegaPineFoliagePlacer(FeatureSpread.func_242252_a(4),
//                                FeatureSpread.func_242252_a(7), FeatureSpread.func_242252_a(22)),
//                        new GiantTrunkPlacer(30, 40, 25),
//                        new TwoLayerFeature(1, 0, 1)).build());
//
//    }


    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> REDWOOD_FOREST =
            Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, "forest_redwood",
                    Feature.TREE.withConfiguration
            (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.REDWOOD_LOG.get().getDefaultState()),
                    new SimpleBlockStateProvider(ModBlocks.REDWOOD_LEAVES.get().getDefaultState()),
                    new BlobFoliagePlacer(FeatureSpread.func_242252_a(5), FeatureSpread.func_242252_a(7), 17),
            new GiantTrunkPlacer(30, 40, 25),
            new TwoLayerFeature(1, 0, 1)).setIgnoreVines().build()));


    public static final ConfiguredFeature<?, ?> OIL_LAKE =
            Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, "lake_oil",
                    Feature.LAKE.withConfiguration(new BlockStateFeatureConfig(ModFluids.OIL_BLOCK.get().getDefaultState()))
                            .withPlacement(Placement.WATER_LAKE.configure(new ChanceConfig(10))));
    public static final ConfiguredFeature<?, ?> DIRT_LAKE =
            Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, "lake_dirt",
                    Feature.LAKE.withConfiguration(new BlockStateFeatureConfig(Blocks.DIRT.getDefaultState()))
                            .withPlacement(Placement.WATER_LAKE.configure(new ChanceConfig(10))));


    private static final BlockClusterFeatureConfig ROCK_SPREAD_CONFIG =
            (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.ORANGE_TERRACOTTA.getDefaultState()),
                    new SimpleBlockPlacer())).tries(10).build();

    public static final ConfiguredFeature<?, ?> ROCK_SPREAD =
            Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, "rock_spread",
                    Feature.RANDOM_PATCH.withConfiguration(ROCK_SPREAD_CONFIG)
            .withPlacement(Placement.CHANCE.configure(new ChanceConfig(50))));



}





