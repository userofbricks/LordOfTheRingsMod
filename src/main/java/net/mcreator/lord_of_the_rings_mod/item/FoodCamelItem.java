
package net.mcreator.lord_of_the_rings_mod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;

import net.mcreator.lord_of_the_rings_mod.itemgroup.LOTRFoodAndDrinkTabItemGroup;
import net.mcreator.lord_of_the_rings_mod.LordOfTheRingsModElements;

@LordOfTheRingsModElements.ModElement.Tag
public class FoodCamelItem extends LordOfTheRingsModElements.ModElement {
	@ObjectHolder("lord_of_the_rings_mod:foodcamel")
	public static final Item block = null;
	public FoodCamelItem(LordOfTheRingsModElements instance) {
		super(instance, 65);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).maxStackSize(64)
					.food((new Food.Builder()).hunger(3).saturation(0.1f).meat().build()));
			setRegistryName("foodcamel");
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.EAT;
		}
	}
}
