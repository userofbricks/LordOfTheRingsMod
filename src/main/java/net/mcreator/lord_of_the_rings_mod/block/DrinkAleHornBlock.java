
package net.mcreator.lord_of_the_rings_mod.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.shapes.VoxelShapes;
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
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.BlockItem;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.lord_of_the_rings_mod.itemgroup.LOTRFoodAndDrinkTabItemGroup;
import net.mcreator.lord_of_the_rings_mod.LordOfTheRingsModModElements;

import java.util.List;
import java.util.Collections;

@LordOfTheRingsModModElements.ModElement.Tag
public class DrinkAleHornBlock extends LordOfTheRingsModModElements.ModElement {
	@ObjectHolder("lord_of_the_rings_mod:drink_ale_horn")
	public static final Block block = null;
	public DrinkAleHornBlock(LordOfTheRingsModModElements instance) {
		super(instance, 98);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(
				() -> new BlockItem(block, new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getCutout());
	}
	public static class CustomBlock extends Block {
		public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
		public CustomBlock() {
			super(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1f, 10f).lightValue(0).notSolid());
			this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
			setRegistryName("drink_ale_horn");
		}

		@Override
		public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return false;
		}

		@Override
		public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
			return true;
		}

		@Override
		public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
			switch ((Direction) state.get(FACING)) {
				case UP :
				case DOWN :
				case SOUTH :
				default :
					return VoxelShapes.or(Block.makeCuboidShape(0, 0, 5.75, 10.25, 6.25, 10.25),
							Block.makeCuboidShape(7, 6.25, 5.75, 13.25, 9.5, 10.25), Block.makeCuboidShape(9, 9.25, 5.5, 15.5, 12.75, 10.5),
							Block.makeCuboidShape(10.5, 12.75, 5.5, 16, 16, 10.5), Block.makeCuboidShape(4, 6.25, 6.5, 7, 7.75, 9.5));
				case NORTH :
					return VoxelShapes.or(Block.makeCuboidShape(5.75, 0, 5.75, 16, 6.25, 10.25),
							Block.makeCuboidShape(2.75, 6.25, 5.75, 9, 9.5, 10.25), Block.makeCuboidShape(0.5, 9.25, 5.5, 7, 12.75, 10.5),
							Block.makeCuboidShape(0, 12.75, 5.5, 5.5, 16, 10.5), Block.makeCuboidShape(9, 6.25, 6.5, 12, 7.75, 9.5));
				case WEST :
					return VoxelShapes.or(Block.makeCuboidShape(5.75, 0, 0, 10.25, 6.25, 10.25),
							Block.makeCuboidShape(5.75, 6.25, 7, 10.25, 9.5, 13.25), Block.makeCuboidShape(5.5, 9.25, 9, 10.5, 12.75, 15.5),
							Block.makeCuboidShape(5.5, 12.75, 10.5, 10.5, 16, 16), Block.makeCuboidShape(6.5, 6.25, 4, 9.5, 7.75, 7));
				case EAST :
					return VoxelShapes.or(Block.makeCuboidShape(5.75, 0, 5.75, 10.25, 6.25, 16),
							Block.makeCuboidShape(5.75, 6.25, 2.75, 10.25, 9.5, 9), Block.makeCuboidShape(5.5, 9.25, 0.5, 10.5, 12.75, 7),
							Block.makeCuboidShape(5.5, 12.75, 0, 10.5, 16, 5.5), Block.makeCuboidShape(6.5, 6.25, 9, 9.5, 7.75, 12));
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
			return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
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
