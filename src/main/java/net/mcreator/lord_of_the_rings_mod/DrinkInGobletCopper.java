/**
 * This mod element is always locked. Enter your code in the methods below.
 * If you don't need some of these methods, you can remove them as they
 * are overrides of the base class LordOfTheRingsModElements.ModElement.
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

import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.RegistryObject;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.Mirror;
import net.minecraft.util.NonNullList;
import net.minecraft.util.Direction;
import net.minecraft.state.StateContainer;
import net.minecraft.state.DirectionProperty;
import net.minecraft.item.ItemStack;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemGroup;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.lord_of_the_rings_mod_util.registry.LOTRRegistryHelper;
import net.mcreator.lord_of_the_rings_mod_util.LOTRDrinks;
import net.mcreator.lord_of_the_rings_mod_util.bases.BaseCupBlock;
import net.mcreator.lord_of_the_rings_mod.block.DrinkAleHornGoldBlock;
import net.mcreator.lord_of_the_rings_mod.block.DrinkGobletCopperBlock;

import java.util.List;

import com.teamabnormals.abnormals_core.core.utils.ItemStackUtils;

import java.util.Collections;

@Mod.EventBusSubscriber(modid = "lord_of_the_rings_mod", bus = Bus.MOD)
@LordOfTheRingsModModElements.ModElement.Tag
public class DrinkInGobletCopper extends LordOfTheRingsModModElements.ModElement {
	public DrinkInGobletCopper(LordOfTheRingsModModElements instance) {
		super(instance, 999997);
	}
	public static final LOTRRegistryHelper HELPER = LordOfTheRingsModMod.REGISTRY_HELPER;
	public static final String type = "goblet_copper_";
	public static final Block turnsInto = DrinkGobletCopperBlock.block;
	public static final RegistryObject<Block> water = HELPER.createDrinkBlock(type + "water", () -> new CustomBlock(), LOTRDrinks.water, 0, false,turnsInto);
	public static final RegistryObject<Block> milk = HELPER.createDrinkBlock(type + "milk", () -> new CustomBlock(), LOTRDrinks.milk, 0, false,turnsInto);
	public static final RegistryObject<Block> chocolate = HELPER.createDrinkBlock(type + "chocolate", () -> new CustomBlock(), LOTRDrinks.chocolate,0, false, turnsInto);
	public static final RegistryObject<Block> mango_juice = HELPER.createDrinkBlock(type + "mango_juice", () -> new CustomBlock(), LOTRDrinks.juice,0, false, turnsInto);
	public static final RegistryObject<Block> blueberry_juice = HELPER.createDrinkBlock(type + "blueberry_juice", () -> new CustomBlock(),LOTRDrinks.juice_berry, 0, false, turnsInto);
	public static final RegistryObject<Block> blackberry_juice = HELPER.createDrinkBlock(type + "blackberry_juice", () -> new CustomBlock(),LOTRDrinks.juice_berry, 0, false, turnsInto);
	public static final RegistryObject<Block> rasberry_juice = HELPER.createDrinkBlock(type + "rasberry_juice", () -> new CustomBlock(),LOTRDrinks.juice_berry, 0, false, turnsInto);
	public static final RegistryObject<Block> cranberry_juice = HELPER.createDrinkBlock(type + "cranberry_juice", () -> new CustomBlock(),LOTRDrinks.juice_berry, 0, false, turnsInto);
	public static final RegistryObject<Block> elderberry_juice = HELPER.createDrinkBlock(type + "elderberry_juice", () -> new CustomBlock(),LOTRDrinks.juice_berry, 0, false, turnsInto);
	public static final RegistryObject<Block> orange_juice = HELPER.createDrinkBlock(type + "orange_juice", () -> new CustomBlock(), LOTRDrinks.juice,0, false, turnsInto);
	public static final RegistryObject<Block> lemonade = HELPER.createDrinkBlock(type + "lemonade", () -> new CustomBlock(), LOTRDrinks.juice, 0,false, turnsInto);
	public static final RegistryObject<Block> jungle_remedy = HELPER.createDrinkBlock(type + "jungle_remedy", () -> new CustomBlock(),LOTRDrinks.juice, 0, true, turnsInto); // similar to milk
	public static final RegistryObject<Block> apple_juice = HELPER.createDrinkBlock(type + "apple_juice", () -> new CustomBlock(), LOTRDrinks.juice,0, false, turnsInto);
	public static final RegistryObject<Block> red_grape_juice = HELPER.createDrinkBlock(type + "red_grape_juice", () -> new CustomBlock(),LOTRDrinks.juice, 0, false, turnsInto);
	public static final RegistryObject<Block> green_grape_juice = HELPER.createDrinkBlock(type + "green_grape_juice", () -> new CustomBlock(),LOTRDrinks.juice, 0, false, turnsInto);
	public static final RegistryObject<Block> pomegranate_juice = HELPER.createDrinkBlock(type + "pomegranate_juice", () -> new CustomBlock(),LOTRDrinks.juice, 0, false, turnsInto);
	// alcohol
	public static final RegistryObject<Block> ale = HELPER.createDrinkBlock(type + "ale", () -> new CustomBlock(), LOTRDrinks.ale, 0, false,turnsInto);
	public static final RegistryObject<Block> mead = HELPER.createDrinkBlock(type + "mead", () -> new CustomBlock(), LOTRDrinks.mead, 0, false,turnsInto);
	public static final RegistryObject<Block> red_wine = HELPER.createDrinkBlock(type + "red_wine", () -> new CustomBlock(), LOTRDrinks.red_wine, 0,false, turnsInto);
	public static final RegistryObject<Block> cider = HELPER.createDrinkBlock(type + "cider", () -> new CustomBlock(), LOTRDrinks.cider, 0, false,turnsInto);
	public static final RegistryObject<Block> perry = HELPER.createDrinkBlock(type + "perry", () -> new CustomBlock(), LOTRDrinks.perry, 0, false,turnsInto);
	public static final RegistryObject<Block> cherry_liqueur = HELPER.createDrinkBlock(type + "cherry_liqueur", () -> new CustomBlock(),LOTRDrinks.cherry_liqueur, 0, false, turnsInto);
	public static final RegistryObject<Block> rum = HELPER.createDrinkBlock(type + "rum", () -> new CustomBlock(), LOTRDrinks.rum, 0, false,turnsInto);
	public static final RegistryObject<Block> vodka = HELPER.createDrinkBlock(type + "vodka", () -> new CustomBlock(), LOTRDrinks.vodka, 0, false,turnsInto);
	public static final RegistryObject<Block> maple_beer = HELPER.createDrinkBlock(type + "maple_beer", () -> new CustomBlock(),LOTRDrinks.maple_beer, 0, false, turnsInto);
	public static final RegistryObject<Block> arak = HELPER.createDrinkBlock(type + "arak", () -> new CustomBlock(), LOTRDrinks.arak, 0, false,turnsInto);
	// miruvor
	public static final RegistryObject<Block> miruvor = HELPER.createDrinkBlock(type + "miruvor", () -> new CustomBlock(), LOTRDrinks.miruvor, 0,false, turnsInto);
	public static final RegistryObject<Block> miruvor1 = HELPER.createDrinkBlock(type + "miruvor1", () -> new CustomBlock(), LOTRDrinks.miruvor1, 0,false, turnsInto);
	public static final RegistryObject<Block> miruvor2 = HELPER.createDrinkBlock(type + "miruvor2", () -> new CustomBlock(), LOTRDrinks.miruvor2, 0,false, turnsInto);
	public static final RegistryObject<Block> miruvor3 = HELPER.createDrinkBlock(type + "miruvor3", () -> new CustomBlock(), LOTRDrinks.miruvor3, 0,false, turnsInto);
	public static final RegistryObject<Block> miruvor4 = HELPER.createDrinkBlock(type + "miruvor4", () -> new CustomBlock(), LOTRDrinks.miruvor4, 0,false, turnsInto);
	// orc draught
	public static final RegistryObject<Block> orc_draught = HELPER.createDrinkBlock(type + "orc_draught", () -> new CustomBlock(),LOTRDrinks.orc_draught, 0, false, turnsInto);
	public static final RegistryObject<Block> orc_draught1 = HELPER.createDrinkBlock(type + "orc_draught1", () -> new CustomBlock(),LOTRDrinks.orc_draught1, 0, false, turnsInto);
	public static final RegistryObject<Block> orc_draught2 = HELPER.createDrinkBlock(type + "orc_draught2", () -> new CustomBlock(),LOTRDrinks.orc_draught2, 0, false, turnsInto);
	public static final RegistryObject<Block> orc_draught3 = HELPER.createDrinkBlock(type + "orc_draught3", () -> new CustomBlock(),LOTRDrinks.orc_draught3, 0, false, turnsInto);
	public static final RegistryObject<Block> orc_draught4 = HELPER.createDrinkBlock(type + "orc_draught4", () -> new CustomBlock(),LOTRDrinks.orc_draught4, 0, false, turnsInto);
	// athelas brew
	public static final RegistryObject<Block> athelas_brew = HELPER.createDrinkBlock(type + "athelas_brew", () -> new CustomBlock(),LOTRDrinks.athelas_brew, 0, false, turnsInto);
	public static final RegistryObject<Block> athelas_brew1 = HELPER.createDrinkBlock(type + "athelas_brew1", () -> new CustomBlock(),LOTRDrinks.athelas_brew1, 0, false, turnsInto);
	public static final RegistryObject<Block> athelas_brew2 = HELPER.createDrinkBlock(type + "athelas_brew2", () -> new CustomBlock(),LOTRDrinks.athelas_brew2, 0, false, turnsInto);
	public static final RegistryObject<Block> athelas_brew3 = HELPER.createDrinkBlock(type + "athelas_brew3", () -> new CustomBlock(),LOTRDrinks.athelas_brew3, 0, false, turnsInto);
	public static final RegistryObject<Block> athelas_brew4 = HELPER.createDrinkBlock(type + "athelas_brew4", () -> new CustomBlock(),LOTRDrinks.athelas_brew4, 0, false, turnsInto);
	// dwarven tonic
	public static final RegistryObject<Block> dwarven_tonic = HELPER.createDrinkBlock(type + "dwarven_tonic", () -> new CustomBlock(),LOTRDrinks.dwarven_tonic, 0, false, turnsInto);
	public static final RegistryObject<Block> dwarven_tonic1 = HELPER.createDrinkBlock(type + "dwarven_tonic1", () -> new CustomBlock(),LOTRDrinks.dwarven_tonic1, 0, false, turnsInto);
	public static final RegistryObject<Block> dwarven_tonic2 = HELPER.createDrinkBlock(type + "dwarven_tonic2", () -> new CustomBlock(),LOTRDrinks.dwarven_tonic2, 0, false, turnsInto);
	public static final RegistryObject<Block> dwarven_tonic3 = HELPER.createDrinkBlock(type + "dwarven_tonic3", () -> new CustomBlock(),LOTRDrinks.dwarven_tonic3, 0, false, turnsInto);
	public static final RegistryObject<Block> dwarven_tonic4 = HELPER.createDrinkBlock(type + "dwarven_tonic4", () -> new CustomBlock(),LOTRDrinks.dwarven_tonic4, 0, false, turnsInto);
	// taurethrim cocoa
	public static final RegistryObject<Block> taurethrim_cocoa = HELPER.createDrinkBlock(type + "taurethrim_cocoa", () -> new CustomBlock(),LOTRDrinks.taurethrim_cocoa, 0, false, turnsInto);
	public static final RegistryObject<Block> taurethrim_cocoa1 = HELPER.createDrinkBlock(type + "taurethrim_cocoa1", () -> new CustomBlock(),LOTRDrinks.taurethrim_cocoa1, 0, false, turnsInto);
	public static final RegistryObject<Block> taurethrim_cocoa2 = HELPER.createDrinkBlock(type + "taurethrim_cocoa2", () -> new CustomBlock(),LOTRDrinks.taurethrim_cocoa2, 0, false, turnsInto);
	public static final RegistryObject<Block> taurethrim_cocoa3 = HELPER.createDrinkBlock(type + "taurethrim_cocoa3", () -> new CustomBlock(),LOTRDrinks.taurethrim_cocoa3, 0, false, turnsInto);
	public static final RegistryObject<Block> taurethrim_cocoa4 = HELPER.createDrinkBlock(type + "taurethrim_cocoa4", () -> new CustomBlock(),LOTRDrinks.taurethrim_cocoa4, 0, false, turnsInto);
	/*
	 * 
	 */
	public static class CustomBlock extends BaseCupBlock {
		public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
		public CustomBlock() {
			super(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1f, 10f).lightValue(0).notSolid());
			this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
		}

		@Override
		public BlockState TurnsInto() {
			return DrinkGobletCopperBlock.block.getDefaultState();
		}

		@Override
		public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return false;
		}

		@Override
		public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
			return Block.makeCuboidShape(5.5D, 0.0D, 5.5D, 10.5D, 9.0D, 10.5D);
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
			@SuppressWarnings("deprecation")
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
		
		@Override
		public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
			Block before = DrinkAleHornGoldBlock.block;
			if (ItemStackUtils.isInGroup(this.asItem(), group)) {
				if (this.asItem() == water.get().asItem()) {					before = DrinkInGobletWood.taurethrim_cocoa4.get();
				} else if (this.asItem() == milk.get().asItem()) {				before = water.get();
				} else if (this.asItem() == chocolate.get().asItem()) {			before = milk.get();
				} else if (this.asItem() == mango_juice.get().asItem()) {		before = chocolate.get();
				} else if (this.asItem() == blueberry_juice.get().asItem()) {	before = mango_juice.get();
				} else if (this.asItem() == blackberry_juice.get().asItem()) {	before = blueberry_juice.get();
				} else if (this.asItem() == rasberry_juice.get().asItem()) {	before = blackberry_juice.get();
				} else if (this.asItem() == cranberry_juice.get().asItem()) {	before = rasberry_juice.get();
				} else if (this.asItem() == elderberry_juice.get().asItem()) {	before = cranberry_juice.get();
				} else if (this.asItem() == orange_juice.get().asItem()) {		before = elderberry_juice.get();
				} else if (this.asItem() == lemonade.get().asItem()) {			before = orange_juice.get();
				} else if (this.asItem() == jungle_remedy.get().asItem()) {		before = lemonade.get();
				} else if (this.asItem() == apple_juice.get().asItem()) {		before = jungle_remedy.get();
				} else if (this.asItem() == red_grape_juice.get().asItem()) {	before = apple_juice.get();
				} else if (this.asItem() == green_grape_juice.get().asItem()) {	before = red_grape_juice.get();
				} else if (this.asItem() == pomegranate_juice.get().asItem()) {	before = green_grape_juice.get();
				} else if (this.asItem() == ale.get().asItem()) {				before = pomegranate_juice.get();
				} else if (this.asItem() == mead.get().asItem()) {				before = ale.get();
				} else if (this.asItem() == red_wine.get().asItem()) { 			before = mead.get();
				} else if (this.asItem() == cider.get().asItem()) { 			before = red_wine.get();
				} else if (this.asItem() == perry.get().asItem()) { 			before = cider.get();
				} else if (this.asItem() == cherry_liqueur.get().asItem()) { 	before = perry.get();
				} else if (this.asItem() == rum.get().asItem()) { 				before = cherry_liqueur.get();
				} else if (this.asItem() == vodka.get().asItem()) { 			before = rum.get();
				} else if (this.asItem() == maple_beer.get().asItem()) { 		before = vodka.get();
				} else if (this.asItem() == arak.get().asItem()) { 				before = maple_beer.get();
				} else if (this.asItem() == miruvor.get().asItem()) { 			before = arak.get();
				} else if (this.asItem() == miruvor1.get().asItem()) { 			before = miruvor.get();
				} else if (this.asItem() == miruvor2.get().asItem()) { 			before = miruvor1.get();
				} else if (this.asItem() == miruvor3.get().asItem()) { 			before = miruvor2.get();
				} else if (this.asItem() == miruvor4.get().asItem()) { 			before = miruvor3.get();
				} else if (this.asItem() == orc_draught.get().asItem()) { 		before = miruvor4.get();
				} else if (this.asItem() == orc_draught1.get().asItem()) { 		before = orc_draught.get();
				} else if (this.asItem() == orc_draught2.get().asItem()) { 		before = orc_draught1.get();
				} else if (this.asItem() == orc_draught3.get().asItem()) { 		before = orc_draught2.get();
				} else if (this.asItem() == orc_draught4.get().asItem()) { 		before = orc_draught3.get();
				} else if (this.asItem() == athelas_brew.get().asItem()) { 		before = orc_draught4.get();
				} else if (this.asItem() == athelas_brew1.get().asItem()) { 	before = athelas_brew.get();
				} else if (this.asItem() == athelas_brew2.get().asItem()) { 	before = athelas_brew1.get();
				} else if (this.asItem() == athelas_brew3.get().asItem()) { 	before = athelas_brew2.get();
				} else if (this.asItem() == athelas_brew4.get().asItem()) { 	before = athelas_brew3.get();
				} else if (this.asItem() == dwarven_tonic.get().asItem()) { 	before = athelas_brew4.get();
				} else if (this.asItem() == dwarven_tonic1.get().asItem()) { 	before = dwarven_tonic.get();
				} else if (this.asItem() == dwarven_tonic2.get().asItem()) { 	before = dwarven_tonic1.get();
				} else if (this.asItem() == dwarven_tonic3.get().asItem()) { 	before = dwarven_tonic2.get();
				} else if (this.asItem() == dwarven_tonic4.get().asItem()) { 	before = dwarven_tonic3.get();
				} else if (this.asItem() == taurethrim_cocoa.get().asItem()) { 	before = dwarven_tonic4.get();
				} else if (this.asItem() == taurethrim_cocoa1.get().asItem()) { before = taurethrim_cocoa.get();
				} else if (this.asItem() == taurethrim_cocoa2.get().asItem()) { before = taurethrim_cocoa1.get();
				} else if (this.asItem() == taurethrim_cocoa3.get().asItem()) { before = taurethrim_cocoa2.get();
				} else if (this.asItem() == taurethrim_cocoa4.get().asItem()) { before = taurethrim_cocoa3.get();
				}
				int targetIndex = ItemStackUtils.findIndexOfItem(before.asItem(), items);
				if (targetIndex != -1) {
					items.add(targetIndex + 1, new ItemStack(this));
				} else {
					super.fillItemGroup(group, items);
				}
			}
		}
	}
}
