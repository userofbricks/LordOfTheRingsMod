package net.mcreator.lord_of_the_rings_mod_util.registry;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import com.google.common.collect.ArrayListMultimap;
import com.teamabnormals.abnormals_core.core.utils.RegistryHelper;

import net.mcreator.lord_of_the_rings_mod.LordOfTheRingsModMod;
import net.mcreator.lord_of_the_rings_mod.itemgroup.LOTRFoodAndDrinkTabItemGroup;
import net.mcreator.lord_of_the_rings_mod_util.bases.BasePlaceableDrinkItem;
import net.minecraft.block.Block;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.GameData;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class LOTRRegistryHelper extends RegistryHelper {
	public LOTRRegistryHelper(String modId) {
		super(modId);
	}

	@SuppressWarnings("deprecation")
	public <B extends Block> RegistryObject<B> createDrinkBlock(String name, Supplier<? extends B> supplier, Food food, int damage, boolean isMilk,
			Block turnsInto) {
		RegistryObject<B> block = this.getDeferredBlockRegister().register(name, supplier);
		this.getDeferredItemRegister().register(name, () -> new BasePlaceableDrinkItem(block.get(),
				new Item.Properties().group(LOTRFoodAndDrinkTabItemGroup.tab).food(food), damage, isMilk, Item.getItemFromBlock(turnsInto)));
		return block;
	}
	
	/*
	 * below is for override registry
	 */
	private static final Map<String, ModData> modData = new HashMap<>();
	
	private static ModData getCurrentModData() {
		return getModData(ModLoadingContext.get().getActiveNamespace());
	}
	
	private static ModData getModData(String modid) {
		ModData data = modData.get(modid);
		if(data == null) {
			data = new ModData();
			modData.put(modid, data);
			
			FMLJavaModLoadingContext.get().getModEventBus().addListener(LOTRRegistryHelper::onRegistryEvent);
		}
		
		return data;
	}

	public static <T extends IForgeRegistryEntry<T>> void register(IForgeRegistryEntry<T> obj, String resloc) {
		if(obj == null)
			throw new IllegalArgumentException("Can't register null object.");

		obj.setRegistryName(GameData.checkPrefix(resloc, false));
		getCurrentModData().defers.put(obj.getRegistryType(), () -> obj);
	}

	public static <T extends IForgeRegistryEntry<T>> void register(IForgeRegistryEntry<T> obj) {
		if(obj == null)
			throw new IllegalArgumentException("Can't register null object.");
		if(obj.getRegistryName() == null)
			throw new IllegalArgumentException("Can't register object without registry name.");

		getCurrentModData().defers.put(obj.getRegistryType(), () -> obj);
	}

	public static void onRegistryEvent(RegistryEvent.Register<?> event) {
		getCurrentModData().register(event.getRegistry());
	}
	
	private static class ModData {

		private ArrayListMultimap<Class<?>, Supplier<IForgeRegistryEntry<?>>> defers = ArrayListMultimap.create();
		
		@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
		private void register(IForgeRegistry registry) {
			Class<?> type = registry.getRegistrySuperType();

			if(defers.containsKey(type)) {
				Collection<Supplier<IForgeRegistryEntry<?>>> ourEntries = defers.get(type);
				for(Supplier<IForgeRegistryEntry<?>> supplier : ourEntries) {
					IForgeRegistryEntry<?> entry = supplier.get();
					registry.register(entry);
					LordOfTheRingsModMod.LOGGER.debug("Registering to " + registry.getRegistryName() + " - " + entry.getRegistryName());
				}

				defers.removeAll(type);
			}
		}	
	}
}
