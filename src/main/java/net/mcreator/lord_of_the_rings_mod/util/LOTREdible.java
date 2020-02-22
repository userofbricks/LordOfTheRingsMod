package net.mcreator.lord_of_the_rings_mod.util;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class LOTREdible {
	public static class LOTRFoods {
		public static final Food LEMBAS = 				(new Food.Builder())	.hunger(20)	.saturation(2.0F)			.build();
		public static final Food GAMMON = 				(new Food.Builder())	.hunger(8)	.saturation(1.3F)			.build();
		public static final Food FRUIT_LARGE = 			(new Food.Builder())	.hunger(4)	.saturation(0.3F)			.build();
		public static final Food FRUIT_SMALL = 			(new Food.Builder())	.hunger(2)	.saturation(0.15F)			.build();
		public static final Food NUT = 					(new Food.Builder())	.hunger(2)	.saturation(0.4F)			.build();
		public static final Food BREAD1 = 				(new Food.Builder())	.hunger(4)	.saturation(0.4F)			.build();
		public static final Food BREAD2 = 				(new Food.Builder())	.hunger(5)	.saturation(0.6F)			.build();
		public static final Food HOBBIT_PANCAKE = 		(new Food.Builder())	.hunger(4)	.saturation(0.5F)			.build();
		public static final Food HOBBIT_PANCAKE_SYRUP = (new Food.Builder())	.hunger(5)	.saturation(0.6F)			.build();
		public static final Food RAW_MEAT = 			(new Food.Builder())	.hunger(3)	.saturation(0.1F)	.meat()	.build();
		public static final Food COOKED_MEAT2 = 		(new Food.Builder())	.hunger(8)	.saturation(1.3F)	.meat()	.build();
		public static final Food COOKED_MEAT1 = 		(new Food.Builder())	.hunger(6)	.saturation(0.7F)	.meat()	.build();
		public static final Food MEAT = 				(new Food.Builder())	.hunger(6)	.saturation(0.7F)	.meat()	.build();
		public static final Food SYRUP = 				(new Food.Builder())	.hunger(2)	.saturation(0.04F)			.build();
		public static final Food SOUP_STEW = 			(new Food.Builder())	.hunger(8)	.saturation(1.0F)			.build();
		public static final Food MELLON_SOUP = 			(new Food.Builder())	.hunger(5)	.saturation(0.5F)			.build();
		public static final Food CRAM = 				(new Food.Builder())	.hunger(8)	.saturation(1.6F)			.build();
		public static final Food VEGI = 				(new Food.Builder())	.hunger(2)	.saturation(0.1F)			.build();
		public static final Food VEGI_COOKED = 			(new Food.Builder())	.hunger(4)	.saturation(0.3F)			.build();
		public static final Food MARCHPANE = 			(new Food.Builder())	.hunger(6)	.saturation(0.7F)			.build();
		public static final Food MARCHPANE_CHOCOLATE = 	(new Food.Builder())	.hunger(8)	.saturation(1.3F)			.build();
		public static final Food MUSHROOM_PIE = 		(new Food.Builder())	.hunger(8)	.saturation(0.0F)			.build();
	}

	public static class LOTRDrinks {
		public static final Food water = 				(new Food.Builder())	.hunger(0)	.saturation(0.0F)	.setAlwaysEdible()	.build();
		public static final Food maple_syrup = 			(new Food.Builder())	.hunger(2)	.saturation(0.04F)						.build();
		public static final Food milk = 				(new Food.Builder())	.hunger(1)	.saturation(0.04F)	.setAlwaysEdible()	.build();
		public static final Food chocolate = 			(new Food.Builder())	.hunger(6)	.saturation(0.72F)						.build();
		public static final Food juice = 				(new Food.Builder())	.hunger(6)	.saturation(0.72F)	.setAlwaysEdible()	.build(); //apple, mango, orange
		public static final Food juice_berry = 			(new Food.Builder())	.hunger(5)	.saturation(0.5F)	.setAlwaysEdible()	.build(); //berry, grape, lemonade, pomegranate
		public static final Food ent_draught_green = 	(new Food.Builder())	.hunger(0)	.saturation(0.0F)	.setAlwaysEdible()	.effect(new EffectInstance(Effects.SPEED, 2400, 0), 1.0F)	.effect(new EffectInstance(Effects.HASTE, 2400, 0), 1.0F)	.effect(new EffectInstance(Effects.STRENGTH, 2400, 0), 1.0F)	.build();
		public static final Food ent_draught_brown = 	(new Food.Builder())	.hunger(20)	.saturation(2.0F)	.setAlwaysEdible()	.build();
		public static final Food ent_draught_golden = 	(new Food.Builder())	.hunger(0)	.saturation(0.0F)	.setAlwaysEdible()	.build();
		public static final Food ent_draught_yellow = 	(new Food.Builder())	.hunger(0)	.saturation(0.0F)	.setAlwaysEdible()	.effect(new EffectInstance(Effects.REGENERATION, 1200, 255), 1.0F)	.build();
		public static final Food ent_draught_red = 		(new Food.Builder())	.hunger(0)	.saturation(0.0F)	.setAlwaysEdible()	.effect(new EffectInstance(Effects.FIRE_RESISTANCE, 3600, 255), 1.0F)	.build();
		public static final Food ent_draught_silver = 	(new Food.Builder())	.hunger(0)	.saturation(0.0F)	.setAlwaysEdible()	.effect(new EffectInstance(Effects.NIGHT_VISION, 3600, 255), 1.0F)	.build();
		public static final Food ent_draught_blue = 	(new Food.Builder())	.hunger(0)	.saturation(0.0F)	.setAlwaysEdible()	.effect(new EffectInstance(Effects.WATER_BREATHING, 3600, 0), 1.0F)	.build();
		
		public static final Food ale = 					buildAlcohol(3, 	3, 	0.3F);
		public static final Food mead = 				buildAlcohol(6, 	4, 	0.5F);
		public static final Food red_wine = 			buildAlcohol(10, 	4, 	0.32F);
		public static final Food white_wine = 			buildAlcohol(9, 	4, 	0.32F);
		public static final Food cider = 				buildAlcohol(3, 	4, 	0.32F);
		public static final Food perry = 				buildAlcohol(3, 	4, 	0.32F);
		public static final Food cherry_liqueur = 		buildAlcohol(10, 	3, 	0.18F);
		public static final Food rum = 					buildAlcohol(15, 	3, 	0.18F);
		public static final Food dwarven_ale = 			buildAlcohol(4, 	3, 	0.18F);
		public static final Food vodka = 				buildAlcohol(18, 	3, 	0.18F);
		public static final Food maple_beer = 			buildAlcohol(4, 	4, 	0.48F);
		public static final Food arak = 				buildAlcohol(14, 	4, 	0.32F);
		public static final Food carrot_wine = 			buildAlcohol(8, 	3, 	0.24F);
		public static final Food bannana_beer = 		buildAlcohol(5, 	4, 	0.0F);
		public static final Food melon_liqueur = 		buildAlcohol(10, 	3, 	0.18F);
		public static final Food cactus_liqueur = 		buildAlcohol(8, 	2, 	0.0F);
		public static final Food lemon_liqueur = 		buildAlcohol(10, 	3, 	0.18F);
		public static final Food lime_liqueur = 		buildAlcohol(10, 	3, 	0.18F);
		public static final Food corn_liqueur = 		buildAlcohol(10, 	3, 	0.18F);
		public static final Food plum_kvass = 			buildAlcohol(2, 	4, 	0.32F);
		public static final Food termite_tequila = 		buildAlcohol(15, 	3, 	0.18F);
		public static final Food soured_milk = 			buildAlcohol(2, 	4, 	0.5F);
		public static final Food pomegranate_wine = 	buildAlcohol(9, 	4, 	0.32F);

		public static final Food miruvor = 		buildStrengthSpeed(10, 	0);
		public static final Food miruvor1 = 	buildStrengthSpeed(20, 	0);
		public static final Food miruvor2 = 	buildStrengthSpeed(40, 	0);
		public static final Food miruvor3 = 	buildStrengthSpeed(20, 	1);
		public static final Food miruvor4 = 	buildStrengthSpeed(0, 	2);

		public static final Food orc_draught = 		buildStrengthSpeed(15, 	0);
		public static final Food orc_draught1 = 	buildStrengthSpeed(30, 	0);
		public static final Food orc_draught2 = 	buildStrengthSpeed(0, 	1);
		public static final Food orc_draught3 = 	buildStrengthSpeed(0, 	2);
		public static final Food orc_draught4 = 	buildStrengthSpeed(0, 	3);

		public static final Food athelas_brew = 	buildAthens(15, 0);
		public static final Food athelas_brew1 = 	buildAthens(30, 0);
		public static final Food athelas_brew2 = 	buildAthens(0, 	1);
		public static final Food athelas_brew3 = 	buildAthens(0, 	2);
		public static final Food athelas_brew4 = 	buildAthens(0, 	3);

		public static final Food dwarven_tonic = 	buildDwarvenTonic(0, 15, 	0);
		public static final Food dwarven_tonic1 = 	buildDwarvenTonic(1, 30, 	0);
		public static final Food dwarven_tonic2 = 	buildDwarvenTonic(2, 0, 	1);
		public static final Food dwarven_tonic3 = 	buildDwarvenTonic(4, 0, 	2);
		public static final Food dwarven_tonic4 = 	buildDwarvenTonic(6, 0, 	3);

		public static final Food torog_draught = 	buildTorogDraught(1, 22, 	0);
		public static final Food torog_draught1 = 	buildTorogDraught(3, 45, 	0);
		public static final Food torog_draught2 = 	buildTorogDraught(6, 30, 	1);
		public static final Food torog_draught3 = 	buildTorogDraught(12, 0, 	3);
		public static final Food torog_draught4 = 	buildTorogDraught(18, 30, 	4);

		public static final Food taurethrim_cocoa = 	buildStrengthSpeed(10, 	0);
		public static final Food taurethrim_cocoa1 = 	buildStrengthSpeed(20, 	0);
		public static final Food taurethrim_cocoa2 = 	buildStrengthSpeed(40, 	0);
		public static final Food taurethrim_cocoa3 = 	buildStrengthSpeed(20, 	1);
		public static final Food taurethrim_cocoa4 = 	buildStrengthSpeed(0, 	2);

		public static final Food morgul_draught = 	buildMorgulDraught(22, 	0);
		public static final Food morgul_draught1 = 	buildMorgulDraught(45, 	0);
		public static final Food morgul_draught2 = 	buildMorgulDraught(30, 	1);
		public static final Food morgul_draught3 = 	buildMorgulDraught(0, 	3);
		public static final Food morgul_draught4 = 	buildMorgulDraught(30, 	4);
		
		private static Food buildAlcohol(int numIn, int hunger, float saturation) {
			return (new Food.Builder()).hunger(hunger).saturation(saturation).setAlwaysEdible().effect(new EffectInstance(Effects.NAUSEA, numIn * 100, 255), (float)numIn / 100F).build();
		}
		private static Food buildStrengthSpeed(int seconds, int minuets) {
			return (new Food.Builder()).hunger(10).saturation(1.0f).setAlwaysEdible().effect(new EffectInstance(Effects.STRENGTH, (minuets * 60 * 20) + (seconds * 20), 0), 1.0F).effect(new EffectInstance(Effects.SPEED, (minuets * 60 * 20) + (seconds * 20), 0), 1.0F).build();
		}
		private static Food buildAthens(int seconds, int minuets) {
			return (new Food.Builder()).hunger(10).saturation(1.0f).setAlwaysEdible().effect(new EffectInstance(Effects.STRENGTH, (minuets * 60 * 20 * 2) + (seconds * 20 * 2), 0), 1.0F).effect(new EffectInstance(Effects.REGENERATION, (minuets * 60 * 20) + (seconds * 20), 0), 1.0F).build();
		}
		private static Food buildDwarvenTonic(int numIn, int seconds, int minuets) {
			return (new Food.Builder()).hunger(6).saturation(0.6f).setAlwaysEdible().effect(new EffectInstance(Effects.NIGHT_VISION, (minuets * 60 * 20) + (seconds * 20), 0), 1.0F).effect(new EffectInstance(Effects.NAUSEA, numIn * 100, 255), (float)numIn / 100F).build();
		}
		private static Food buildMorgulDraught(int seconds, int minuets) {
			return (new Food.Builder()).hunger(6).saturation(0.6f).setAlwaysEdible().effect(new EffectInstance(Effects.NIGHT_VISION, (minuets * 60 * 20) + (seconds * 20), 0), 1.0F).build();
		}
		private static Food buildTorogDraught(int numIn, int seconds, int minuets) {
			return (new Food.Builder()).hunger(6).saturation(0.6f).setAlwaysEdible().effect(new EffectInstance(Effects.STRENGTH, (minuets * 60 * 20) + (seconds * 20), 0), 1.0F).effect(new EffectInstance(Effects.NAUSEA, numIn * 100, 255), (float)numIn / 100F).build();
		}
	}

}
