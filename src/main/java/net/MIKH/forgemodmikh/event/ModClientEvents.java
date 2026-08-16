package net.MIKH.forgemodmikh.event;

import net.MIKH.forgemodmikh.ForgeModMIKH;
import net.MIKH.forgemodmikh.item.ModItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ComputeFovModifierEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ForgeModMIKH.MOD_ID,bus = Mod.EventBusSubscriber.Bus.FORGE,value = Dist.CLIENT)
public class ModClientEvents {
    @SubscribeEvent
    public static void onComputerFovModifierEvent(ComputeFovModifierEvent event){
        if(event.getPlayer().isUsingItem() && event.getPlayer().getUseItem().getItem() == ModItem.PHOENIX_BOW.get()){
            float fovModifier = 1f;
            int tickUsingItem = event.getPlayer().getTicksUsingItem();
            float deltaTick = (float)tickUsingItem/20f;
            if(deltaTick > 1){
                deltaTick = 1f;
            } else{
                deltaTick *= deltaTick;
            }
            fovModifier *= 1f - deltaTick * 0.15f;
            event.setNewFovModifier(fovModifier);
        }
    }
}
