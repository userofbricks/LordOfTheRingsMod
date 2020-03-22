package net.mcreator.lord_of_the_rings_mod.block;

import net.minecraftforge.common.property.Properties;

import net.minecraft.world.World;
import net.minecraft.util.DamageSource;
import net.minecraft.stats.Stats;
import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.block.Block;
import net.minecraft.advancements.CriteriaTriggers;

public class BasePlaceableDrinkItem extends BasePlaceableFoodItem {
	private final Item item;
	public BasePlaceableDrinkItem(Block blockIn, Properties properties, float damageIn, boolean milkIn, Item itemIn) {
		super(blockIn, properties, damageIn, milkIn);
		this.item = itemIn;
	}

	/*
	 * returns the action that specifies what animation to play when the items is
	 * being used
	 */
	@Override
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.DRINK;
	}

	/*
	 * Called when the player finishes using this Item (E.g. finishes eating.). Not
	 * called when the player stops using the Item before the action is complete.
	 */
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
		PlayerEntity playerEntity = entityLiving instanceof PlayerEntity ? (PlayerEntity) entityLiving : null;
		if (!worldIn.isRemote) {
			entityLiving.curePotionEffects(stack);
		}
		if (this.getDamage() >= 1) {
			entityLiving.attackEntityFrom(DamageSource.MAGIC, this.getDamage());
		}
		if (this.getMilk() == true) {
			if (!worldIn.isRemote) {
				entityLiving.clearActivePotions();
			}
		}
		if (playerEntity instanceof ServerPlayerEntity) {
			CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayerEntity) playerEntity, stack);
		}
		if (playerEntity != null) {
			playerEntity.addStat(Stats.ITEM_USED.get(this));
		}
		if (playerEntity == null || !playerEntity.abilities.isCreativeMode) {
			if (stack.isEmpty()) {
				return new ItemStack(item);
			}
			if (playerEntity != null) {
				playerEntity.inventory.addItemStackToInventory(new ItemStack(item));
			}
		}
		return this.isFood() ? entityLiving.onFoodEaten(worldIn, stack) : stack;
	}
}
