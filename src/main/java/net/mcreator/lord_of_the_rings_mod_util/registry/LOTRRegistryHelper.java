package net.mcreator.lord_of_the_rings_mod_util.registry;

import com.teamabnormals.abnormals_core.core.utils.RegistryHelper;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;

public class LOTRRegistryHelper extends RegistryHelper {

	public LOTRRegistryHelper(String modId) {
		super(modId);
	}

	public <B extends Block> RegistryObject<B> createDrinks(String nameType, Supplier<? extends B> supplier, Block turnsInto) {
		RegistryObject<B> block = this.getDeferredBlockRegister().register(nameType, supplier);
		RegistryObject<B> water = null;
		RegistryObject<B> milk = null;
		RegistryObject<B> chocolate = null;
		RegistryObject<B> mango_juice = null;
		RegistryObject<B> blueberry_juice = null;
		RegistryObject<B> blackberry_juice = null;
		RegistryObject<B> rasberry_juice = null;
		RegistryObject<B> cranberry_juice = null;
		RegistryObject<B> elderberry_juice = null;
		RegistryObject<B> orange_juice = null;
		RegistryObject<B> lemonade = null;
		RegistryObject<B> jungle_remedy = null; // similar to milk
		RegistryObject<B> apple_juice = null;
		RegistryObject<B> red_grape_juice = null;
		RegistryObject<B> green_grape_juice = null;
		RegistryObject<B> pomegranate_juice = null;
		// alcohol
		RegistryObject<B> ale = null;
		RegistryObject<B> mead = null;
		RegistryObject<B> red_wine = null;
		RegistryObject<B> perry = null;
		RegistryObject<B> cherry_liqueur = null;
		RegistryObject<B> rum = null;
		RegistryObject<B> vodka = null;
		RegistryObject<B> maple_beer = null;
		RegistryObject<B> arak = null;
		// miruvor
		RegistryObject<B> miruvor = null;
		RegistryObject<B> miruvor1 = null;
		RegistryObject<B> miruvor2 = null;
		RegistryObject<B> miruvor3 = null;
		RegistryObject<B> miruvor4 = null;
		// orc draught
		RegistryObject<B> orc_draught = null;
		RegistryObject<B> orc_draught1 = null;
		RegistryObject<B> orc_draught2 = null;
		RegistryObject<B> orc_draught3 = null;
		RegistryObject<B> orc_draught4 = null;
		// athelas brew
		RegistryObject<B> athelas_brew = null;
		RegistryObject<B> athelas_brew1 = null;
		RegistryObject<B> athelas_brew2 = null;
		RegistryObject<B> athelas_brew3 = null;
		RegistryObject<B> athelas_brew4 = null;
		// dwarven tonic
		RegistryObject<B> dwarven_tonic = null;
		RegistryObject<B> dwarven_tonic1 = null;
		RegistryObject<B> dwarven_tonic2 = null;
		RegistryObject<B> dwarven_tonic3 = null;
		RegistryObject<B> dwarven_tonic4 = null;
		// taurethrim cocoa
		RegistryObject<B> taurethrim_cocoa = null;
		RegistryObject<B> taurethrim_cocoa1 = null;
		RegistryObject<B> taurethrim_cocoa2 = null;
		RegistryObject<B> taurethrim_cocoa3 = null;
		RegistryObject<B> taurethrim_cocoa4 = null;
	}
	
}
