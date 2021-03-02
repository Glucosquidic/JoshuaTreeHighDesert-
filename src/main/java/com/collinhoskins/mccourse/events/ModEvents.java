package com.collinhoskins.mccourse.events;

import com.collinhoskins.mccourse.item.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.ZoglinEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ModEvents
{
    @SubscribeEvent
    public void onDragonSwordAttack(AttackEntityEvent event)
    {
        if(event.getPlayer().getHeldItemMainhand().getItem() == ModItems.DRAGON_SWORD.get())
        {
            if(event.getTarget().isAlive())
            {
                LivingEntity target = (LivingEntity)event.getTarget();
                if(target instanceof PigEntity)
                {
                    PlayerEntity player = event.getPlayer();
                    target.addPotionEffect(new EffectInstance(Effects.SPEED, 120, 6));
                    target.setHealth(1000f);
                    if(!player.world.isRemote())
                    {
                        String pigMsg = TextFormatting.BLUE + "You fool, you shouldn't attempt to kill with such a strong weapon!";
                        player.sendMessage(new StringTextComponent(pigMsg), player.getUniqueID());
                    }
                    }

            }
        }
    }
}
