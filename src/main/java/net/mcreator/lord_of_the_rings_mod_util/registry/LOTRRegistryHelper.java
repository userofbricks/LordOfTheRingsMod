package net.mcreator.lord_of_the_rings_mod_util.registry;

import net.minecraftforge.fml.RegistryObject;

import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.block.Block;
import net.mcreator.lord_of_the_rings_mod.itemgroup.LOTRFoodAndDrinkTabItemGroup;
import net.mcreator.lord_of_the_rings_mod_util.bases.BasePlaceableDrinkItem;

import java.util.function.Supplier;

import com.teamabnormals.abnormals_core.core.utils.RegistryHelper;

public class LOTRRegistryHelper extends RegistryHelper {
	public LOTRRegistryHelper(String modId) {
		super(modId);
	}

	public <B extends Block> RegistryObject<B> createDrinkBlock(String name, Supplier<? extends B> supplier, Food food, int damage, boolean isMilk,
			Block turnsInto) {
		RegistryObject<B> block = this.getDeferredBlockRegister().register(name, supplier);
		this.getDeferredItemRegister().register(name, () -> new BasePlaceableDrinkItem(block.get(),
				new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(food), damage, isMilk, Item.getItemFromBlock(turnsInto)));
		return block;
	}
}
