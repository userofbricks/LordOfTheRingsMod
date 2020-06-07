package net.mcreator.lord_of_the_rings_mod_util.block.trees;

import java.util.Random;

import javax.annotation.Nullable;

import net.mcreator.lord_of_the_rings_mod_util.world.biome.LOTRDefaultBiomeFeatures;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

public class AppleTree extends Tree {

	@Nullable
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean booleanIn) {
		return Feature.FANCY_TREE.withConfiguration(LOTRDefaultBiomeFeatures.FANCY_APPLE_TREE_CONFIG);
	}

}
