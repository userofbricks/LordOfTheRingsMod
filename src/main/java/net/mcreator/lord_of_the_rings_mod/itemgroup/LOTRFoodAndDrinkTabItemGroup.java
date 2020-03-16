
package net.mcreator.lord_of_the_rings_mod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.lord_of_the_rings_mod.LordOfTheRingsModElements;

@LordOfTheRingsModElements.ModElement.Tag
public class LOTRFoodAndDrinkTabItemGroup extends LordOfTheRingsModElements.ModElement {
	public LOTRFoodAndDrinkTabItemGroup(LordOfTheRingsModElements instance) {
		super(instance, 79);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tablotrfoodanddrinktab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Items.BREAD, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
