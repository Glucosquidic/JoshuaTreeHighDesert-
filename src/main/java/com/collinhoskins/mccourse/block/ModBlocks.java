package com.collinhoskins.mccourse.block;

import com.collinhoskins.mccourse.util.Registration;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final RegistryObject<Block> ZION_BLOCK = register("zion_block",
                        () -> new Block(AbstractBlock.Properties.create(Material.IRON)
                                .hardnessAndResistance(3f, 10f).sound(SoundType.METAL)));


    public static final RegistryObject<Block> ZION_ORE = register("zion_ore",
                        () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                                    .hardnessAndResistance(3f, 10f)
                                    .harvestLevel(2).harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> JENNA_BLOCK = register("jenna_block",
                        () -> new Block(AbstractBlock.Properties.create(Material.GLASS)
                                        .hardnessAndResistance(10f, 10f)
                                        .harvestTool(ToolType.AXE).sound(SoundType.GLASS)));

    public static final RegistryObject<Block> DRAGONITE = register("dragonite",
                        () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                                        .hardnessAndResistance(25f, 30f)
                                        .harvestLevel(3).harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));

    // Tree Stuff

    // Redwood

    public static final RegistryObject<Block> REDWOOD_PLANKS = register("redwood_planks",
            () -> new Block(AbstractBlock.Properties.from(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> REDWOOD_LOG = register("redwood_log",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.from(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> REDWOOD_LEAVES = register("redwood_leaves",
            () -> new LeavesBlock(AbstractBlock.Properties.from(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> REDWOOD_SAPLING = register("redwood_sapling",
            () -> new RedwoodSapling(
                    () -> new RedwoodTree(), AbstractBlock.Properties.from(Blocks.OAK_SAPLING)));

    //Baobab

    public static final RegistryObject<Block> BAOBAB_PLANKS = register("baobab_planks",
            () -> new Block(AbstractBlock.Properties.from(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> BAOBAB_LOG = register("baobab_log",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.from(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> BAOBAB_LEAVES = register("baobab_leaves",
            () -> new LeavesBlock(AbstractBlock.Properties.from(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> BAOBAB_SAPLING = register("baobab_sapling",
            () -> new BaobabSapling(
                    () -> new BaobabTree(), AbstractBlock.Properties.from(Blocks.OAK_SAPLING)));

    // Joshua Tree

    public static final RegistryObject<Block> JOSHUATREE_PLANKS = register("joshuatree_planks",
            () -> new Block(AbstractBlock.Properties.from(Blocks.ACACIA_PLANKS)));
    public static final RegistryObject<Block> JOSHUATREE_LOG = register("joshuatree_log",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.from(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> JOSHUATREE_LEAVES = register("joshuatree_leaves",
            () -> new LeavesBlock(AbstractBlock.Properties.from(Blocks.ACACIA_LEAVES)));
    public static final RegistryObject<Block> JOSHUATREE_SAPLING = register("joshuatree_sapling",
            () -> new JoshuaTreeSapling(
                    () -> new JoshuaTree(), AbstractBlock.Properties.from(Blocks.OAK_SAPLING)));



    public static void register() { }

        private static <T extends Block>RegistryObject<T> register(String name, Supplier<T> block)
        {
          RegistryObject<T> toReturn = Registration.BLOCKS.register(name, block);
          Registration.ITEMS.register(name, () -> new BlockItem(toReturn.get(),
                  new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
          return toReturn;
        }
}
