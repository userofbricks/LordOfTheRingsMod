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

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.lord_of_the_rings_mod_util.registry.LOTRRegistryHelper;
import net.mcreator.lord_of_the_rings_mod_util.block.BaseCupBlock;
import net.mcreator.lord_of_the_rings_mod_util.LOTRDrinks;
import net.mcreator.lord_of_the_rings_mod.block.DrinkGlassBlock;

import java.util.List;
import java.util.Collections;

//@ObjectHolder("lord_of_the_rings_mod")
@Mod.EventBusSubscriber(modid = "lord_of_the_rings_mod", bus = Bus.MOD)
@LordOfTheRingsModModElements.ModElement.Tag
public class DrinkInGlass extends LordOfTheRingsModModElements.ModElement {
	public DrinkInGlass(LordOfTheRingsModModElements instance) {
		super(instance, 1000000);
	}
	public static final LOTRRegistryHelper HELPER = LordOfTheRingsModMod.REGISTRY_HELPER;
	public static final String type = "glass_";
	public static final Block turnsInto = DrinkGlassBlock.block;
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
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(water.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(milk.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(chocolate.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(mango_juice.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(blueberry_juice.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(blackberry_juice.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(rasberry_juice.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(cranberry_juice.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(elderberry_juice.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(orange_juice.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(lemonade.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(jungle_remedy.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(apple_juice.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(red_grape_juice.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(green_grape_juice.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(pomegranate_juice.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(ale.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(mead.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(red_wine.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(cider.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(perry.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(cherry_liqueur.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(rum.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(vodka.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(maple_beer.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(arak.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(miruvor.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(miruvor1.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(miruvor2.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(miruvor3.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(miruvor4.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(orc_draught.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(orc_draught1.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(orc_draught2.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(orc_draught3.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(orc_draught4.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(athelas_brew.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(athelas_brew1.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(athelas_brew2.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(athelas_brew3.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(athelas_brew4.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(dwarven_tonic.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(dwarven_tonic1.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(dwarven_tonic2.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(dwarven_tonic3.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(dwarven_tonic4.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(taurethrim_cocoa.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(taurethrim_cocoa1.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(taurethrim_cocoa2.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(taurethrim_cocoa3.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(taurethrim_cocoa4.get(), RenderType.getTranslucent());
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
