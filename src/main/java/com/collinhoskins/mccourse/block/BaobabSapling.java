package com.collinhoskins.mccourse.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.block.trees.Tree;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.ForgeEventFactory;

import java.util.Random;
import java.util.function.Supplier;

public class BaobabSapling extends BushBlock implements IGrowable
{
    public static final IntegerProperty STAGE = BlockStateProperties.STAGE_0_1;
    private final Supplier<Tree> tree;
    public BaobabSapling(Supplier<Tree> treeIn, Properties properties) {
        super(properties);
        this.tree = treeIn;
    }

    @Override
    public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return (double)worldIn.rand.nextFloat() < 0.5;
    }

    @Override
    public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state)
    {
        if(state.get(STAGE) == 0)
        {
            worldIn.setBlockState(pos, state.func_235896_a_(STAGE), 4);
        }
        else
        {
            if(!ForgeEventFactory.saplingGrowTree(worldIn, rand, pos))
            {
                return;

            }
            this.tree.get().attemptGrowTree(worldIn, worldIn.getChunkProvider().getChunkGenerator(),
                    pos, state, rand);
        }
    }
}
