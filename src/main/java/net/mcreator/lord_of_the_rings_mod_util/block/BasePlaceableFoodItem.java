package net.mcreator.lord_of_the_rings_mod_util.block;

import net.minecraftforge.common.property.Properties;

import net.minecraft.world.World;
import net.minecraft.util.DamageSource;
import net.minecraft.stats.Stats;
import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.BlockItem;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.block.Block;
import net.minecraft.advancements.CriteriaTriggers;

public class BasePlaceableFoodItem extends BlockItem {
	private final float damage;
	private final boolean milk;
	public BasePlaceableFoodItem(Block blockIn, Properties properties, float damageIn, boolean milkIn) {
		super(blockIn, properties);
		this.damage = damageIn;
		this.milk = milkIn;
	}

	/*
	 * Returns the unlocalized name of this item.
	 */
	// public String getTranslationKey() {
	// return this.getDefaultTranslationKey();
	// }
	/*
	 * returns the action that specifies what animation to play when the items is
	 * being used
	 */
	@Override
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.EAT;
	}

	/*
	 * Called when the player finishes using this Item (E.g. finishes eating.). Not
	 * called when the player stops using the Item before the action is complete.
	 */
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
		PlayerEntity playerEntity = entityLiving instanceof PlayerEntity ? (PlayerEntity) entityLiving : null;
		if (!worldIn.isRemote)
			entityLiving.curePotionEffects(stack);
		if (damage >= 1) {
			entityLiving.attackEntityFrom(DamageSource.MAGIC, damage);
		}
		if (milk == true) {
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
		return this.isFood() ? entityLiving.onFoodEaten(worldIn, stack) : stack;
	}

	public float getDamage() {
		return this.damage;
	}

	public boolean getMilk() {
		return this.milk;
	}
}