package net.mcreator.lord_of_the_rings_mod_util.world.biome;

import net.mcreator.lord_of_the_rings_mod.LeavesFruit;
import net.mcreator.lord_of_the_rings_mod.SaplingsFruit;
import net.mcreator.lord_of_the_rings_mod.block.LogAppleBlock;
import net.mcreator.lord_of_the_rings_mod.block.LogCherryBlock;
import net.mcreator.lord_of_the_rings_mod.block.LogMangoBlock;
import net.mcreator.lord_of_the_rings_mod.block.LogPearBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;

public class LOTRDefaultBiomeFeatures {
	//logs
	private static final BlockState APPLE_LOG = LogAppleBlock.block.getDefaultState();
	private static final BlockState CHERRY_LOG = LogCherryBlock.block.getDefaultState();
	private static final BlockState MANGO_LOG = LogMangoBlock.block.getDefaultState();
	private static final BlockState PEAR_LOG = LogPearBlock.block.getDefaultState();
	//leaves
	private static final BlockState APPLE_LEAVES = LeavesFruit.leaves_apple.getDefaultState();
	private static final BlockState CHERRY_LEAVES = LeavesFruit.leaves_cherry.getDefaultState();
	private static final BlockState MANGO_LEAVES = LeavesFruit.leaves_mango.getDefaultState();
	private static final BlockState PEAR_LEAVES = LeavesFruit.leaves_pear.getDefaultState();
	//features
	public static final TreeFeatureConfig FANCY_APPLE_TREE_CONFIG = fancy_tree(APPLE_LOG, APPLE_LEAVES, SaplingsFruit.sapling_apple);
	public static final TreeFeatureConfig FANCY_CHERRY_TREE_CONFIG = fancy_tree(CHERRY_LOG, CHERRY_LEAVES, SaplingsFruit.sapling_cherry);
	public static final TreeFeatureConfig FANCY_MANGO_TREE_CONFIG = fancy_tree(MANGO_LOG, MANGO_LEAVES, SaplingsFruit.sapling_mango);
	public static final TreeFeatureConfig FANCY_PEAR_TREE_CONFIG = fancy_tree(PEAR_LOG, PEAR_LEAVES, SaplingsFruit.sapling_pear);

	private static TreeFeatureConfig fancy_tree(BlockState log, BlockState leaf, Block sapling) {
		return (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(log), new SimpleBlockStateProvider(leaf), new BlobFoliagePlacer(0, 0))).setSapling((net.minecraftforge.common.IPlantable)sapling).build();
	}
}
