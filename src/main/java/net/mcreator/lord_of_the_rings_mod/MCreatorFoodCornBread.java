package net.mcreator.lord_of_the_rings_mod;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;

@Elementslord_of_the_rings_mod.ModElement.Tag
public class MCreatorFoodCornBread extends Elementslord_of_the_rings_mod.ModElement {
	@ObjectHolder("lord_of_the_rings_mod:foodcornbread")
	public static final Item block = null;

	public MCreatorFoodCornBread(Elementslord_of_the_rings_mod instance) {
		super(instance, 71);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(MCreatorLOTRFoodAndDrinkTab.tab).maxStackSize(64)
					.food((new Food.Builder()).hunger(6).saturation(0.6f).build()));
			setRegistryName("foodcornbread");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 48;
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.EAT;
		}
	}
}
