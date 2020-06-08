/**
 * This mod element is always locked. Enter your code in the methods below.
 * If you don't need some of these methods, you can remove them as they
 * are overrides of the base class LordOfTheRingsModModElements.ModElement.
 *
 * You can register new events in this class too.
 *
 * As this class is loaded into mod element list, it NEEDS to extend
 * ModElement class. If you remove this extend statement or remove the
 * constructor, the compilation will fail.
 *
 * If you want to make a plain independent class, create it in
 * "Workspace" -> "Source" menu.
 *
 * If you change workspace package, modid or prefix, you will need
 * to manually adapt this file to these changes or remake it.
*/
package net.mcreator.lord_of_the_rings_mod;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.trees.Tree;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.lord_of_the_rings_mod.itemgroup.LOTRBlocksTabItemGroup;
import net.mcreator.lord_of_the_rings_mod_util.block.trees.AppleTree;

@ObjectHolder("lord_of_the_rings_mod")
@LordOfTheRingsModModElements.ModElement.Tag
public class SaplingsFruit extends LordOfTheRingsModModElements.ModElement {
	public static final Block sapling_apple = null;
	public static final Block sapling_cherry = null;
	public static final Block sapling_mango = null;
	public static final Block sapling_pear = null;
	public SaplingsFruit(LordOfTheRingsModModElements instance) {
		super(instance, 999993);
	}

	@Override
	public void initElements() {
		/*
		elements.blocks.add(() -> new CustomBlock(new AppleTree()).setRegistryName("sapling_apple"));
		elements.items.add(() -> item(sapling_apple));
		
		elements.blocks.add(() -> new CustomBlock(null).setRegistryName("sapling_cherry"));
		elements.items.add(() -> item(sapling_cherry));
		elements.blocks.add(() -> new CustomBlock(null).setRegistryName("sapling_mango"));
		elements.items.add(() -> item(sapling_mango));
		elements.blocks.add(() -> new CustomBlock(null).setRegistryName("sapling_pear"));
		elements.items.add(() -> item(sapling_pear));
		*/
	}

	private Item item(Block block) {
		return new BlockItem(block, new Item.Properties().group(LOTRBlocksTabItemGroup.tab)).setRegistryName(block.getRegistryName());
	}
	public static class CustomBlock extends SaplingBlock {
		public CustomBlock(Tree treeIn) {
			super(treeIn, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).hardnessAndResistance(0.5f, 1f).lightValue(0).notSolid()
					.tickRandomly());
		}

		@Override
		public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 10;
		}

		@Override
		public MaterialColor getMaterialColor(BlockState state, IBlockReader blockAccess, BlockPos pos) {
			return MaterialColor.AIR;
		}
	}
}
