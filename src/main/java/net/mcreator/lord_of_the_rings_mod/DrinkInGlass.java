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
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.lord_of_the_rings_mod_util.block.BasePlaceableDrinkItem;
import net.mcreator.lord_of_the_rings_mod_util.block.BaseCupBlock;
import net.mcreator.lord_of_the_rings_mod_util.LOTRDrinks;
import net.mcreator.lord_of_the_rings_mod.itemgroup.LOTRFoodAndDrinkTabItemGroup;
import net.mcreator.lord_of_the_rings_mod.block.DrinkGlassBlock;

import java.util.List;
import java.util.Collections;

@ObjectHolder("lord_of_the_rings_mod")
// @Mod.EventBusSubscriber(modid = "lord_of_the_rings_mod", bus = Bus.MOD)
@LordOfTheRingsModModElements.ModElement.Tag
public class DrinkInGlass extends LordOfTheRingsModModElements.ModElement {
	public DrinkInGlass(LordOfTheRingsModModElements instance) {
		super(instance, 1000000);
	}
	public static final Block glass_water = null;
	public static final Block glass_milk = null;
	public static final Block glass_chocolate = null;
	public static final Block glass_mango_juice = null;
	public static final Block glass_blueberry_juice = null;
	public static final Block glass_blackberry_juice = null;
	public static final Block glass_rasberry_juice = null;
	public static final Block glass_cranberry_juice = null;
	public static final Block glass_elderberry_juice = null;
	public static final Block glass_orange_juice = null;
	public static final Block glass_lemonade = null;
	public static final Block glass_jungle_remedy = null; // similar to milk
	public static final Block glass_apple_juice = null;
	public static final Block glass_red_grape_juice = null;
	public static final Block glass_green_grape_juice = null;
	public static final Block glass_pomegranate_juice = null;
	// alcohol
	public static final Block glass_ale = null;
	public static final Block glass_mead = null;
	public static final Block glass_red_wine = null;
	public static final Block glass_perry = null;
	public static final Block glass_cherry_liqueur = null;
	public static final Block glass_rum = null;
	public static final Block glass_vodka = null;
	public static final Block glass_maple_beer = null;
	public static final Block glass_arak = null;
	// miruvor
	public static final Block glass_miruvor = null;
	public static final Block glass_miruvor1 = null;
	public static final Block glass_miruvor2 = null;
	public static final Block glass_miruvor3 = null;
	public static final Block glass_miruvor4 = null;
	// orc draught
	public static final Block glass_orc_draught = null;
	public static final Block glass_orc_draught1 = null;
	public static final Block glass_orc_draught2 = null;
	public static final Block glass_orc_draught3 = null;
	public static final Block glass_orc_draught4 = null;
	// athelas brew
	public static final Block glass_athelas_brew = null;
	public static final Block glass_athelas_brew1 = null;
	public static final Block glass_athelas_brew2 = null;
	public static final Block glass_athelas_brew3 = null;
	public static final Block glass_athelas_brew4 = null;
	// dwarven tonic
	public static final Block glass_dwarven_tonic = null;
	public static final Block glass_dwarven_tonic1 = null;
	public static final Block glass_dwarven_tonic2 = null;
	public static final Block glass_dwarven_tonic3 = null;
	public static final Block glass_dwarven_tonic4 = null;
	// taurethrim cocoa
	public static final Block glass_taurethrim_cocoa = null;
	public static final Block glass_taurethrim_cocoa1 = null;
	public static final Block glass_taurethrim_cocoa2 = null;
	public static final Block glass_taurethrim_cocoa3 = null;
	public static final Block glass_taurethrim_cocoa4 = null;
	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock().setRegistryName("glass_water"));
		elements.blocks.add(() -> new CustomBlock().setRegistryName("glass_milk"));
		elements.blocks.add(() -> new CustomBlock().setRegistryName("glass_chocolate"));
		elements.blocks.add(() -> new CustomBlock().setRegistryName("glass_mango_juice"));
		elements.blocks.add(() -> new CustomBlock().setRegistryName("glass_blueberry_juice"));
		elements.blocks.add(() -> new CustomBlock().setRegistryName("glass_blackberry_juice"));
		elements.blocks.add(() -> new CustomBlock().setRegistryName("glass_rasberry_juice"));
		elements.blocks.add(() -> new CustomBlock().setRegistryName("glass_cranberry_juice"));
		elements.blocks.add(() -> new CustomBlock().setRegistryName("glass_elderberry_juice"));
		elements.blocks.add(() -> new CustomBlock().setRegistryName("glass_orange_juice"));
		elements.blocks.add(() -> new CustomBlock().setRegistryName("glass_lemonade"));
		elements.blocks.add(() -> new CustomBlock().setRegistryName("glass_jungle_remedy"));
		elements.blocks.add(() -> new CustomBlock().setRegistryName("glass_apple_juice"));
		elements.blocks.add(() -> new CustomBlock().setRegistryName("glass_red_grape_juice"));
		elements.blocks.add(() -> new CustomBlock().setRegistryName("glass_green_grape_juice"));
		elements.blocks.add(() -> new CustomBlock().setRegistryName("glass_pomegranate_juice"));
		// alcohol
		elements.blocks.add(() -> new CustomBlock().setRegistryName("glass_ale"));
		elements.blocks.add(() -> new CustomBlock().setRegistryName("glass_mead"));
		elements.blocks.add(() -> new CustomBlock().setRegistryName("glass_red_wine"));
		elements.blocks.add(() -> new CustomBlock().setRegistryName("glass_perry"));
		elements.blocks.add(() -> new CustomBlock().setRegistryName("glass_cherry_liqueur"));
		elements.blocks.add(() -> new CustomBlock().setRegistryName("glass_rum"));
		elements.blocks.add(() -> new CustomBlock().setRegistryName("glass_vodka"));
		elements.blocks.add(() -> new CustomBlock().setRegistryName("glass_maple_beer"));
		elements.blocks.add(() -> new CustomBlock().setRegistryName("glass_arak"));
		// miruvor
		elements.blocks.add(() -> new CustomBlock().setRegistryName("glass_miruvor"));
		elements.blocks.add(() -> new CustomBlock().setRegistryName("glass_miruvor1"));
		elements.blocks.add(() -> new CustomBlock().setRegistryName("glass_miruvor2"));
		elements.blocks.add(() -> new CustomBlock().setRegistryName("glass_miruvor3"));
		elements.blocks.add(() -> new CustomBlock().setRegistryName("glass_miruvor4"));
		// orc draught
		elements.blocks.add(() -> new CustomBlock().setRegistryName("glass_orc_draught"));
		elements.blocks.add(() -> new CustomBlock().setRegistryName("glass_orc_draught1"));
		elements.blocks.add(() -> new CustomBlock().setRegistryName("glass_orc_draught2"));
		elements.blocks.add(() -> new CustomBlock().setRegistryName("glass_orc_draught3"));
		elements.blocks.add(() -> new CustomBlock().setRegistryName("glass_orc_draught4"));
		// athelas brew
		elements.blocks.add(() -> new CustomBlock().setRegistryName("glass_athelas_brew"));
		elements.blocks.add(() -> new CustomBlock().setRegistryName("glass_athelas_brew1"));
		elements.blocks.add(() -> new CustomBlock().setRegistryName("glass_athelas_brew2"));
		elements.blocks.add(() -> new CustomBlock().setRegistryName("glass_athelas_brew3"));
		elements.blocks.add(() -> new CustomBlock().setRegistryName("glass_athelas_brew4"));
		// dwarven tonic
		elements.blocks.add(() -> new CustomBlock().setRegistryName("glass_dwarven_tonic"));
		elements.blocks.add(() -> new CustomBlock().setRegistryName("glass_dwarven_tonic1"));
		elements.blocks.add(() -> new CustomBlock().setRegistryName("glass_dwarven_tonic2"));
		elements.blocks.add(() -> new CustomBlock().setRegistryName("glass_dwarven_tonic3"));
		elements.blocks.add(() -> new CustomBlock().setRegistryName("glass_dwarven_tonic4"));
		// taurethrim cocoa
		elements.blocks.add(() -> new CustomBlock().setRegistryName("glass_taurethrim_cocoa"));
		elements.blocks.add(() -> new CustomBlock().setRegistryName("glass_taurethrim_cocoa1"));
		elements.blocks.add(() -> new CustomBlock().setRegistryName("glass_taurethrim_cocoa2"));
		elements.blocks.add(() -> new CustomBlock().setRegistryName("glass_taurethrim_cocoa3"));
		elements.blocks.add(() -> new CustomBlock().setRegistryName("glass_taurethrim_cocoa4"));
		/*
		 * items
		 */
		elements.items.add(
				() -> new BasePlaceableDrinkItem(glass_water, new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.water), 0,
						false, Item.getItemFromBlock(DrinkGlassBlock.block)).setRegistryName("glass_water"));
		elements.items
				.add(() -> new BasePlaceableDrinkItem(glass_milk, new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.milk),
						0, false, Item.getItemFromBlock(DrinkGlassBlock.block)).setRegistryName("glass_milk"));
		elements.items.add(() -> new BasePlaceableDrinkItem(glass_chocolate,
				new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.chocolate), 0, false,
				Item.getItemFromBlock(DrinkGlassBlock.block)).setRegistryName("glass_chocolate"));
		elements.items.add(() -> new BasePlaceableDrinkItem(glass_mango_juice,
				new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.juice), 0, false,
				Item.getItemFromBlock(DrinkGlassBlock.block)).setRegistryName("glass_mango_juice"));
		elements.items.add(() -> new BasePlaceableDrinkItem(glass_blueberry_juice,
				new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.juice_berry), 0, false,
				Item.getItemFromBlock(DrinkGlassBlock.block)).setRegistryName("glass_blueberry_juice"));
		elements.items.add(() -> new BasePlaceableDrinkItem(glass_blackberry_juice,
				new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.juice_berry), 0, false,
				Item.getItemFromBlock(DrinkGlassBlock.block)).setRegistryName("glass_blackberry_juice"));
		elements.items.add(() -> new BasePlaceableDrinkItem(glass_rasberry_juice,
				new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.juice_berry), 0, false,
				Item.getItemFromBlock(DrinkGlassBlock.block)).setRegistryName("glass_rasberry_juice"));
		elements.items.add(() -> new BasePlaceableDrinkItem(glass_cranberry_juice,
				new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.juice_berry), 0, false,
				Item.getItemFromBlock(DrinkGlassBlock.block)).setRegistryName("glass_cranberry_juice"));
		elements.items.add(() -> new BasePlaceableDrinkItem(glass_elderberry_juice,
				new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.juice_berry), 0, false,
				Item.getItemFromBlock(DrinkGlassBlock.block)).setRegistryName("glass_elderberry_juice"));
		elements.items.add(() -> new BasePlaceableDrinkItem(glass_orange_juice,
				new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.juice), 0, false,
				Item.getItemFromBlock(DrinkGlassBlock.block)).setRegistryName("glass_orange_juice"));
		elements.items.add(
				() -> new BasePlaceableDrinkItem(glass_lemonade, new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.juice),
						0, false, Item.getItemFromBlock(DrinkGlassBlock.block)).setRegistryName("glass_lemonade"));
		elements.items.add(() -> new BasePlaceableDrinkItem(glass_jungle_remedy,
				new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.juice), 0, true,
				Item.getItemFromBlock(DrinkGlassBlock.block)).setRegistryName("glass_jungle_remedy"));
		elements.items.add(() -> new BasePlaceableDrinkItem(glass_apple_juice,
				new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.juice), 0, false,
				Item.getItemFromBlock(DrinkGlassBlock.block)).setRegistryName("glass_apple_juice"));
		elements.items.add(() -> new BasePlaceableDrinkItem(glass_red_grape_juice,
				new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.juice), 0, false,
				Item.getItemFromBlock(DrinkGlassBlock.block)).setRegistryName("glass_red_grape_juice"));
		elements.items.add(() -> new BasePlaceableDrinkItem(glass_green_grape_juice,
				new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.juice), 0, false,
				Item.getItemFromBlock(DrinkGlassBlock.block)).setRegistryName("glass_green_grape_juice"));
		elements.items.add(() -> new BasePlaceableDrinkItem(glass_pomegranate_juice,
				new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.juice), 0, false,
				Item.getItemFromBlock(DrinkGlassBlock.block)).setRegistryName("glass_pomegranate_juice"));
		// alcohol
		elements.items
				.add(() -> new BasePlaceableDrinkItem(glass_ale, new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.ale),
						0, false, Item.getItemFromBlock(DrinkGlassBlock.block)).setRegistryName("glass_ale"));
		elements.items
				.add(() -> new BasePlaceableDrinkItem(glass_mead, new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.mead),
						0, false, Item.getItemFromBlock(DrinkGlassBlock.block)).setRegistryName("glass_mead"));
		elements.items.add(() -> new BasePlaceableDrinkItem(glass_red_wine,
				new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.red_wine), 0, false,
				Item.getItemFromBlock(DrinkGlassBlock.block)).setRegistryName("glass_red_wine"));
		elements.items.add(
				() -> new BasePlaceableDrinkItem(glass_perry, new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.perry), 0,
						false, Item.getItemFromBlock(DrinkGlassBlock.block)).setRegistryName("glass_perry"));
		elements.items.add(() -> new BasePlaceableDrinkItem(glass_cherry_liqueur,
				new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.cherry_liqueur), 0, false,
				Item.getItemFromBlock(DrinkGlassBlock.block)).setRegistryName("glass_cherry_liqueur"));
		elements.items
				.add(() -> new BasePlaceableDrinkItem(glass_rum, new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.rum),
						0, false, Item.getItemFromBlock(DrinkGlassBlock.block)).setRegistryName("glass_rum"));
		elements.items.add(
				() -> new BasePlaceableDrinkItem(glass_vodka, new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.vodka), 0,
						false, Item.getItemFromBlock(DrinkGlassBlock.block)).setRegistryName("glass_vodka"));
		elements.items.add(() -> new BasePlaceableDrinkItem(glass_maple_beer,
				new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.maple_beer), 0, false,
				Item.getItemFromBlock(DrinkGlassBlock.block)).setRegistryName("glass_maple_beer"));
		elements.items
				.add(() -> new BasePlaceableDrinkItem(glass_arak, new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.arak),
						0, false, Item.getItemFromBlock(DrinkGlassBlock.block)).setRegistryName("glass_arak"));
		// miruvor
		elements.items.add(() -> new BasePlaceableDrinkItem(glass_miruvor,
				new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.miruvor), 0, false,
				Item.getItemFromBlock(DrinkGlassBlock.block)).setRegistryName("glass_miruvor"));
		elements.items.add(() -> new BasePlaceableDrinkItem(glass_miruvor1,
				new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.miruvor1), 0, false,
				Item.getItemFromBlock(DrinkGlassBlock.block)).setRegistryName("glass_miruvor1"));
		elements.items.add(() -> new BasePlaceableDrinkItem(glass_miruvor2,
				new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.miruvor2), 0, false,
				Item.getItemFromBlock(DrinkGlassBlock.block)).setRegistryName("glass_miruvor2"));
		elements.items.add(() -> new BasePlaceableDrinkItem(glass_miruvor3,
				new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.miruvor3), 0, false,
				Item.getItemFromBlock(DrinkGlassBlock.block)).setRegistryName("glass_miruvor3"));
		elements.items.add(() -> new BasePlaceableDrinkItem(glass_miruvor4,
				new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.miruvor4), 0, false,
				Item.getItemFromBlock(DrinkGlassBlock.block)).setRegistryName("glass_miruvor4"));
		// orc draught
		elements.items.add(() -> new BasePlaceableDrinkItem(glass_orc_draught,
				new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.orc_draught), 0, false,
				Item.getItemFromBlock(DrinkGlassBlock.block)).setRegistryName("glass_orc_draught"));
		elements.items.add(() -> new BasePlaceableDrinkItem(glass_orc_draught1,
				new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.orc_draught1), 0, false,
				Item.getItemFromBlock(DrinkGlassBlock.block)).setRegistryName("glass_orc_draught1"));
		elements.items.add(() -> new BasePlaceableDrinkItem(glass_orc_draught2,
				new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.orc_draught2), 0, false,
				Item.getItemFromBlock(DrinkGlassBlock.block)).setRegistryName("glass_orc_draught2"));
		elements.items.add(() -> new BasePlaceableDrinkItem(glass_orc_draught3,
				new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.orc_draught3), 0, false,
				Item.getItemFromBlock(DrinkGlassBlock.block)).setRegistryName("glass_orc_draught3"));
		elements.items.add(() -> new BasePlaceableDrinkItem(glass_orc_draught4,
				new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.orc_draught4), 0, false,
				Item.getItemFromBlock(DrinkGlassBlock.block)).setRegistryName("glass_orc_draught4"));
		// athelas brew
		elements.items.add(() -> new BasePlaceableDrinkItem(glass_athelas_brew,
				new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.athelas_brew), 0, false,
				Item.getItemFromBlock(DrinkGlassBlock.block)).setRegistryName("glass_athelas_brew"));
		elements.items.add(() -> new BasePlaceableDrinkItem(glass_athelas_brew1,
				new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.athelas_brew1), 0, false,
				Item.getItemFromBlock(DrinkGlassBlock.block)).setRegistryName("glass_athelas_brew1"));
		elements.items.add(() -> new BasePlaceableDrinkItem(glass_athelas_brew2,
				new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.athelas_brew2), 0, false,
				Item.getItemFromBlock(DrinkGlassBlock.block)).setRegistryName("glass_athelas_brew2"));
		elements.items.add(() -> new BasePlaceableDrinkItem(glass_athelas_brew3,
				new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.athelas_brew3), 0, false,
				Item.getItemFromBlock(DrinkGlassBlock.block)).setRegistryName("glass_athelas_brew3"));
		elements.items.add(() -> new BasePlaceableDrinkItem(glass_athelas_brew4,
				new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.athelas_brew4), 0, false,
				Item.getItemFromBlock(DrinkGlassBlock.block)).setRegistryName("glass_athelas_brew4"));
		// dwarven tonic
		elements.items.add(() -> new BasePlaceableDrinkItem(glass_dwarven_tonic,
				new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.dwarven_tonic), 0, false,
				Item.getItemFromBlock(DrinkGlassBlock.block)).setRegistryName("glass_dwarven_tonic"));
		elements.items.add(() -> new BasePlaceableDrinkItem(glass_dwarven_tonic1,
				new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.dwarven_tonic1), 0, false,
				Item.getItemFromBlock(DrinkGlassBlock.block)).setRegistryName("glass_dwarven_tonic1"));
		elements.items.add(() -> new BasePlaceableDrinkItem(glass_dwarven_tonic2,
				new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.dwarven_tonic2), 0, false,
				Item.getItemFromBlock(DrinkGlassBlock.block)).setRegistryName("glass_dwarven_tonic2"));
		elements.items.add(() -> new BasePlaceableDrinkItem(glass_dwarven_tonic3,
				new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.dwarven_tonic3), 0, false,
				Item.getItemFromBlock(DrinkGlassBlock.block)).setRegistryName("glass_dwarven_tonic3"));
		elements.items.add(() -> new BasePlaceableDrinkItem(glass_dwarven_tonic4,
				new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.dwarven_tonic4), 0, false,
				Item.getItemFromBlock(DrinkGlassBlock.block)).setRegistryName("glass_dwarven_tonic4"));
		// taurethrim cocoa
		elements.items.add(() -> new BasePlaceableDrinkItem(glass_taurethrim_cocoa,
				new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.taurethrim_cocoa), 0, false,
				Item.getItemFromBlock(DrinkGlassBlock.block)).setRegistryName("glass_taurethrim_cocoa"));
		elements.items.add(() -> new BasePlaceableDrinkItem(glass_taurethrim_cocoa1,
				new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.taurethrim_cocoa1), 0, false,
				Item.getItemFromBlock(DrinkGlassBlock.block)).setRegistryName("glass_taurethrim_cocoa1"));
		elements.items.add(() -> new BasePlaceableDrinkItem(glass_taurethrim_cocoa2,
				new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.taurethrim_cocoa2), 0, false,
				Item.getItemFromBlock(DrinkGlassBlock.block)).setRegistryName("glass_taurethrim_cocoa2"));
		elements.items.add(() -> new BasePlaceableDrinkItem(glass_taurethrim_cocoa3,
				new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.taurethrim_cocoa3), 0, false,
				Item.getItemFromBlock(DrinkGlassBlock.block)).setRegistryName("glass_taurethrim_cocoa3"));
		elements.items.add(() -> new BasePlaceableDrinkItem(glass_taurethrim_cocoa4,
				new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(LOTRDrinks.taurethrim_cocoa4), 0, false,
				Item.getItemFromBlock(DrinkGlassBlock.block)).setRegistryName("glass_taurethrim_cocoa4"));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(glass_water, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(glass_milk, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(glass_chocolate, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(glass_mango_juice, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(glass_blueberry_juice, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(glass_blackberry_juice, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(glass_rasberry_juice, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(glass_cranberry_juice, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(glass_elderberry_juice, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(glass_orange_juice, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(glass_lemonade, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(glass_jungle_remedy, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(glass_apple_juice, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(glass_red_grape_juice, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(glass_green_grape_juice, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(glass_pomegranate_juice, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(glass_ale, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(glass_mead, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(glass_red_wine, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(glass_perry, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(glass_cherry_liqueur, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(glass_rum, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(glass_vodka, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(glass_maple_beer, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(glass_arak, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(glass_miruvor, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(glass_miruvor1, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(glass_miruvor2, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(glass_miruvor3, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(glass_miruvor4, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(glass_orc_draught, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(glass_orc_draught1, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(glass_orc_draught2, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(glass_orc_draught3, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(glass_orc_draught4, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(glass_athelas_brew, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(glass_athelas_brew1, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(glass_athelas_brew2, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(glass_athelas_brew3, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(glass_athelas_brew4, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(glass_dwarven_tonic, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(glass_dwarven_tonic1, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(glass_dwarven_tonic2, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(glass_dwarven_tonic3, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(glass_dwarven_tonic4, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(glass_taurethrim_cocoa, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(glass_taurethrim_cocoa1, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(glass_taurethrim_cocoa2, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(glass_taurethrim_cocoa3, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(glass_taurethrim_cocoa4, RenderType.getTranslucent());
	}
	public static class CustomBlock extends BaseCupBlock {
		public CustomBlock() {
			super(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1f, 10f).lightValue(0).notSolid());
		}

		@Override
		public BlockState TurnsInto() {
			return DrinkGlassBlock.block.getDefaultState();
		}

		@Override
		public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return false;
		}

		@Override
		public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
			return true;
		}

		@Override
		public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
			return Block.makeCuboidShape(5.5D, 0.0D, 5.5D, 10.5D, 9.0D, 10.5D);
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