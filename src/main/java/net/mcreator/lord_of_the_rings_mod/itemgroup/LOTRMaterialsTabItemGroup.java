
package net.mcreator.lord_of_the_rings_mod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.block.Blocks;

import net.mcreator.lord_of_the_rings_mod.LordOfTheRingsModElements;

@LordOfTheRingsModElements.ModElement.Tag
public class LOTRMaterialsTabItemGroup extends LordOfTheRingsModElements.ModElement {
	public LOTRMaterialsTabItemGroup(LordOfTheRingsModElements instance) {
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
