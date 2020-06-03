package net.mcreator.lord_of_the_rings_mod_util.registry;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;

import net.mcreator.lord_of_the_rings_mod.LordOfTheRingsModMod;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.registries.ForgeRegistryEntry;
import net.minecraftforge.registries.GameData;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class OverrideRegistryHandler {
	
	public static void registerBlock(Block block, String baseName) {
		register(block, Blocks.class, baseName);
	}

	public static void registerItem(Item item, String baseName) {
		register(item, Items.class, baseName);
	}

	public static void registerBiome(Biome item, String baseName) {
		register(item, Biomes.class, baseName);
	}

	public static <T extends ForgeRegistryEntry<T>> void register(T obj, Class<?> registryType, String baseName) {
		ResourceLocation regName = new ResourceLocation("minecraft", baseName);
		try {
			Field field = ForgeRegistryEntry.class.getDeclaredField("registryName");
			field.setAccessible(true);
			field.set(obj, regName);
		} catch (IllegalAccessException | NoSuchFieldException e) {
			obj.setRegistryName(regName);
		}

		LOTRRegistryHelper.register(obj);

		for (Field declared : registryType.getDeclaredFields()) {
			if (Modifier.isStatic(declared.getModifiers()) && obj.getClass().isAssignableFrom(declared.getType())) {
				try {
					@SuppressWarnings("rawtypes")
					IForgeRegistryEntry fieldVal = (IForgeRegistryEntry) declared.get(null);
					if (regName.equals(fieldVal.getRegistryName())) {
						if (obj instanceof Block && fieldVal instanceof Block) {
							Map<Block, Item> itemMap = GameData.getBlockItemMap();
							itemMap.put((Block) obj, itemMap.get(fieldVal));
						} else if (obj instanceof BlockItem) {
							Map<Block, Item> itemMap = GameData.getBlockItemMap();
							itemMap.put(((BlockItem) obj).getBlock(), (Item) obj);
						}

						editFinalField(declared, null, obj);
					}
				} catch (IllegalAccessException e) {
					LordOfTheRingsModMod.LOGGER.warn("Was unable to replace registry entry for " + regName + ", may cause issues", e);
				}
			}
		}
	}

	public static <T> void editFinalField(Field f, Object obj, T value) {
		try {
			f.setAccessible(true);
			
			Field modifiers = Field.class.getDeclaredField("modifiers");
			modifiers.setAccessible(true);
			modifiers.setInt(f, f.getModifiers() & ~Modifier.FINAL);
			
			f.set(obj, value);
		} catch(ReflectiveOperationException e) {
			throw new RuntimeException(e);
		}
	}
}
