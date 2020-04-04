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
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.Mirror;
import net.minecraft.util.Direction;
import net.minecraft.util.BlockRenderLayer;
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

import net.mcreator.lord_of_the_rings_mod.LOTRDrinks;
import net.mcreator.lord_of_the_rings_mod.itemgroup.LOTRFoodAndDrinkTabItemGroup;
import net.mcreator.lord_of_the_rings_mod.block.DrinkMugBlock;
import net.mcreator.lord_of_the_rings_mod.block.BasePlaceableDrinkItem;
import net.mcreator.lord_of_the_rings_mod.block.BaseCupBlock;

import java.util.List;
import java.util.Collections;

@ObjectHolder("lord_of_the_rings_mod")
@Mod.EventBusSubscriber(modid = "lord_of_the_rings_mod", bus = Bus.MOD)
public class DrinkInMug {
	public static final Block mug_water = null;
	public static final Block mug_milk = null;
	public static final Block mug_chocolate = null;
	public static final Block mug_mango_juice = null;
	public static final Block mug_blueberry_juice = null;
	public static final Block mug_blackberry_juice = null;
	public static final Block mug_rasberry_juice = null;
	public static final Block mug_cranberry_juice = null;
	public static final Block mug_elderberry_juice = null;
	public static final Block mug_orange_juice = null;
	public static final Block mug_lemonade = null;
	public static final Block mug_jungle_remedy = null; // similar to milk
	public static final Block mug_apple_juice = null;
	public static final Block mug_red_grape_juice = null;
	public static final Block mug_green_grape_juice = null;
	public static final Block mug_pomegranate_juice = null;
	// alcohol
	public static final Block mug_ale = null;
	public static final Block mug_mead = null;
	public static final Block mug_red_wine = null;
	public static final Block mug_cider = null;
	public static final Block mug_perry = null;
	public static final Block mug_cherry_liqueur = null;
	public static final Block mug_rum = null;
	public static final Block mug_dwarven_ale = null;
	public static final Block mug_vodka = null;
	public static final Block mug_maple_beer = null;
	public static final Block mug_arak = null;
	public static final Block mug_carrot_wine = null;
	public static final Block mug_bannana_beer = null;
	public static final Block mug_melon_liqueur = null;
	public static final Block mug_cactus_liqueur = null;
	public static final Block mug_lemon_liqueur = null;
	public static final Block mug_lime_liqueur = null;
	public static final Block mug_corn_liqueur = null;
	public static final Block mug_white_wine = null;
	public static final Block mug_plum_kvass = null;
	public static final Block mug_termite_tequila = null;
	public static final Block mug_soured_milk = null;
	public static final Block mug_pomegranate_wine = null;
	// miruvor
	public static final Block mug_miruvor = null;
	public static final Block mug_miruvor1 = null;
	public static final Block mug_miruvor2 = null;
	public static final Block mug_miruvor3 = null;
	public static final Block mug_miruvor4 = null;
	// orc draught
	public static final Block mug_orc_draught = null;
	public static final Block mug_orc_draught1 = null;
	public static final Block mug_orc_draught2 = null;
	public static final Block mug_orc_draught3 = null;
	public static final Block mug_orc_draught4 = null;
	// athelas brew
	public static final Block mug_athelas_brew = null;
	public static final Block mug_athelas_brew1 = null;
	public static final Block mug_athelas_brew2 = null;
	public static final Block mug_athelas_brew3 = null;
	public static final Block mug_athelas_brew4 = null;
	// dwarven tonic
	public static final Block mug_dwarven_tonic = null;
	public static final Block mug_dwarven_tonic1 = null;
	public static final Block mug_dwarven_tonic2 = null;
	public static final Block mug_dwarven_tonic3 = null;
	public static final Block mug_dwarven_tonic4 = null;
	// torog draught
	public static final Block mug_torog_draught = null;
	public static final Block mug_torog_draught1 = null;
	public static final Block mug_torog_draught2 = null;
	public static final Block mug_torog_draught3 = null;
	public static final Block mug_torog_draught4 = null;
	// taurethrim cocoa
	public static final Block mug_taurethrim_cocoa = null;
	public static final Block mug_taurethrim_cocoa1 = null;
	public static final Block mug_taurethrim_cocoa2 = null;
	public static final Block mug_taurethrim_cocoa3 = null;
	public static final Block mug_taurethrim_cocoa4 = null;
	// morgul draught
	public static final Block mug_morgul_draught = null;
	public static final Block mug_morgul_draught1 = null;
	public static final Block mug_morgul_draught2 = null;
	public static final Block mug_morgul_draught3 = null;
	public static final Block mug_morgul_draught4 = null;
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_water"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_milk"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_chocolate"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_mango_juice"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_blueberry_juice"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_blackberry_juice"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_rasberry_juice"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_cranberry_juice"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_elderberry_juice"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_orange_juice"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_lemonade"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_jungle_remedy"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_apple_juice"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_red_grape_juice"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_green_grape_juice"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_pomegranate_juice"));
		// alcohol
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_ale"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_mead"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_red_wine"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_perry"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_cherry_liqueur"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_rum"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_dwarven_ale"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_vodka"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_maple_beer"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_arak"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_carrot_wine"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_bannana_beer"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_melon_liqueur"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_cactus_liqueur"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_lemon_liqueur"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_lime_liqueur"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_corn_liqueur"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_white_wine"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_plum_kvass"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_termite_tequila"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_soured_milk"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_pomegranate_wine"));
		// miruvor
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_miruvor"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_miruvor1"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_miruvor2"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_miruvor3"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_miruvor4"));
		// orc draught
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_orc_draught"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_orc_draught1"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_orc_draught2"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_orc_draught3"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_orc_draught4"));
		// athelas brew
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_athelas_brew"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_athelas_brew1"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_athelas_brew2"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_athelas_brew3"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_athelas_brew4"));
		// dwarven tonic
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_dwarven_tonic"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_dwarven_tonic1"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_dwarven_tonic2"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_dwarven_tonic3"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_dwarven_tonic4"));
		// torog draught
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_torog_draught"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_torog_draught1"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_torog_draught2"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_torog_draught3"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_torog_draught4"));
		// taurethrim cocoa
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_taurethrim_cocoa"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_taurethrim_cocoa1"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_taurethrim_cocoa2"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_taurethrim_cocoa3"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_taurethrim_cocoa4"));
		// morgul draught
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_morgul_draught"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_morgul_draught1"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_morgul_draught2"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_morgul_draught3"));
		event.getRegistry().register(new CustomBlock().setRegistryName("mug_morgul_draught4"));
	}

	@SubscribeEvent
	public static void registerBlockItems(final RegistryEvent.Register<Item> event) {
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_water, new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.water),
						0, false, Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_water"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_milk, new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.milk), 0,
						false, Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_milk"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_chocolate,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.chocolate), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_chocolate"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_mango_juice,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.juice), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_mango_juice"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_blueberry_juice,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.juice_berry), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_blueberry_juice"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_blackberry_juice,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.juice_berry), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_blackberry_juice"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_rasberry_juice,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.juice_berry), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_rasberry_juice"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_cranberry_juice,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.juice_berry), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_cranberry_juice"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_elderberry_juice,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.juice_berry), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_elderberry_juice"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_orange_juice,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.juice), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_orange_juice"));
		event.getRegistry().register(
				new BasePlaceableDrinkItem(mug_lemonade, new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.juice), 0,
						false, Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_lemonade"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_jungle_remedy,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.juice), 0, true,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_jungle_remedy"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_apple_juice,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.juice), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_apple_juice"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_red_grape_juice,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.juice), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_red_grape_juice"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_green_grape_juice,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.juice), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_green_grape_juice"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_pomegranate_juice,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.juice), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_pomegranate_juice"));
		// alcohol
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_ale, new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.ale), 0,
						false, Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_ale"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_mead, new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.mead), 0,
						false, Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_mead"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_red_wine,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.red_wine), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_red_wine"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_perry, new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.perry),
						0, false, Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_perry"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_cherry_liqueur,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.cherry_liqueur), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_cherry_liqueur"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_rum, new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.rum), 0,
						false, Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_rum"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_dwarven_ale,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.dwarven_ale), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_dwarven_ale"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_vodka, new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.vodka),
						0, false, Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_vodka"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_maple_beer,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.maple_beer), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_maple_beer"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_arak, new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.arak), 0,
						false, Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_arak"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_carrot_wine,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.carrot_wine), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_carrot_wine"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_bannana_beer,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.bannana_beer), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_bannana_beer"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_melon_liqueur,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.melon_liqueur), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_melon_liqueur"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_cactus_liqueur,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.cactus_liqueur), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_cactus_liqueur"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_lemon_liqueur,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.lemon_liqueur), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_lemon_liqueur"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_lime_liqueur,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.lime_liqueur), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_lime_liqueur"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_corn_liqueur,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.corn_liqueur), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_corn_liqueur"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_white_wine,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.white_wine), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_white_wine"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_plum_kvass,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.plum_kvass), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_plum_kvass"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_termite_tequila,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.termite_tequila), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_termite_tequila"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_soured_milk,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.soured_milk), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_soured_milk"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_pomegranate_wine,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.pomegranate_wine), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_pomegranate_wine"));
		// miruvor
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_miruvor,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.miruvor), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_miruvor"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_miruvor1,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.miruvor1), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_miruvor1"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_miruvor2,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.miruvor2), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_miruvor2"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_miruvor3,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.miruvor3), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_miruvor3"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_miruvor4,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.miruvor4), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_miruvor4"));
		// orc draught
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_orc_draught,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.orc_draught), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_orc_draught"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_orc_draught1,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.orc_draught1), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_orc_draught1"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_orc_draught2,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.orc_draught2), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_orc_draught2"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_orc_draught3,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.orc_draught3), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_orc_draught3"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_orc_draught4,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.orc_draught4), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_orc_draught4"));
		// athelas brew
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_athelas_brew,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.athelas_brew), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_athelas_brew"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_athelas_brew1,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.athelas_brew1), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_athelas_brew1"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_athelas_brew2,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.athelas_brew2), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_athelas_brew2"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_athelas_brew3,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.athelas_brew3), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_athelas_brew3"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_athelas_brew4,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.athelas_brew4), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_athelas_brew4"));
		// dwarven tonic
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_dwarven_tonic,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.dwarven_tonic), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_dwarven_tonic"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_dwarven_tonic1,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.dwarven_tonic1), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_dwarven_tonic1"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_dwarven_tonic2,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.dwarven_tonic2), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_dwarven_tonic2"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_dwarven_tonic3,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.dwarven_tonic3), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_dwarven_tonic3"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_dwarven_tonic4,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.dwarven_tonic4), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_dwarven_tonic4"));
		// torog draught
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_torog_draught,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.torog_draught), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_torog_draught"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_torog_draught1,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.torog_draught1), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_torog_draught1"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_torog_draught2,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.torog_draught2), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_torog_draught2"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_torog_draught3,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.torog_draught3), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_torog_draught3"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_torog_draught4,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.torog_draught4), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_torog_draught4"));
		// taurethrim cocoa
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_taurethrim_cocoa,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.taurethrim_cocoa), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_taurethrim_cocoa"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_taurethrim_cocoa1,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.taurethrim_cocoa1), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_taurethrim_cocoa1"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_taurethrim_cocoa2,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.taurethrim_cocoa2), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_taurethrim_cocoa2"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_taurethrim_cocoa3,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.taurethrim_cocoa3), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_taurethrim_cocoa3"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_taurethrim_cocoa4,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.taurethrim_cocoa4), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_taurethrim_cocoa4"));
		// morgul draught
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_morgul_draught,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.morgul_draught), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_morgul_draught"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_morgul_draught1,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.morgul_draught1), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_morgul_draught1"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_morgul_draught2,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.morgul_draught2), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_morgul_draught2"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_morgul_draught3,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.morgul_draught3), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_morgul_draught3"));
		event.getRegistry()
				.register(new BasePlaceableDrinkItem(mug_morgul_draught4,
						new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.morgul_draught4), 0, false,
						Item.getItemFromBlock(DrinkMugBlock.block)).setRegistryName("mug_morgul_draught4"));
	}
	public static class CustomBlock extends BaseCupBlock {
		public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
		public CustomBlock() {
			super(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1f, 10f).lightValue(0));
			this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public BlockRenderLayer getRenderLayer() {
			return BlockRenderLayer.CUTOUT;
		}

		@Override
		public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
			return Block.makeCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 8.0D, 11.0D);
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
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}
