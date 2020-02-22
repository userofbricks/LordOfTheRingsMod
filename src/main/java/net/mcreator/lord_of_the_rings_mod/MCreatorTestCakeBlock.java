package net.mcreator.lord_of_the_rings_mod;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;
import net.minecraft.item.Food.Builder;
import net.minecraft.item.Food;

import java.util.List;
import java.util.Collections;

import net.mcreator.lord_of_the_rings_mod.ItemBase.PlaceableFoodItem;
import net.mcreator.lord_of_the_rings_mod.blockBase.CustomCakeBlock;

@Elementslord_of_the_rings_mod.ModElement.Tag
public class MCreatorTestCakeBlock extends Elementslord_of_the_rings_mod.ModElement {
	@ObjectHolder("lord_of_the_rings_mod:testcakeblock")
	public static final Block block = null;

	public MCreatorTestCakeBlock(Elementslord_of_the_rings_mod instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new PlaceableFoodItem(block, new Item.Properties().group(ItemGroup.FOOD)
						.food((new Food.Builder()).hunger(7).saturation(0.7f).build()), 0.0F, false).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends CustomCakeBlock {
		public CustomBlock() {
			super(Block.Properties.create(Material.CAKE).sound(SoundType.SNOW).hardnessAndResistance(1f, 1f).lightValue(0), 1, 0.1F);
			setRegistryName("testcakeblock");
		}

		@Override
		public MaterialColor getMaterialColor(BlockState state, IBlockReader blockAccess, BlockPos pos) {
			return MaterialColor.WHITE_TERRACOTTA;
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
