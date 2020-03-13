package net.mcreator.lord_of_the_rings_mod;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;

@Elementslord_of_the_rings_mod.ModElement.Tag
public class MCreatorFoodHobbitPancake extends Elementslord_of_the_rings_mod.ModElement {
	@ObjectHolder("lord_of_the_rings_mod:foodhobbitpancake")
	public static final Item block = null;

	public MCreatorFoodHobbitPancake(Elementslord_of_the_rings_mod instance) {
		super(instance, 35);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(MCreatorLOTRFoodAndDrinkTab.tab).maxStackSize(64)
					.food((new Food.Builder()).hunger(4).saturation(0.5f).build()));
			setRegistryName("foodhobbitpancake");
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.EAT;
		}
	}
}
