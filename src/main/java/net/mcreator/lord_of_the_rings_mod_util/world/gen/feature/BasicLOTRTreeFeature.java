package net.mcreator.lord_of_the_rings_mod_util.world.gen.feature;

import java.util.Random;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldWriter;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

public class BasicLOTRTreeFeature extends AbstractTreeFeature<TreeFeatureConfig> {
	public BasicLOTRTreeFeature() {
		super(TreeFeatureConfig::func_227338_a_);
	}

	protected boolean place(IWorldGenerationReader worldgen, Random rand, BlockPos position, Set<BlockPos> changedBlocks,
			Set<BlockPos> changedBlocks2, MutableBoundingBox bbox, TreeFeatureConfig conf) {
		if (!(worldgen instanceof IWorld))
			return false;
		IWorld world = (IWorld) worldgen;
		int height = rand.nextInt(5) + conf.baseHeight;
		boolean spawnTree = true;
		if (position.getY() >= 1 && position.getY() + height + 1 <= world.getHeight()) {
			for (int j = position.getY(); j <= position.getY() + 1 + height; j++) {
				int k = 1;
				if (j == position.getY())
					k = 0;
				if (j >= position.getY() + height - 1)
					k = 2;
				for (int px = position.getX() - k; px <= position.getX() + k && spawnTree; px++) {
					for (int pz = position.getZ() - k; pz <= position.getZ() + k && spawnTree; pz++) {
						if (j >= 0 && j < world.getHeight()) {
							if (!this.isReplaceable(world, new BlockPos(px, j, pz))) {
								spawnTree = false;
							}
						} else {
							spawnTree = false;
						}
					}
				}
			}
			if (!spawnTree) {
				return false;
			} else {
				Block ground = world.getBlockState(position.add(0, -1, 0)).getBlock();
				if (!((ground == Blocks.GRASS_BLOCK.getDefaultState().getBlock() || ground == Blocks.DIRT.getDefaultState().getBlock())))
					return false;
				BlockState state = world.getBlockState(position.down());
				if (position.getY() < world.getHeight() - height - 1) {
					setTreeBlockState(changedBlocks, world, position.down(), Blocks.DIRT.getDefaultState(), bbox);
					for (int genh = position.getY() - 3 + height; genh <= position.getY() + height; genh++) {
						int i4 = genh - (position.getY() + height);
						int j1 = (int) (1 - i4 * 0.5);
						for (int k1 = position.getX() - j1; k1 <= position.getX() + j1; ++k1) {
							for (int i2 = position.getZ() - j1; i2 <= position.getZ() + j1; ++i2) {
								int j2 = i2 - position.getZ();
								if (Math.abs(position.getX()) != j1 || Math.abs(j2) != j1 || rand.nextInt(2) != 0 && i4 != 0) {
									BlockPos blockpos = new BlockPos(k1, genh, i2);
									state = world.getBlockState(blockpos);
									if (state.getBlock().isAir(state, world, blockpos) || state.getMaterial().blocksMovement()
											|| state.isIn(BlockTags.LEAVES) || state.getBlock() == Blocks.AIR.getDefaultState().getBlock()
											|| state.getBlock() == conf.leavesProvider.getBlockState(rand, blockpos).getBlock()) {
										setTreeBlockState(changedBlocks, world, blockpos, conf.leavesProvider.getBlockState(rand, blockpos), bbox);
									}
								}
							}
						}
					}
					for (int genh = 0; genh < height; genh++) {
						BlockPos genhPos = position.up(genh);
						state = world.getBlockState(genhPos);
						setTreeBlockState(changedBlocks, world, genhPos, conf.trunkProvider.getBlockState(rand, genhPos), bbox);
					}
					if (rand.nextInt(4) == 0 && height > 5) {
						for (int hlevel = 0; hlevel < 2; hlevel++) {
							for (Direction Direction : Direction.Plane.HORIZONTAL) {
								if (rand.nextInt(4 - hlevel) == 0) {
									Direction dir = Direction.getOpposite();
									setTreeBlockState(changedBlocks, world, position.add(dir.getXOffset(), height - 5 + hlevel, dir.getZOffset()),
											Blocks.AIR.getDefaultState(), bbox);
								}
							}
						}
					}
					return true;
				} else {
					return false;
				}
			}
		} else {
			return false;
		}
	}

	private boolean canGrowInto(BlockState state) {
		Block blockType = state.getBlock();
		return blockType.getDefaultState().getMaterial() == Material.AIR || state.isIn(BlockTags.LOGS)
				|| state.isIn(BlockTags.LEAVES) || blockType == Blocks.GRASS_BLOCK.getDefaultState().getBlock()
				|| blockType == Blocks.DIRT.getDefaultState().getBlock();
	}

	private boolean isReplaceable(IWorld world, BlockPos pos) {
		BlockState state = world.getBlockState(pos);
		return state.getBlock().isAir(state, world, pos) || canGrowInto(state) || !state.getMaterial().blocksMovement();
	}

	private void setTreeBlockState(Set<BlockPos> changedBlocks, IWorldWriter world, BlockPos pos, BlockState state, MutableBoundingBox mbb) {
		super.func_227217_a_(world, pos, state, mbb);
		changedBlocks.add(pos.toImmutable());
	}
}
