package net.mcreator.lord_of_the_rings_mod;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@Elementslord_of_the_rings_mod.ModElement.Tag
public class MCreatorLOTRMiscellaneousTab extends Elementslord_of_the_rings_mod.ModElement {
	public MCreatorLOTRMiscellaneousTab(Elementslord_of_the_rings_mod instance) {
		super(instance, 62);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tablotrmiscellaneoustab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Items.BUCKET, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
