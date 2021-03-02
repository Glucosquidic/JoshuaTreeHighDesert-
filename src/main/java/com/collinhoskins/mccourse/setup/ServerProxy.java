package com.collinhoskins.mccourse.setup;

import com.collinhoskins.mccourse.MCCourseMod;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MCCourseMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.DEDICATED_SERVER)
public class ServerProxy implements IProxy
{
    @Override
    public void init()
    {

    }

    @Override
    public World getClientWorld()
    {
        throw new IllegalStateException("Cannot be run on Server!");
    }
}
