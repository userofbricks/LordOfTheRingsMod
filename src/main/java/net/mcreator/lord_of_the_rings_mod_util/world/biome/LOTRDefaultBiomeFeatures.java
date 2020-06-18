package net.mcreator.lord_of_the_rings_mod_util.world.biome;

import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.lord_of_the_rings_mod.block.OliveLeavesBlock;
import net.mcreator.lord_of_the_rings_mod.block.LogPearBlock;
import net.mcreator.lord_of_the_rings_mod.block.LogOliveBlock;
import net.mcreator.lord_of_the_rings_mod.block.LogMangoBlock;
import net.mcreator.lord_of_the_rings_mod.block.LogCherryBlock;
import net.mcreator.lord_of_the_rings_mod.block.LogAppleBlock;
import net.mcreator.lord_of_the_rings_mod.SaplingsFruit;
import net.mcreator.lord_of_the_rings_mod.LeavesFruit;

public class LOTRDefaultBiomeFeatures {
	// logs
	private static final BlockState APPLE_LOG = LogAppleBlock.block.getDefaultState();
	private static final BlockState CHERRY_LOG = LogCherryBlock.block.getDefaultState();
	private static final BlockState MANGO_LOG = LogMangoBlock.block.getDefaultState();
	private static final BlockState PEAR_LOG = LogPearBlock.block.getDefaultState();
	private static final BlockState OLIVE_LOG = LogOliveBlock.block.getDefaultState();
	// leaves
	private static final BlockState APPLE_LEAVES = LeavesFruit.leaves_apple.getDefaultState();
	private static final BlockState CHERRY_LEAVES = LeavesFruit.leaves_cherry.getDefaultState();
	private static final BlockState MANGO_LEAVES = LeavesFruit.leaves_mango.getDefaultState();
	private static final BlockState PEAR_LEAVES = LeavesFruit.leaves_pear.getDefaultState();
	private static final BlockState OLIVE_LEAVES = OliveLeavesBlock.block.getDefaultState();
	// features
	public static final TreeFeatureConfig FANCY_APPLE_TREE_CONFIG = fancy_tree(APPLE_LOG, APPLE_LEAVES, SaplingsFruit.sapling_apple, 5);
	public static final TreeFeatureConfig FANCY_CHERRY_TREE_CONFIG = fancy_tree(CHERRY_LOG, CHERRY_LEAVES, SaplingsFruit.sapling_cherry, 5);
	public static final TreeFeatureConfig FANCY_MANGO_TREE_CONFIG = fancy_tree(MANGO_LOG, MANGO_LEAVES, SaplingsFruit.sapling_mango, 5);
	public static final TreeFeatureConfig FANCY_PEAR_TREE_CONFIG = fancy_tree(PEAR_LOG, PEAR_LEAVES, SaplingsFruit.sapling_pear, 5);
	public static final TreeFeatureConfig FANCY_OLIVE_TREE_CONFIG = fancy_tree(OLIVE_LOG, OLIVE_LEAVES, SaplingsFruit.sapling_pear, 4);
	
	private static TreeFeatureConfig fancy_tree(BlockState log, BlockState leaf, Block sapling, int height) {
		return (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(log), new SimpleBlockStateProvider(leaf), new BlobFoliagePlacer(0, 0))).baseHeight(height).setSapling((net.minecraftforge.common.IPlantable) sapling).build();
	}
}
