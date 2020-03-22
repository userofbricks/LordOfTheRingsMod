
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

import net.mcreator.lord_of_the_rings_mod.itemgroup.LOTRFoodAndDrinkTabItemGroup;
import net.mcreator.lord_of_the_rings_mod.LordOfTheRingsModElements;

import java.util.List;
import java.util.Collections;

@LordOfTheRingsModElements.ModElement.Tag
public class FoodDalishPastryBlock extends LordOfTheRingsModElements.ModElement {
	@ObjectHolder("lord_of_the_rings_mod:fooddalishpastry")
	public static final Block block = null;
	public FoodDalishPastryBlock(LordOfTheRingsModElements instance) {
		super(instance, 6);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block,
				new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food((new Food.Builder()).hunger(7).saturation(0.7f).build()))
						.setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends BaseCakeBlock {
		protected static final VoxelShape[] SHAPESA = new VoxelShape[]{Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 6.0D, 13.0D),
				Block.makeCuboidShape(4.0D, 0.0D, 3.0D, 13.0D, 6.0D, 13.0D), Block.makeCuboidShape(6.0D, 0.0D, 3.0D, 13.0D, 6.0D, 13.0D),
				Block.makeCuboidShape(8.0D, 0.0D, 3.0D, 13.0D, 6.0D, 13.0D), Block.makeCuboidShape(9.0D, 0.0D, 3.0D, 13.0D, 6.0D, 13.0D),
				Block.makeCuboidShape(10.0D, 0.0D, 3.0D, 13.0D, 6.0D, 13.0D), Block.makeCuboidShape(11.0D, 0.0D, 3.0D, 13.0D, 6.0D, 13.0D)};
		public CustomBlock() {
			super(Block.Properties.create(Material.CAKE).sound(SoundType.CLOTH).hardnessAndResistance(0.5f, 1f).lightValue(0), 1, 0.1F);
			setRegistryName("fooddalishpastry");
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
