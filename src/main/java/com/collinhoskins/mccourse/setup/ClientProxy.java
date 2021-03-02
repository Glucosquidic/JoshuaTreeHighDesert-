package com.collinhoskins.mccourse.setup;

import com.collinhoskins.mccourse.MCCourseMod;
import com.collinhoskins.mccourse.block.ModBlocks;
//import com.collinhoskins.mccourse.container.ModContainers;
//import com.collinhoskins.mccourse.screens.ElectrifierScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MCCourseMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientProxy implements IProxy
{
    @Override
    public void init()
    {
//        RenderTypeLookup.setRenderLayer(ModBlocks.ZUCCINI_CROP.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.REDWOOD_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.BAOBAB_SAPLING.get(), RenderType.getCutout());

//

    }

    @Override
    public World getClientWorld()
    {
        return Minecraft.getInstance().world;
    }
}
