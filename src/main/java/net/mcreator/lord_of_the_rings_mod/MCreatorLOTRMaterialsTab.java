package net.mcreator.lord_of_the_rings_mod;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.block.Blocks;

@Elementslord_of_the_rings_mod.ModElement.Tag
public class MCreatorLOTRMaterialsTab extends Elementslord_of_the_rings_mod.ModElement {
	public MCreatorLOTRMaterialsTab(Elementslord_of_the_rings_mod instance) {
		super(instance, 80);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tablotrmaterialstab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Blocks.IRON_ORE, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
