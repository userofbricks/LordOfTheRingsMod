package net.mcreator.lord_of_the_rings_mod.block;

import net.minecraft.world.World;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Hand;
import net.minecraft.util.Direction;
import net.minecraft.util.DamageSource;
import net.minecraft.stats.Stats;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.StateContainer;
import net.minecraft.state.IntegerProperty;
import net.minecraft.pathfinding.PathType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

public class BaseCupBlock extends Block {
	protected BaseCupBlock(Block.Properties properties) {
		super(properties);
	}

	public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		if (!worldIn.isRemote) {
			return this.drinkCup(worldIn, pos, state, player);
		} else {
			ItemStack itemstack = player.getHeldItem(handIn);
			return this.drinkCup(worldIn, pos, state, player) || itemstack.isEmpty();
		}
	}

	private boolean drinkCup(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
		LivingEntity entityLiving = player instanceof LivingEntity ? (LivingEntity) player : null;
		ItemStack stack = new ItemStack(this);
		Item item = stack.getItem();
		BasePlaceableDrinkItem drinkItem = item instanceof BasePlaceableDrinkItem ? (BasePlaceableDrinkItem) item : null;
		if (!player.canEat(false)) {
			return false;
		} else {
			if (drinkItem.getDamage() >= 1) {
			entityLiving.attackEntityFrom(DamageSource.MAGIC, drinkItem.getDamage());
			}
			if (drinkItem.getMilk() == true) {
				if (!worldIn.isRemote) {
					entityLiving.clearActivePotions();
				}
			}
			if (item.isFood()) {
				entityLiving.onFoodEaten(worldIn, stack);
			}
			return true;
		}
	}

	/**
	 * Update the provided state given the provided neighbor facing and neighbor
	 * state, returning a new state. For example, fences make their connections to
	 * the passed in state if possible, and wet concrete powder immediately returns
	 * its solidified counterpart. Note that this method should ideally consider
	 * only the specific face passed in.
	 */
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos,
			BlockPos facingPos) {
		return facing == Direction.DOWN && !stateIn.isValidPosition(worldIn, currentPos)
				? Blocks.AIR.getDefaultState()
				: super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
	}

	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos.down()).getMaterial().isSolid();
	}

	public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
		return false;
	}
}
