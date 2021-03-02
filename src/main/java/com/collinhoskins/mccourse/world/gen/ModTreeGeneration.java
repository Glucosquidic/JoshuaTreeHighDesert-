package com.collinhoskins.mccourse.world.gen;

import com.collinhoskins.mccourse.MCCourseMod;
import com.collinhoskins.mccourse.block.BaobabTree;
import com.collinhoskins.mccourse.block.JoshuaTree;
import com.collinhoskins.mccourse.block.RedwoodTree;
//import com.collinhoskins.mccourse.world.biome.ModBiomes;
import com.collinhoskins.mccourse.world.biome.ModBiomes;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.NoPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = MCCourseMod.MOD_ID)
public class ModTreeGeneration {
    @SubscribeEvent
    public static void onBiomeLoad(BiomeLoadingEvent event) {
        RegistryKey<Biome> key = RegistryKey.getOrCreateKey(Registry.BIOME_KEY,
                event.getName());
        Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);

//        if (types.contains(BiomeDictionary.Type.SAVANNA)) {
//            List<Supplier<ConfiguredFeature<?, ?>>> base =
//                    event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION);
//
//            base.add(() -> Feature.TREE.withConfiguration(RedwoodTree.REDWOOD_TREE_CONFIG)
//                    .withPlacement(Placement.DARK_OAK_TREE.configure((NoPlacementConfig.INSTANCE))));
//        }
        if (types.contains(BiomeDictionary.Type.WET) && (types.contains(BiomeDictionary.Type.COLD)) &&
                (types.contains(BiomeDictionary.Type.FOREST))) {
            List<Supplier<ConfiguredFeature<?, ?>>> base =
                    event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION);

            base.add(() -> Feature.TREE.withConfiguration(RedwoodTree.REDWOOD_TREE_CONFIG)
                    .withPlacement(Placement.DARK_OAK_TREE.configure((NoPlacementConfig.INSTANCE))));
        }
//
        if (types.contains(BiomeDictionary.Type.DRY) && (types.contains(BiomeDictionary.Type.HOT)) &&
                (types.contains(BiomeDictionary.Type.DEAD))) {
            List<Supplier<ConfiguredFeature<?, ?>>> base =
                    event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION);
            base.add(() -> Feature.TREE.withConfiguration(JoshuaTree.JOSHUA_TREE_CONFIG)
                    .withPlacement(Placement.DARK_OAK_TREE.configure(NoPlacementConfig.INSTANCE)));
        }


        if (types.contains(BiomeDictionary.Type.SWAMP)) {
            List<Supplier<ConfiguredFeature<?, ?>>> base =
                    event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION);

            base.add(() -> Feature.TREE.withConfiguration(BaobabTree.BAOBAB_TREE_CONFIG)
                    .withPlacement(Placement.SPREAD_32_ABOVE.configure((NoPlacementConfig.INSTANCE))));
        }


    }
}