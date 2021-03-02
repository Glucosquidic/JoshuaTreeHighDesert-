package com.collinhoskins.mccourse.block;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.AcaciaFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.MegaPineFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.PineFoliagePlacer;
import net.minecraft.world.gen.trunkplacer.DarkOakTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.ForkyTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.GiantTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

import javax.annotation.Nullable;
import java.util.Random;

public class BaobabTree extends Tree
{
    private static final int BASE_HEIGHT = 6;
    private static final int FIRST_RANDOM_HEIGHT = 5 ;
    private static final int SECOND_RANDOM_HEIGHT = 7;

    private static final int LEAVE_RADIUS = 3;
    private static final int LEAVE_OFFSET = 3;
    private static final int LEAVE_HEIGHT = 3;


    public static final BaseTreeFeatureConfig BAOBAB_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(ModBlocks.BAOBAB_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(ModBlocks.BAOBAB_LEAVES.get().getDefaultState()),
            new BlobFoliagePlacer(FeatureSpread.func_242252_a(LEAVE_RADIUS), FeatureSpread.func_242252_a(LEAVE_OFFSET), LEAVE_HEIGHT),
            new ForkyTrunkPlacer(BASE_HEIGHT, FIRST_RANDOM_HEIGHT, SECOND_RANDOM_HEIGHT),
            new TwoLayerFeature(1, 0, 1)
    )).build();

    @Nullable
    @Override
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean largeHive)
    {
        return Feature.TREE.withConfiguration(BAOBAB_TREE_CONFIG);
    }
}