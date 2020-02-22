package net.mcreator.lord_of_the_rings_mod.ItemBase;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;

public class PlaceableDrinkItem extends PlaceableFoodItem {

	public PlaceableDrinkItem(Block blockIn, Properties properties, float damageIn, boolean milkIn) {
		super(blockIn, properties, damageIn, milkIn);
	}
	
	/*
	 * returns the action that specifies what animation to play when the items is being used
	 */
	@Override
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.DRINK;
	}
}
