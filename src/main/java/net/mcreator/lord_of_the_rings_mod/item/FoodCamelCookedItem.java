
package net.mcreator.lord_of_the_rings_mod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;

import net.mcreator.lord_of_the_rings_mod.itemgroup.LOTRFoodAndDrinkTabItemGroup;
import net.mcreator.lord_of_the_rings_mod.LordOfTheRingsModElements;

@LordOfTheRingsModElements.ModElement.Tag
public class FoodCamelCookedItem extends LordOfTheRingsModElements.ModElement {
	@ObjectHolder("lord_of_the_rings_mod:foodcamelcooked")
	public static final Item block = null;
	public FoodCamelCookedItem(LordOfTheRingsModElements instance) {
		super(instance, 66);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).maxStackSize(64)
					.food((new Food.Builder()).hunger(8).saturation(0.7f).meat().build()));
			setRegistryName("foodcamelcooked");
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.EAT;
		}
	}
}
