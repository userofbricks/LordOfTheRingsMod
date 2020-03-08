package net.mcreator.lord_of_the_rings_mod;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import java.util.List;
import java.util.Collections;

import net.mcreator.lord_of_the_rings_mod.ItemBase.PlaceableFoodItem;
import net.mcreator.lord_of_the_rings_mod.blockBase.CustomCakeBlock;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.Food.Builder;
import net.minecraft.item.Food;

@Elementslord_of_the_rings_mod.ModElement.Tag
public class MCreatorFoodKebabBlock extends Elementslord_of_the_rings_mod.ModElement {
	@ObjectHolder("lord_of_the_rings_mod:foodkebabblock")
	public static final Block block = null;

	public MCreatorFoodKebabBlock(Elementslord_of_the_rings_mod instance) {
		super(instance, 18);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new PlaceableFoodItem(block, new Item.Properties().group(MCreatorLOTRFoodAndDrinkTab.tab)
				.food((new Food.Builder()).hunger(7).saturation(0.7f).build()), 0.0F, false)
				.setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends CustomCakeBlock {
		public CustomBlock() {
			super(Block.Properties.create(Material.CAKE).sound(SoundType.SNOW).hardnessAndResistance(0.5f, 1f).lightValue(0), 1, 0.1F);
			setRegistryName("foodkebabblock");
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
