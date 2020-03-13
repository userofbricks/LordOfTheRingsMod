package net.mcreator.lord_of_the_rings_mod;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@Elementslord_of_the_rings_mod.ModElement.Tag
public class MCreatorLOTRStoryTab extends Elementslord_of_the_rings_mod.ModElement {
	public MCreatorLOTRStoryTab(Elementslord_of_the_rings_mod instance) {
		super(instance, 79);
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
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
