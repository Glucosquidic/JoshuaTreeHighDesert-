package com.collinhoskins.mccourse.block;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.AcaciaFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.MegaPineFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.PineFoliagePlacer;
import net.minecraft.world.gen.trunkplacer.DarkOakTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.GiantTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

import javax.annotation.Nullable;
import java.util.Random;

public class RedwoodTree extends Tree
{
    private static final int BASE_HEIGHT = 30;
    private static final int FIRST_RANDOM_HEIGHT = 20 ;
    private static final int SECOND_RANDOM_HEIGHT = 40;

    private static final int LEAVE_RADIUS = 4;
    private static final int LEAVE_OFFSET = 7;
    private static final int LEAVE_HEIGHT = 25;


    public static final BaseTreeFeatureConfig REDWOOD_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(ModBlocks.REDWOOD_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(ModBlocks.REDWOOD_LEAVES.get().getDefaultState()),
            new MegaPineFoliagePlacer(FeatureSpread.func_242252_a(LEAVE_RADIUS),
                    FeatureSpread.func_242252_a(LEAVE_OFFSET), FeatureSpread.func_242252_a(LEAVE_HEIGHT)),
            new GiantTrunkPlacer(BASE_HEIGHT, FIRST_RANDOM_HEIGHT, SECOND_RANDOM_HEIGHT),
            new TwoLayerFeature(1, 0, 1)
    )).build();

    @Nullable
    @Override
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean largeHive)
    {
        return Feature.TREE.withConfiguration(REDWOOD_TREE_CONFIG);
    }
}