package net.mcreator.lord_of_the_rings_mod;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;

@Elementslord_of_the_rings_mod.ModElement.Tag
public class MCreatorFoodLion extends Elementslord_of_the_rings_mod.ModElement {
	@ObjectHolder("lord_of_the_rings_mod:foodlion")
	public static final Item block = null;

	public MCreatorFoodLion(Elementslord_of_the_rings_mod instance) {
		super(instance, 54);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(MCreatorLOTRFoodAndDrinkTab.tab).maxStackSize(64)
					.food((new Food.Builder()).hunger(3).saturation(0.1f).meat().build()));
			setRegistryName("foodlion");
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.EAT;
		}
	}
}