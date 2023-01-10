package net.brdle.collectorsreap.common.world;

import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.common.block.CRBlocks;
import net.brdle.collectorsreap.common.config.CRConfig;
import net.brdle.collectorsreap.data.CRBlockTags;
import net.minecraft.core.Holder;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.RandomPatchFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.*;
import vectorwing.farmersdelight.common.registry.ModBiomeFeatures;
import vectorwing.farmersdelight.common.world.WildCropGeneration;
import vectorwing.farmersdelight.common.world.configuration.WildCropConfiguration;
import java.util.List;

public class CRWorldGen extends WildCropGeneration {
	public static Holder<ConfiguredFeature<WildCropConfiguration, ?>> FEATURE_PATCH_PORTOBELLO;
	public static Holder<PlacedFeature> PATCH_PORTOBELLO;
	public static Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> FEATURE_LEMON_BUSH;
	public static Holder<PlacedFeature> LEMON_BUSH;


	private static Holder<PlacedFeature> registerPlacement(ResourceLocation id, Holder<? extends ConfiguredFeature<?, ?>> feature, PlacementModifier... modifiers) {
		return BuiltinRegistries.register(BuiltinRegistries.PLACED_FEATURE, id, new PlacedFeature(Holder.hackyErase(feature), List.of(modifiers)));
	}

	private static Holder<PlacedFeature> registerConditionalPlacement(ResourceLocation id, Holder<? extends ConfiguredFeature<?, ?>> feature, boolean condition, PlacementModifier... modifiers) {
		return condition ? registerPlacement(id, feature, modifiers) : registerPlacement(id, feature, BlockPredicateFilter.forPredicate(BlockPredicate.not(BlockPredicate.alwaysTrue())));
	}

	public static void registerGeneration() {
		FEATURE_PATCH_PORTOBELLO = register(Util.rl(CollectorsReap.MODID, "patch_portobello"),
			ModBiomeFeatures.WILD_CROP.get(), mushroomColonyConfig(CRBlocks.PORTOBELLO_COLONY.get(), CRBlocks.PORTOBELLO.get(), BlockPredicate.matchesTag(BLOCK_BELOW, CRBlockTags.PORTOBELLO_SPAWNS)));

		PATCH_PORTOBELLO = registerConditionalPlacement(Util.rl(CollectorsReap.MODID, "patch_portobello"),
			FEATURE_PATCH_PORTOBELLO,
			CRConfig.verify("portobello") && CRConfig.CHANCE_PORTOBELLO.get() > 0, RarityFilter.onAverageOnceEvery(CRConfig.CHANCE_PORTOBELLO.get()), CountPlacement.of(2), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

		FEATURE_LEMON_BUSH = register(Util.rl(CollectorsReap.MODID, "lemon_bush"),
			RandomPatchFeature.RANDOM_PATCH,
			lemonBushConfig(CRBlocks.LEMON_BUSH.get(), 10, 5, BlockPredicate.matchesTag(BLOCK_BELOW, BlockTags.DIRT))
		);

		LEMON_BUSH = registerConditionalPlacement(Util.rl(CollectorsReap.MODID, "lemon_bush"),
			FEATURE_LEMON_BUSH, CRConfig.verify("lemon") && CRConfig.CHANCE_LEMON_BUSH.get() > 0, RarityFilter.onAverageOnceEvery(CRConfig.CHANCE_LEMON_BUSH.get()), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
	}

	public static RandomPatchConfiguration lemonBushConfig(Block block, int tries, int xzSpread, BlockPredicate plantedOn) {
		return new RandomPatchConfiguration(tries, xzSpread, 3, PlacementUtils.filtered(CRFeatures.BUSH_BLOCK.get(),
			new SimpleBlockConfiguration(BlockStateProvider.simple(block)), BlockPredicate.allOf(plantedOn, BlockPredicate.ONLY_IN_AIR_PREDICATE)));
	}
}