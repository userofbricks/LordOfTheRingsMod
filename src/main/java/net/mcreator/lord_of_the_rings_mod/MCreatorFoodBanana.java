package net.mcreator.lord_of_the_rings_mod;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.lord_of_the_rings_mod.ItemBase.PlaceableFoodItem;

import java.util.List;
import java.util.Collections;

@Elementslord_of_the_rings_mod.ModElement.Tag
public class MCreatorFoodBanana extends Elementslord_of_the_rings_mod.ModElement {
	@ObjectHolder("lord_of_the_rings_mod:foodbanana")
	public static final Block block = null;

	public MCreatorFoodBanana(Elementslord_of_the_rings_mod instance) {
		super(instance, 13);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new PlaceableFoodItem(block, new Item.Properties().group(MCreatorLOTRFoodAndDrinkTab.tab).food(
				(new Food.Builder()).hunger(4).saturation(0.3f).build()), 0.0F, false).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.CAKE).sound(SoundType.SNOW).hardnessAndResistance(0.5f, 1f).lightValue(0));
			setRegistryName("foodbanana");
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
