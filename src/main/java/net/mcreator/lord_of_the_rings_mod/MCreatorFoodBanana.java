package net.mcreator.lord_of_the_rings_mod;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.util.Rotation;
import net.minecraft.util.Mirror;
import net.minecraft.util.Direction;
import net.minecraft.state.StateContainer;
import net.minecraft.state.DirectionProperty;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.DirectionalBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;

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
		public static final DirectionProperty FACING = DirectionalBlock.FACING;
		
      protected static final VoxelShape SOUTH_AABB = 	Block.makeCuboidShape(6, 	2, 0, 	10, 14, 4);
      protected static final VoxelShape NORTH_AABB = 	Block.makeCuboidShape(6, 	2, 12, 	10, 14, 16);
      protected static final VoxelShape WEST_AABB = 	Block.makeCuboidShape(12, 	2, 6, 	16, 14, 10);
      protected static final VoxelShape EAST_AABB = 	Block.makeCuboidShape(0, 	2, 6, 	4, 	14, 10);
      protected static final VoxelShape DOWN_AABB = 	Block.makeCuboidShape(6, 	4, 6, 	10, 16, 10);
      protected static final VoxelShape UP_AABB = 		Block.makeCuboidShape(6, 	0, 6, 	10, 12, 10);

		public CustomBlock() {
			super(Block.Properties.create(Material.CAKE).sound(SoundType.CLOTH).hardnessAndResistance(0.5f, 1f).lightValue(0));
			this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
			setRegistryName("foodbanana");
		}

   public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
      switch((Direction)state.get(FACING)) {
      case NORTH:
      default:
         return NORTH_AABB;
      case SOUTH:
         return SOUTH_AABB;
      case EAST:
         return EAST_AABB;
      case WEST:
         return WEST_AABB;
      case UP:
         return UP_AABB;
      case DOWN:
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
