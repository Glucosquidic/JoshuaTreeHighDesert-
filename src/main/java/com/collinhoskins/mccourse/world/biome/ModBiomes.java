package com.collinhoskins.mccourse.world.biome;

import com.collinhoskins.mccourse.world.biome.ModConfiguredSurfaceBuilders;
import com.collinhoskins.mccourse.world.feature.RedwoodTreeFeature;
import com.collinhoskins.mccourse.util.Registration;
import com.collinhoskins.mccourse.world.feature.RedwoodTreeFeature;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilders;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModBiomes
{
    public static final RegistryObject<Biome> OIL_BIOME =
            Registration.BIOMES.register("oil_biome",
                    () -> makeOilBiome(() -> WorldGenRegistries.CONFIGURED_SURFACE_BUILDER.getOrThrow(
                            ModConfiguredSurfaceBuilders.OIL_SURFACE), 0.125f, 0.05f));

    public static void register() { }

    private static Biome makeOilBiome(final Supplier<ConfiguredSurfaceBuilder<?>> surfaceBuilder, float depth, float scale)
    {
        MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
        DefaultBiomeFeatures.withPassiveMobs(mobspawninfo$builder);
        DefaultBiomeFeatures.withBatsAndHostiles(mobspawninfo$builder);
        mobspawninfo$builder.withSpawner(EntityClassification.MONSTER,
                new MobSpawnInfo.Spawners(EntityType.SLIME, 1, 1, 1));

        BiomeGenerationSettings.Builder biomegenerationsettings$builder =
                (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(surfaceBuilder);

        biomegenerationsettings$builder.withStructure(StructureFeatures.MINESHAFT);
        biomegenerationsettings$builder.withStructure(StructureFeatures.RUINED_PORTAL_SWAMP);
        DefaultBiomeFeatures.withCavesAndCanyons(biomegenerationsettings$builder);

        DefaultBiomeFeatures.withLavaAndWaterLakes(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withMonsterRoom(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withCommonOverworldBlocks(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withOverworldOres(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withClayDisks(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withNormalMushroomGeneration(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withSwampSugarcaneAndPumpkin(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withLavaAndWaterSprings(biomegenerationsettings$builder);
        biomegenerationsettings$builder.withStructure(StructureFeatures.VILLAGE_TAIGA);
        biomegenerationsettings$builder.withStructure(StructureFeatures.PILLAGER_OUTPOST);
        biomegenerationsettings$builder.withStructure(StructureFeatures.VILLAGE_PLAINS);
        biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_LARGE_FERN);
        biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_GRASS_TAIGA);
        biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.LAKES, RedwoodTreeFeature.OIL_LAKE);
//        biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.RAW_GENERATION, RedwoodTreeFeature.REDWOOD_FOREST);

        DefaultBiomeFeatures.withFrozenTopLayer(biomegenerationsettings$builder);
        return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).category(Biome.Category.SWAMP)
                .depth(depth).scale(scale).temperature(0.8F).downfall(0.9F)
                .setEffects((new BiomeAmbience.Builder()).setWaterColor(6388580)
                        .setWaterFogColor(34343).setFogColor(12638463)
                        .withSkyColor(getSkyColorWithTemperatureModifier(0.8F))
                        .withFoliageColor(6975545).withGrassColorModifier(BiomeAmbience.GrassColorModifier.SWAMP)
                        .setMoodSound(MoodSoundAmbience.DEFAULT_CAVE).build())
                .withMobSpawnSettings(mobspawninfo$builder.copy())
                .withGenerationSettings(biomegenerationsettings$builder.build()).build();

    }

    private static int getSkyColorWithTemperatureModifier(float temperature) {
        float lvt_1_1_ = temperature / 3.0F;
        lvt_1_1_ = MathHelper.clamp(lvt_1_1_, -1.0F, 1.0F);
        return MathHelper.hsvToRGB(0.62222224F - lvt_1_1_ * 0.05F, 0.5F + lvt_1_1_ * 0.1F, 1.0F);

    }
    public static final RegistryObject<Biome> JENNA_BIOME =
            Registration.BIOMES.register("jenna_biome",
                    () -> makeJennaBiome(() -> WorldGenRegistries.CONFIGURED_SURFACE_BUILDER.getOrThrow(
                            ModConfiguredSurfaceBuilders.JENNA_SURFACE), 5.3f, 0.1f));


    private static Biome makeJennaBiome(final Supplier<ConfiguredSurfaceBuilder<?>> surfaceBuilder, float depth, float scale) {
        MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
        DefaultBiomeFeatures.withBatsAndHostiles(mobspawninfo$builder);
        BiomeGenerationSettings.Builder biomegenerationsettings$builder = (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(surfaceBuilder);
        DefaultBiomeFeatures.withBadlandsStructures(biomegenerationsettings$builder);
        biomegenerationsettings$builder.withStructure(StructureFeatures.RUINED_PORTAL_MOUNTAIN);
        DefaultBiomeFeatures.withLavaAndWaterLakes(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withMonsterRoom(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withCommonOverworldBlocks(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withOverworldOres(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withExtraGoldOre(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withDisks(biomegenerationsettings$builder);
        biomegenerationsettings$builder.withStructure(StructureFeatures.VILLAGE_SAVANNA);
        biomegenerationsettings$builder.withStructure(StructureFeatures.VILLAGE_DESERT);
        biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_GRASS_BADLANDS);
        biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_GRASS_SAVANNA);

        // Custom

        biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.LAKES, RedwoodTreeFeature.DIRT_LAKE);

        DefaultBiomeFeatures.withBadlandsGrassAndBush(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withNormalMushroomGeneration(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withBadlandsVegetation(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withLavaAndWaterSprings(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withFrozenTopLayer(biomegenerationsettings$builder);
        return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).category(Biome.Category.EXTREME_HILLS)
                .depth(depth).scale(scale).temperature(2.0F)
                .downfall(0.5F)
                .setEffects((new BiomeAmbience.Builder())
                        .setWaterColor(4159204).setWaterFogColor(329011)
                        .setFogColor(12638463).withSkyColor(getSkyColorWithTemperatureModifier(2.0F))
                        .setMoodSound(MoodSoundAmbience.DEFAULT_CAVE).build())
                .withMobSpawnSettings(mobspawninfo$builder.copy())
                .withGenerationSettings(biomegenerationsettings$builder.build()).build();

    }
}

