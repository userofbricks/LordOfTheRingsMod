
package net.mcreator.lord_of_the_rings_mod.block;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.Mirror;
import net.minecraft.util.Direction;
import net.minecraft.state.StateContainer;
import net.minecraft.state.DirectionProperty;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.DirectionalBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.lord_of_the_rings_mod.itemgroup.LOTRFoodAndDrinkTabItemGroup;
import net.mcreator.lord_of_the_rings_mod.LordOfTheRingsModModElements;

import java.util.List;
import java.util.Collections;

@LordOfTheRingsModModElements.ModElement.Tag
public class FoodDateBlock extends LordOfTheRingsModModElements.ModElement {
	@ObjectHolder("lord_of_the_rings_mod:fooddate")
	public static final Block block = null;
	public FoodDateBlock(LordOfTheRingsModModElements instance) {
		super(instance, 7);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block,
				new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food((new Food.Builder()).hunger(2).saturation(0.15f).build()))
						.setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public static final DirectionProperty FACING = DirectionalBlock.FACING;
		protected static final VoxelShape SOUTH_AABB = Block.makeCuboidShape(6, 5, 0, 10, 11, 4);
		protected static final VoxelShape NORTH_AABB = Block.makeCuboidShape(6, 5, 12, 10, 11, 16);
		protected static final VoxelShape WEST_AABB = Block.makeCuboidShape(12, 5, 6, 16, 11, 10);
		protected static final VoxelShape EAST_AABB = Block.makeCuboidShape(0, 5, 6, 4, 11, 10);
		protected static final VoxelShape DOWN_AABB = Block.makeCuboidShape(6, 10, 6, 10, 16, 10);
		protected static final VoxelShape UP_AABB = Block.makeCuboidShape(6, 0, 6, 10, 6, 10);
		public CustomBlock() {
			super(Block.Properties.create(Material.CAKE).sound(SoundType.SNOW).hardnessAndResistance(0.5f, 1f).lightValue(0));
			this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
			setRegistryName("fooddate");
		}

		public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
			switch ((Direction) state.get(FACING)) {
				case NORTH :
				default :
					return NORTH_AABB;
				case SOUTH :
					return SOUTH_AABB;
				case EAST :
					return EAST_AABB;
				case WEST :
					return WEST_AABB;
				case UP :
					return UP_AABB;
				case DOWN :
					return DOWN_AABB;
			}
		}

		@Override
		protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
			builder.add(FACING);
		}

		public BlockState rotate(BlockState state, Rotation rot) {
			return state.with(FACING, rot.rotate(state.get(FACING)));
		}

		public BlockState mirror(BlockState state, Mirror mirrorIn) {
			return state.rotate(mirrorIn.toRotation(state.get(FACING)));
		}

		@Override
		public BlockState getStateForPlacement(BlockItemUseContext context) {
			return this.getDefaultState().with(FACING, context.getFace());
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
