package net.mcreator.lord_of_the_rings_mod.block;

import net.minecraftforge.common.property.Properties;

import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;

public class BasePlaceableDrinkItem extends BasePlaceableFoodItem {
	public BasePlaceableDrinkItem(Block blockIn, Properties properties, float damageIn, boolean milkIn) {
		super(blockIn, properties, damageIn, milkIn);
	}

	/*
	 * returns the action that specifies what animation to play when the items is
	 * being used
	 */
	@Override
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.DRINK;
	}
}
