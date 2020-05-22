
package net.mcreator.lord_of_the_rings_mod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.lord_of_the_rings_mod.LordOfTheRingsModModElements;

@LordOfTheRingsModModElements.ModElement.Tag
public class LOTRStoryTabItemGroup extends LordOfTheRingsModModElements.ModElement {
	public LOTRStoryTabItemGroup(LordOfTheRingsModModElements instance) {
		super(instance, 83);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tablotrstorytab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Items.WRITTEN_BOOK, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
