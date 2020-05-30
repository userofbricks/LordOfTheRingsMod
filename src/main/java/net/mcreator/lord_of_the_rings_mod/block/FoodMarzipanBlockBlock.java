
package net.mcreator.lord_of_the_rings_mod.block;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.lord_of_the_rings_mod_util.bases.BaseCakeBlock;
import net.mcreator.lord_of_the_rings_mod.itemgroup.LOTRFoodAndDrinkTabItemGroup;
import net.mcreator.lord_of_the_rings_mod.LordOfTheRingsModModElements;

import java.util.List;
import java.util.Collections;

@LordOfTheRingsModModElements.ModElement.Tag
public class FoodMarzipanBlockBlock extends LordOfTheRingsModModElements.ModElement {
	@ObjectHolder("lord_of_the_rings_mod:foodmarzipanblock")
	public static final Block block = null;
	public FoodMarzipanBlockBlock(LordOfTheRingsModModElements instance) {
		super(instance, 9);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block,
				new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food((new Food.Builder()).hunger(7).saturation(0.7f).build()))
						.setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends BaseCakeBlock {
		protected static final VoxelShape[] SHAPESA = new VoxelShape[]{Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 6.0D, 15.0D),
				Block.makeCuboidShape(3.0D, 0.0D, 1.0D, 15.0D, 6.0D, 15.0D), Block.makeCuboidShape(5.0D, 0.0D, 1.0D, 15.0D, 6.0D, 15.0D),
				Block.makeCuboidShape(7.0D, 0.0D, 1.0D, 15.0D, 6.0D, 15.0D), Block.makeCuboidShape(9.0D, 0.0D, 1.0D, 15.0D, 6.0D, 15.0D),
				Block.makeCuboidShape(11.0D, 0.0D, 1.0D, 15.0D, 6.0D, 15.0D), Block.makeCuboidShape(13.0D, 0.0D, 1.0D, 15.0D, 6.0D, 15.0D)};
		public CustomBlock() {
			super(Block.Properties.create(Material.CAKE).sound(SoundType.CLOTH).hardnessAndResistance(0.5f, 1f).lightValue(0), 1, 0.1F);
			setRegistryName("foodmarzipanblock");
		}

		@Override
		public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
			return SHAPESA[state.get(BITES)];
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
