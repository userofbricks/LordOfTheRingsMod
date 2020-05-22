
package net.mcreator.lord_of_the_rings_mod.block;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.lord_of_the_rings_mod_util.block.BaseCakeBlock;
import net.mcreator.lord_of_the_rings_mod.itemgroup.LOTRFoodAndDrinkTabItemGroup;
import net.mcreator.lord_of_the_rings_mod.LordOfTheRingsModModElements;

import java.util.List;
import java.util.Collections;

@LordOfTheRingsModModElements.ModElement.Tag
public class FoodCherryPieBlock extends LordOfTheRingsModModElements.ModElement {
	@ObjectHolder("lord_of_the_rings_mod:foodcherrypie")
	public static final Block block = null;
	public FoodCherryPieBlock(LordOfTheRingsModModElements instance) {
		super(instance, 5);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block,
				new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food((new Food.Builder()).hunger(7).saturation(0.7f).build()))
						.setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends BaseCakeBlock {
		public CustomBlock() {
			super(Block.Properties.create(Material.CAKE).sound(SoundType.CLOTH).hardnessAndResistance(0.5f, 1f).lightValue(0), 1, 0.1F);
			setRegistryName("foodcherrypie");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}
