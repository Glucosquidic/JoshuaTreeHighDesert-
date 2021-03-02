package com.collinhoskins.mccourse;

import com.collinhoskins.mccourse.block.ModBlocks;
//import com.collinhoskins.mccourse.block.ModFluids;
//import com.collinhoskins.mccourse.container.ModContainers;
//import com.collinhoskins.mccourse.entity.BuffaloEntity;
import com.collinhoskins.mccourse.block.ModFluids;
import com.collinhoskins.mccourse.events.ModEvents;
import com.collinhoskins.mccourse.item.ModItems;
import com.collinhoskins.mccourse.setup.ClientProxy;
import com.collinhoskins.mccourse.setup.IProxy;
import com.collinhoskins.mccourse.setup.ServerProxy;
//import com.collinhoskins.mccourse.tileentity.ModTileEntities;
import com.collinhoskins.mccourse.util.Config;
import com.collinhoskins.mccourse.util.Registration;
import com.collinhoskins.mccourse.world.biome.ModBiomes;
import com.collinhoskins.mccourse.world.biome.ModSurfaceBuilders;
import com.collinhoskins.mccourse.world.feature.RedwoodTreeFeature;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.*;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MCCourseMod.MOD_ID)
public class MCCourseMod
{
    public static final String MOD_ID = "mccourse";

    public static final ItemGroup COURSE_TAB = new ItemGroup("courseTab")
    {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(ModItems.DRAGON_INGOT.get());
        }
    };

    public static IProxy proxy;

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public MCCourseMod()
    {


        proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> ServerProxy::new);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        registerModAdditions();

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
      registerConfigs();

      proxy.init();

      loadConfigs();





    }

    private void registerConfigs()
    {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT_CONFIG);
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.SERVER_CONFIG);
    }

    private void loadConfigs()
    {
        Config.loadConfigFile(Config.CLIENT_CONFIG, FMLPaths.CONFIGDIR.get().resolve("mccourse-client.toml").toString());
        Config.loadConfigFile(Config.SERVER_CONFIG, FMLPaths.CONFIGDIR.get().resolve("mccourse-server.toml").toString());
    }

    private void registerModAdditions()
    {
        // Inits the registration of our additions
        Registration.init();

        // registers items, blocks etc added by our mod
        ModItems.register();
        ModBlocks.register();
        ModFluids.register();
//        ModTileEntities.register();
//        ModContainers.register();
//        ModEntityTypes.register();
        ModSurfaceBuilders.register();
        ModBiomes.register();
        ModSurfaceBuilders.register();

        // register mod events
        MinecraftForge.EVENT_BUS.register(new ModEvents());
    }

}
