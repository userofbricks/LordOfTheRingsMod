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

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.lord_of_the_rings_mod.itemgroup.LOTRBlocksTabItemGroup;
import net.mcreator.lord_of_the_rings_mod.LordOfTheRingsModModElements;

import java.util.List;
import java.util.Collections;

@ObjectHolder("lord_of_the_rings_mod")
@LordOfTheRingsModModElements.ModElement.Tag
public class LeavesAppleBlock extends LordOfTheRingsModModElements.ModElement {
	public static final Block leaves_apple = null;
	public static final Block leaves_apple_red = null;
	public static final Block leaves_apple_green = null;
	public static final Block leaves_apple_yellow = null;
	public static final Block leaves_cherry = null;
	public static final Block leaves_mango = null;
	public static final Block leaves_mango_full = null;
	public static final Block leaves_pear = null;
	public static final Block leaves_pear_brown = null;
	public static final Block leaves_pear_green = null;
	public static final Block leaves_pear_yellow = null;
	public LeavesAppleBlock(LordOfTheRingsModModElements instance) {
		super(instance, 999994);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock().setRegistryName("leaves_apple"));
		elements.items.add(() -> item(leaves_apple));
		elements.blocks.add(() -> new CustomBlock().setRegistryName("leaves_apple_red"));
		elements.items.add(() -> item(leaves_apple_red));
		elements.blocks.add(() -> new CustomBlock().setRegistryName("leaves_apple_green"));
		elements.items.add(() -> item(leaves_apple_green));
		elements.blocks.add(() -> new CustomBlock().setRegistryName("leaves_apple_yellow"));
		elements.items.add(() -> item(leaves_apple_yellow));
		elements.blocks.add(() -> new CustomBlock().setRegistryName("leaves_cherry"));
		elements.items.add(() -> item(leaves_cherry));
		elements.blocks.add(() -> new CustomBlock().setRegistryName("leaves_mango"));
		elements.items.add(() -> item(leaves_mango));
		elements.blocks.add(() -> new CustomBlock().setRegistryName("leaves_mango_full"));
		elements.items.add(() -> item(leaves_mango_full));
		elements.blocks.add(() -> new CustomBlock().setRegistryName("leaves_pear"));
		elements.items.add(() -> item(leaves_pear));
		elements.blocks.add(() -> new CustomBlock().setRegistryName("leaves_pear_brown"));
		elements.items.add(() -> item(leaves_pear_brown));
		elements.blocks.add(() -> new CustomBlock().setRegistryName("leaves_pear_green"));
		elements.items.add(() -> item(leaves_pear_green));
		elements.blocks.add(() -> new CustomBlock().setRegistryName("leaves_pear_yellow"));
		elements.items.add(() -> item(leaves_pear_yellow));
	}

	private Item item(Block block) {
		return new BlockItem(block, new Item.Properties().group(LOTRBlocksTabItemGroup.tab)).setRegistryName(block.getRegistryName());
	}
	
	public static class CustomBlock extends LeavesBlock {
		public CustomBlock() {
			super(Block.Properties.create(Material.LEAVES).sound(SoundType.PLANT).hardnessAndResistance(0.5f, 1f).lightValue(0).notSolid()
					.tickRandomly());
		}

		@Override
		public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 10;
		}

		@Override
		public MaterialColor getMaterialColor(BlockState state, IBlockReader blockAccess, BlockPos pos) {
			return MaterialColor.FOLIAGE;
		}
	}
}
