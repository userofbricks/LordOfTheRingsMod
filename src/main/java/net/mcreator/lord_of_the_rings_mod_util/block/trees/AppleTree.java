package net.mcreator.lord_of_the_rings_mod_util.block.trees;

import java.util.Random;

import javax.annotation.Nullable;

import net.mcreator.lord_of_the_rings_mod_util.world.gen.feature.AppleTreeFeature;
import net.minecraft.block.Blocks;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;

public class AppleTree extends Tree {

	@Nullable
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean booleanIn) {
		return new TreeFeature(TreeFeatureConfig::func_227338_a_).withConfiguration((
				new TreeFeatureConfig.Builder(
						new SimpleBlockStateProvider(Blocks.STRIPPED_OAK_LOG.getDefaultState()),
						new SimpleBlockStateProvider(Blocks.SPRUCE_LEAVES.getDefaultState()), 
						new BlobFoliagePlacer(2, 0)))
				.baseHeight(8)
				.setSapling((net.minecraftforge.common.IPlantable) Blocks.JUNGLE_SAPLING)
				.build());
	}

}
