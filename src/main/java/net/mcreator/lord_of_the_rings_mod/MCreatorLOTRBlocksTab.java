package net.mcreator.lord_of_the_rings_mod;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.block.Blocks;

@Elementslord_of_the_rings_mod.ModElement.Tag
public class MCreatorLOTRBlocksTab extends Elementslord_of_the_rings_mod.ModElement {
	public MCreatorLOTRBlocksTab(Elementslord_of_the_rings_mod instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tablotrblockstab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Blocks.GRASS_BLOCK, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
