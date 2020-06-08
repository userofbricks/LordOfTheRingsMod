package net.mcreator.lord_of_the_rings_mod_util.block;

import net.mcreator.lord_of_the_rings_mod_util.math.MathUtilMisc;
import net.minecraft.block.Block;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockUtil {

	public static boolean isBlockInTag(String tagName, Block block) {
		if ((BlockTags.getCollection().getOrCreate(new ResourceLocation(("logs").toLowerCase(java.util.Locale.ENGLISH)))
				.contains(block.getDefaultState().getBlock()))) {
			return true;
		}
		return false;
	}

	public static void setReplaceableBlock(BlockPos pos, Block block, World worldIn, String replaceableTagName) {
		if ((isBlockInTag(replaceableTagName, worldIn.getBlockState(pos).getBlock()) || replaceableTagName == "everything")
				&& replaceableTagName != "nothing") {
			worldIn.setBlockState(pos, block.getDefaultState());
		}
	}
	
	public void makeSphere(BlockPos pos, Block block, World worldIn, double radius, boolean filled, String replaceableTagName) {
		makeSphere(pos, block, worldIn, radius, radius, radius, filled, replaceableTagName);
	}

	/**
	 * Makes a sphere or ellipsoid.
	 *
	 * @param pos Center of the sphere or ellipsoid
	 * @param block The block pattern to use
	 * @param radiusX The sphere/ellipsoid's largest north/south extent
	 * @param radiusY The sphere/ellipsoid's largest up/down extent
	 * @param radiusZ The sphere/ellipsoid's largest east/west extent
	 * @param filled If false, only a shell will be generated.
	 * @param replaceableTagName The name of the tag containing replaceable blocks.
	 */
	public static void makeSphere(BlockPos pos, Block block, World worldIn, double radiusX, double radiusY, double radiusZ, boolean filled,
			String replaceableTagName) {
		if (radiusX <= 16 && radiusY <= 16 && radiusZ <= 16) {

			radiusX += 0.5;
			radiusY += 0.5;
			radiusZ += 0.5;

			final double invRadiusX = 1 / radiusX;
			final double invRadiusY = 1 / radiusY;
			final double invRadiusZ = 1 / radiusZ;

			final int ceilRadiusX = (int) Math.ceil(radiusX);
			final int ceilRadiusY = (int) Math.ceil(radiusY);
			final int ceilRadiusZ = (int) Math.ceil(radiusZ);

			double nextXn = 0;
			forX : for (int x = 0; x <= ceilRadiusX; ++x) {
				final double xn = nextXn;
				nextXn = (x + 1) * invRadiusX;
				double nextYn = 0;
				forY : for (int y = 0; y <= ceilRadiusY; ++y) {
					final double yn = nextYn;
					nextYn = (y + 1) * invRadiusY;
					double nextZn = 0;
					forZ : for (int z = 0; z <= ceilRadiusZ; ++z) {
						final double zn = nextZn;
						nextZn = (z + 1) * invRadiusZ;

						double distanceSq = MathUtilMisc.lengthSq3d(xn, yn, zn);
						if (distanceSq > 1) {
							if (z == 0) {
								if (y == 0) {
									break forX;
								}
								break forY;
							}
							break forZ;
						}

						if (!filled) {
							if (MathUtilMisc.lengthSq3d(nextXn, yn, zn) <= 1 && MathUtilMisc.lengthSq3d(xn, nextYn, zn) <= 1
									&& MathUtilMisc.lengthSq3d(xn, yn, nextZn) <= 1) {
								continue;
							}
						}

						setReplaceableBlock(pos.add(x, y, z), block, worldIn, replaceableTagName);
						setReplaceableBlock(pos.add(-x, y, z), block, worldIn, replaceableTagName);
						setReplaceableBlock(pos.add(x, -y, z), block, worldIn, replaceableTagName);
						setReplaceableBlock(pos.add(x, y, -z), block, worldIn, replaceableTagName);
						setReplaceableBlock(pos.add(-x, -y, z), block, worldIn, replaceableTagName);
						setReplaceableBlock(pos.add(x, -y, -z), block, worldIn, replaceableTagName);
						setReplaceableBlock(pos.add(-x, y, -z), block, worldIn, replaceableTagName);
						setReplaceableBlock(pos.add(-x, -y, -z), block, worldIn, replaceableTagName);
					}
				}
			}
		}
	}
}
