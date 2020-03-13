package net.mcreator.lord_of_the_rings_mod;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.block.Blocks;

@Elementslord_of_the_rings_mod.ModElement.Tag
public class MCreatorLOTRUtilitiesTab extends Elementslord_of_the_rings_mod.ModElement {
	public MCreatorLOTRUtilitiesTab(Elementslord_of_the_rings_mod instance) {
		super(instance, 85);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tablotrutilitiestab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Blocks.BLAST_FURNACE, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
