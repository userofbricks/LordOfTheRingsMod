package net.mcreator.lord_of_the_rings_mod_util.event;

import net.mcreator.lord_of_the_rings_mod.LordOfTheRingsModMod;
import net.mcreator.lord_of_the_rings_mod.item.PouchSmallItem;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.item.IDyeableArmorItem;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = LordOfTheRingsModMod.MOD_ID, bus = Bus.FORGE)
public class DyePouchEvent {
	@SubscribeEvent
	public void DyePouch(ColorHandlerEvent.Item event) {
		ItemColors itemcolors = event.getItemColors();
		
		itemcolors.register((p_210239_0_, p_210239_1_) -> {
	         return p_210239_1_ > 0 ? -1 : ((IDyeableArmorItem)p_210239_0_.getItem()).getColor(p_210239_0_);
	      }, PouchSmallItem.block);
	}
}
