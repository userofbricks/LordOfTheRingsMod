package net.mcreator.lord_of_the_rings_mod_util.world.structure;

import net.mcreator.lord_of_the_rings_mod_util.block.BlockUtil;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TreeUtil {
	
	public void leavesSphere(BlockPos pos, Block block, World worldIn, double radius) {
		BlockUtil.makeSphere(pos, block, worldIn, radius + 1, radius, radius, false, "forge:leaf_replacables");
	}
}
