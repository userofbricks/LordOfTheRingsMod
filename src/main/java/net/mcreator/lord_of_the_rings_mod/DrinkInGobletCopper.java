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

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.Mirror;
import net.minecraft.util.Direction;
import net.minecraft.state.StateContainer;
import net.minecraft.state.DirectionProperty;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.lord_of_the_rings_mod_util.block.BasePlaceableDrinkItem;
import net.mcreator.lord_of_the_rings_mod_util.block.BaseCupBlock;
import net.mcreator.lord_of_the_rings_mod_util.LOTRDrinks;
import net.mcreator.lord_of_the_rings_mod.itemgroup.LOTRFoodAndDrinkTabItemGroup;
import net.mcreator.lord_of_the_rings_mod.block.DrinkGobletCopperBlock;

import java.util.List;
import java.util.Collections;

@ObjectHolder("lord_of_the_rings_mod")
@Mod.EventBusSubscriber(modid = "lord_of_the_rings_mod", bus = Bus.MOD)
public class DrinkInGobletCopper {
	public static final Block goblet_copper_water = null;
	public static final Block goblet_copper_milk = null;
	public static final Block goblet_copper_chocolate = null;
	public static final Block goblet_copper_mango_juice = null;
	public static final Block goblet_copper_blueberry_juice = null;
	public static final Block goblet_copper_blackberry_juice = null;
	public static final Block goblet_copper_rasberry_juice = null;
	public static final Block goblet_copper_cranberry_juice = null;
	public static final Block goblet_copper_elderberry_juice = null;
	public static final Block goblet_copper_orange_juice = null;
	public static final Block goblet_copper_lemonade = null;
	public static final Block goblet_copper_jungle_remedy = null; // similar to milk
	public static final Block goblet_copper_apple_juice = null;
	public static final Block goblet_copper_red_grape_juice = null;
	public static final Block goblet_copper_green_grape_juice = null;
	public static final Block goblet_copper_pomegranate_juice = null;
	// alcohol
	public static final Block goblet_copper_ale = null;
	public static final Block goblet_copper_mead = null;
	public static final Block goblet_copper_red_wine = null;
	public static final Block goblet_copper_cider = null;
	public static final Block goblet_copper_perry = null;
	public static final Block goblet_copper_cherry_liqueur = null;
	public static final Block goblet_copper_rum = null;
	public static final Block goblet_copper_vodka = null;
	public static final Block goblet_copper_maple_beer = null;
	public static final Block goblet_copper_arak = null;
	// miruvor
	public static final Block goblet_copper_miruvor = null;
	public static final Block goblet_copper_miruvor1 = null;
	public static final Block goblet_copper_miruvor2 = null;
	public static final Block goblet_copper_miruvor3 = null;
	public static final Block goblet_copper_miruvor4 = null;
	// orc draught
	public static final Block goblet_copper_orc_draught = null;
	public static final Block goblet_copper_orc_draught1 = null;
	public static final Block goblet_copper_orc_draught2 = null;
	public static final Block goblet_copper_orc_draught3 = null;
	public static final Block goblet_copper_orc_draught4 = null;
	// athelas brew
	public static final Block goblet_copper_athelas_brew = null;
	public static final Block goblet_copper_athelas_brew1 = null;
	public static final Block goblet_copper_athelas_brew2 = null;
	public static final Block goblet_copper_athelas_brew3 = null;
	public static final Block goblet_copper_athelas_brew4 = null;
	// dwarven tonic
	public static final Block goblet_copper_dwarven_tonic = null;
	public static final Block goblet_copper_dwarven_tonic1 = null;
	public static final Block goblet_copper_dwarven_tonic2 = null;
	public static final Block goblet_copper_dwarven_tonic3 = null;
	public static final Block goblet_copper_dwarven_tonic4 = null;
	// taurethrim cocoa
	public static final Block goblet_copper_taurethrim_cocoa = null;
	public static final Block goblet_copper_taurethrim_cocoa1 = null;
	public static final Block goblet_copper_taurethrim_cocoa2 = null;
	public static final Block goblet_copper_taurethrim_cocoa3 = null;
	public static final Block goblet_copper_taurethrim_cocoa4 = null;
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		event.getRegistry().register(new CustomBlock().setRegistryName("goblet_copper_water"));
		event.getRegistry().register(new CustomBlock().setRegistryName("goblet_copper_milk"));
		event.getRegistry().register(new CustomBlock().setRegistryName("goblet_copper_chocolate"));
		event.getRegistry().register(new CustomBlock().setRegistryName("goblet_copper_mango_juice"));
		event.getRegistry().register(new CustomBlock().setRegistryName("goblet_copper_blueberry_juice"));
		event.getRegistry().register(new CustomBlock().setRegistryName("goblet_copper_blackberry_juice"));
		event.getRegistry().register(new CustomBlock().setRegistryName("goblet_copper_rasberry_juice"));
		event.getRegistry().register(new CustomBlock().setRegistryName("goblet_copper_cranberry_juice"));
		event.getRegistry().register(new CustomBlock().setRegistryName("goblet_copper_elderberry_juice"));
		event.getRegistry().register(new CustomBlock().setRegistryName("goblet_copper_orange_juice"));
		event.getRegistry().register(new CustomBlock().setRegistryName("goblet_copper_lemonade"));
		event.getRegistry().register(new CustomBlock().setRegistryName("goblet_copper_jungle_remedy"));
		event.getRegistry().register(new CustomBlock().setRegistryName("goblet_copper_apple_juice"));
		event.getRegistry().register(new CustomBlock().setRegistryName("goblet_copper_red_grape_juice"));
		event.getRegistry().register(new CustomBlock().setRegistryName("goblet_copper_green_grape_juice"));
		event.getRegistry().register(new CustomBlock().setRegistryName("goblet_copper_pomegranate_juice"));
		// alcohol
		event.getRegistry().register(new CustomBlock().setRegistryName("goblet_copper_ale"));
		event.getRegistry().register(new CustomBlock().setRegistryName("goblet_copper_mead"));
		event.getRegistry().register(new CustomBlock().setRegistryName("goblet_copper_red_wine"));
		event.getRegistry().register(new CustomBlock().setRegistryName("goblet_copper_perry"));
		event.getRegistry().register(new CustomBlock().setRegistryName("goblet_copper_cherry_liqueur"));
		event.getRegistry().register(new CustomBlock().setRegistryName("goblet_copper_rum"));
		event.getRegistry().register(new CustomBlock().setRegistryName("goblet_copper_vodka"));
		event.getRegistry().register(new CustomBlock().setRegistryName("goblet_copper_maple_beer"));
		event.getRegistry().register(new CustomBlock().setRegistryName("goblet_copper_arak"));
		// miruvor
		event.getRegistry().register(new CustomBlock().setRegistryName("goblet_copper_miruvor"));
		event.getRegistry().register(new CustomBlock().setRegistryName("goblet_copper_miruvor1"));
		event.getRegistry().register(new CustomBlock().setRegistryName("goblet_copper_miruvor2"));
		event.getRegistry().register(new CustomBlock().setRegistryName("goblet_copper_miruvor3"));
		event.getRegistry().register(new CustomBlock().setRegistryName("goblet_copper_miruvor4"));
		// orc draught
		event.getRegistry().register(new CustomBlock().setRegistryName("goblet_copper_orc_draught"));
		event.getRegistry().register(new CustomBlock().setRegistryName("goblet_copper_orc_draught1"));
		event.getRegistry().register(new CustomBlock().setRegistryName("goblet_copper_orc_draught2"));
		event.getRegistry().register(new CustomBlock().setRegistryName("goblet_copper_orc_draught3"));
		event.getRegistry().register(new CustomBlock().setRegistryName("goblet_copper_orc_draught4"));
		// athelas brew
		event.getRegistry().register(new CustomBlock().setRegistryName("goblet_copper_athelas_brew"));
		event.getRegistry().register(new CustomBlock().setRegistryName("goblet_copper_athelas_brew1"));
		event.getRegistry().register(new CustomBlock().setRegistryName("goblet_copper_athelas_brew2"));
		event.getRegistry().register(new CustomBlock().setRegistryName("goblet_copper_athelas_brew3"));
		event.getRegistry().register(new CustomBlock().setRegistryName("goblet_copper_athelas_brew4"));
		// dwarven tonic
		event.getRegistry().register(new CustomBlock().setRegistryName("goblet_copper_dwarven_tonic"));
		event.getRegistry().register(new CustomBlock().setRegistryName("goblet_copper_dwarven_tonic1"));
		event.getRegistry().register(new CustomBlock().setRegistryName("goblet_copper_dwarven_tonic2"));
		event.getRegistry().register(new CustomBlock().setRegistryName("goblet_copper_dwarven_tonic3"));
		event.getRegistry().register(new CustomBlock().setRegistryName("goblet_copper_dwarven_tonic4"));
		// taurethrim cocoa
		event.getRegistry().register(new CustomBlock().setRegistryName("goblet_copper_taurethrim_cocoa"));
		event.getRegistry().register(new CustomBlock().setRegistryName("goblet_copper_taurethrim_cocoa1"));
		event.getRegistry().register(new CustomBlock().setRegistryName("goblet_copper_taurethrim_cocoa2"));
		event.getRegistry().register(new CustomBlock().setRegistryName("goblet_copper_taurethrim_cocoa3"));
		event.getRegistry().register(new CustomBlock().setRegistryName("goblet_copper_taurethrim_cocoa4"));
	}

	@SuppressWarnings("deprecation")
	@SubscribeEvent
	public static void registerBlockItems(final RegistryEvent.Register<Item> event) {
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(goblet_copper_water,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.water), 0, false,
						Item.getItemFromBlock(DrinkGobletCopperBlock.block)).setRegistryName("goblet_copper_water"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(goblet_copper_milk,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.milk), 0, false,
						Item.getItemFromBlock(DrinkGobletCopperBlock.block)).setRegistryName("goblet_copper_milk"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(goblet_copper_chocolate,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.chocolate), 0, false,
						Item.getItemFromBlock(DrinkGobletCopperBlock.block)).setRegistryName("goblet_copper_chocolate"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(goblet_copper_mango_juice,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.juice), 0, false,
						Item.getItemFromBlock(DrinkGobletCopperBlock.block)).setRegistryName("goblet_copper_mango_juice"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(goblet_copper_blueberry_juice,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.juice_berry), 0, false,
						Item.getItemFromBlock(DrinkGobletCopperBlock.block)).setRegistryName("goblet_copper_blueberry_juice"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(goblet_copper_blackberry_juice,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.juice_berry), 0, false,
						Item.getItemFromBlock(DrinkGobletCopperBlock.block)).setRegistryName("goblet_copper_blackberry_juice"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(goblet_copper_rasberry_juice,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.juice_berry), 0, false,
						Item.getItemFromBlock(DrinkGobletCopperBlock.block)).setRegistryName("goblet_copper_rasberry_juice"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(goblet_copper_cranberry_juice,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.juice_berry), 0, false,
						Item.getItemFromBlock(DrinkGobletCopperBlock.block)).setRegistryName("goblet_copper_cranberry_juice"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(goblet_copper_elderberry_juice,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.juice_berry), 0, false,
						Item.getItemFromBlock(DrinkGobletCopperBlock.block)).setRegistryName("goblet_copper_elderberry_juice"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(goblet_copper_orange_juice,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.juice), 0, false,
						Item.getItemFromBlock(DrinkGobletCopperBlock.block)).setRegistryName("goblet_copper_orange_juice"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(goblet_copper_lemonade,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.juice), 0, false,
						Item.getItemFromBlock(DrinkGobletCopperBlock.block)).setRegistryName("goblet_copper_lemonade"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(goblet_copper_jungle_remedy,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.juice), 0, true,
						Item.getItemFromBlock(DrinkGobletCopperBlock.block)).setRegistryName("goblet_copper_jungle_remedy"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(goblet_copper_apple_juice,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.juice), 0, false,
						Item.getItemFromBlock(DrinkGobletCopperBlock.block)).setRegistryName("goblet_copper_apple_juice"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(goblet_copper_red_grape_juice,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.juice), 0, false,
						Item.getItemFromBlock(DrinkGobletCopperBlock.block)).setRegistryName("goblet_copper_red_grape_juice"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(goblet_copper_green_grape_juice,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.juice), 0, false,
						Item.getItemFromBlock(DrinkGobletCopperBlock.block)).setRegistryName("goblet_copper_green_grape_juice"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(goblet_copper_pomegranate_juice,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.juice), 0, false,
						Item.getItemFromBlock(DrinkGobletCopperBlock.block)).setRegistryName("goblet_copper_pomegranate_juice"));
		// alcohol
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(goblet_copper_ale,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.ale), 0, false,
						Item.getItemFromBlock(DrinkGobletCopperBlock.block)).setRegistryName("goblet_copper_ale"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(goblet_copper_mead,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.mead), 0, false,
						Item.getItemFromBlock(DrinkGobletCopperBlock.block)).setRegistryName("goblet_copper_mead"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(goblet_copper_red_wine,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.red_wine), 0, false,
						Item.getItemFromBlock(DrinkGobletCopperBlock.block)).setRegistryName("goblet_copper_red_wine"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(goblet_copper_perry,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.perry), 0, false,
						Item.getItemFromBlock(DrinkGobletCopperBlock.block)).setRegistryName("goblet_copper_perry"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(goblet_copper_cherry_liqueur,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.cherry_liqueur), 0, false,
						Item.getItemFromBlock(DrinkGobletCopperBlock.block)).setRegistryName("goblet_copper_cherry_liqueur"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(goblet_copper_rum,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.rum), 0, false,
						Item.getItemFromBlock(DrinkGobletCopperBlock.block)).setRegistryName("goblet_copper_rum"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(goblet_copper_vodka,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.vodka), 0, false,
						Item.getItemFromBlock(DrinkGobletCopperBlock.block)).setRegistryName("goblet_copper_vodka"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(goblet_copper_maple_beer,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.maple_beer), 0, false,
						Item.getItemFromBlock(DrinkGobletCopperBlock.block)).setRegistryName("goblet_copper_maple_beer"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(goblet_copper_arak,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.arak), 0, false,
						Item.getItemFromBlock(DrinkGobletCopperBlock.block)).setRegistryName("goblet_copper_arak"));
		// miruvor
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(goblet_copper_miruvor,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.miruvor), 0, false,
						Item.getItemFromBlock(DrinkGobletCopperBlock.block)).setRegistryName("goblet_copper_miruvor"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(goblet_copper_miruvor1,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.miruvor1), 0, false,
						Item.getItemFromBlock(DrinkGobletCopperBlock.block)).setRegistryName("goblet_copper_miruvor1"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(goblet_copper_miruvor2,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.miruvor2), 0, false,
						Item.getItemFromBlock(DrinkGobletCopperBlock.block)).setRegistryName("goblet_copper_miruvor2"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(goblet_copper_miruvor3,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.miruvor3), 0, false,
						Item.getItemFromBlock(DrinkGobletCopperBlock.block)).setRegistryName("goblet_copper_miruvor3"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(goblet_copper_miruvor4,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.miruvor4), 0, false,
						Item.getItemFromBlock(DrinkGobletCopperBlock.block)).setRegistryName("goblet_copper_miruvor4"));
		// orc draught
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(goblet_copper_orc_draught,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.orc_draught), 0, false,
						Item.getItemFromBlock(DrinkGobletCopperBlock.block)).setRegistryName("goblet_copper_orc_draught"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(goblet_copper_orc_draught1,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.orc_draught1), 0, false,
						Item.getItemFromBlock(DrinkGobletCopperBlock.block)).setRegistryName("goblet_copper_orc_draught1"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(goblet_copper_orc_draught2,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.orc_draught2), 0, false,
						Item.getItemFromBlock(DrinkGobletCopperBlock.block)).setRegistryName("goblet_copper_orc_draught2"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(goblet_copper_orc_draught3,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.orc_draught3), 0, false,
						Item.getItemFromBlock(DrinkGobletCopperBlock.block)).setRegistryName("goblet_copper_orc_draught3"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(goblet_copper_orc_draught4,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.orc_draught4), 0, false,
						Item.getItemFromBlock(DrinkGobletCopperBlock.block)).setRegistryName("goblet_copper_orc_draught4"));
		// athelas brew
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(goblet_copper_athelas_brew,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.athelas_brew), 0, false,
						Item.getItemFromBlock(DrinkGobletCopperBlock.block)).setRegistryName("goblet_copper_athelas_brew"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(goblet_copper_athelas_brew1,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.athelas_brew1), 0, false,
						Item.getItemFromBlock(DrinkGobletCopperBlock.block)).setRegistryName("goblet_copper_athelas_brew1"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(goblet_copper_athelas_brew2,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.athelas_brew2), 0, false,
						Item.getItemFromBlock(DrinkGobletCopperBlock.block)).setRegistryName("goblet_copper_athelas_brew2"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(goblet_copper_athelas_brew3,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.athelas_brew3), 0, false,
						Item.getItemFromBlock(DrinkGobletCopperBlock.block)).setRegistryName("goblet_copper_athelas_brew3"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(goblet_copper_athelas_brew4,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.athelas_brew4), 0, false,
						Item.getItemFromBlock(DrinkGobletCopperBlock.block)).setRegistryName("goblet_copper_athelas_brew4"));
		// dwarven tonic
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(goblet_copper_dwarven_tonic,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.dwarven_tonic), 0, false,
						Item.getItemFromBlock(DrinkGobletCopperBlock.block)).setRegistryName("goblet_copper_dwarven_tonic"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(goblet_copper_dwarven_tonic1,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.dwarven_tonic1), 0, false,
						Item.getItemFromBlock(DrinkGobletCopperBlock.block)).setRegistryName("goblet_copper_dwarven_tonic1"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(goblet_copper_dwarven_tonic2,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.dwarven_tonic2), 0, false,
						Item.getItemFromBlock(DrinkGobletCopperBlock.block)).setRegistryName("goblet_copper_dwarven_tonic2"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(goblet_copper_dwarven_tonic3,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.dwarven_tonic3), 0, false,
						Item.getItemFromBlock(DrinkGobletCopperBlock.block)).setRegistryName("goblet_copper_dwarven_tonic3"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(goblet_copper_dwarven_tonic4,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.dwarven_tonic4), 0, false,
						Item.getItemFromBlock(DrinkGobletCopperBlock.block)).setRegistryName("goblet_copper_dwarven_tonic4"));
		// taurethrim cocoa
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(goblet_copper_taurethrim_cocoa,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.taurethrim_cocoa), 0, false,
						Item.getItemFromBlock(DrinkGobletCopperBlock.block)).setRegistryName("goblet_copper_taurethrim_cocoa"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(goblet_copper_taurethrim_cocoa1,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.taurethrim_cocoa1), 0, false,
						Item.getItemFromBlock(DrinkGobletCopperBlock.block)).setRegistryName("goblet_copper_taurethrim_cocoa1"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(goblet_copper_taurethrim_cocoa2,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.taurethrim_cocoa2), 0, false,
						Item.getItemFromBlock(DrinkGobletCopperBlock.block)).setRegistryName("goblet_copper_taurethrim_cocoa2"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(goblet_copper_taurethrim_cocoa3,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.taurethrim_cocoa3), 0, false,
						Item.getItemFromBlock(DrinkGobletCopperBlock.block)).setRegistryName("goblet_copper_taurethrim_cocoa3"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(goblet_copper_taurethrim_cocoa4,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.taurethrim_cocoa4), 0, false,
						Item.getItemFromBlock(DrinkGobletCopperBlock.block)).setRegistryName("goblet_copper_taurethrim_cocoa4"));
	}
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
	}
}
