
package net.mcreator.lord_of_the_rings_mod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.block.Blocks;

import net.mcreator.lord_of_the_rings_mod.LordOfTheRingsModElements;

@LordOfTheRingsModElements.ModElement.Tag
public class LOTRSpawningTabItemGroup extends LordOfTheRingsModElements.ModElement {
	public LOTRSpawningTabItemGroup(LordOfTheRingsModElements instance) {
		super(instance, 82);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tablotrspawningtab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Blocks.SPAWNER, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
