package net.brdle.collectorsreap.common.item;

import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.common.block.CRBlocks;
import net.brdle.collectorsreap.common.item.food.Nutrition;
import net.brdle.collectorsreap.compat.ModCompat;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.DrinkableItem;
import vectorwing.farmersdelight.common.item.MushroomColonyItem;
import vectorwing.farmersdelight.common.registry.ModItems;
import java.util.Locale;
import java.util.function.Supplier;

public class CRItems extends ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CollectorsReap.MODID);

    public static final RegistryObject<Item> PORTOBELLO_COLONY = registerItem("portobello_colony",
        () -> new MushroomColonyItem(CRBlocks.PORTOBELLO_COLONY.get(),
        (new Item.Properties().tab(FarmersDelight.CREATIVE_TAB))));
    public static final RegistryObject<Item> PORTOBELLO = registerBlock(CRBlocks.PORTOBELLO);
    public static final RegistryObject<Item> BAKED_PORTOBELLO_CAP = registerFood("baked_portobello_cap",
        Nutrition.BAKED_PORTOBELLO_CAP);
    public static final RegistryObject<Item> STUFFED_PORTOBELLO_CAP = registerFood("stuffed_portobello_cap",
        Nutrition.STUFFED_PORTOBELLO_CAP);
    public static final RegistryObject<Item> PORTOBELLO_BURGER = registerFood("portobello_burger",
        Nutrition.PORTOBELLO_BURGER);
    public static final RegistryObject<Item> PORTOBELLO_WRAP = registerFood("portobello_wrap",
        Nutrition.PORTOBELLO_WRAP);
    public static final RegistryObject<Item> PORTOBELLO_RICE_SOUP = registerItem("portobello_rice_soup",
        () -> new ConsumableItem(bowlFoodItem(
        Nutrition.PORTOBELLO_RICE_SOUP)));
    public static final RegistryObject<Item> PORTOBELLO_RISOTTO = registerItem("portobello_risotto",
        () -> new ConsumableItem(bowlFoodItem(
        Nutrition.PORTOBELLO_RISOTTO)));
    public static final RegistryObject<Item> PORTOBELLO_PASTA = registerItem("portobello_pasta",
        () -> new ConsumableItem(bowlFoodItem(
        Nutrition.PORTOBELLO_PASTA)));
    public static final RegistryObject<Item> PORTOBELLO_QUICHE = registerBlock(CRBlocks.PORTOBELLO_QUICHE);
    public static final RegistryObject<Item> PORTOBELLO_QUICHE_SLICE = registerFood("portobello_quiche_slice",
        Nutrition.PORTOBELLO_QUICHE_SLICE);
    public static final RegistryObject<Item> POMEGRANATE = registerItem("pomegranate",
        () -> new Item((new Item.Properties().tab(FarmersDelight.CREATIVE_TAB))));
    public static final RegistryObject<Item> POMEGRANATE_SLICE = registerFood("pomegranate_slice",
        Nutrition.POMEGRANATE_SLICE);
    public static final RegistryObject<Item> POMEGRANATE_SEEDS = registerItem("pomegranate_seeds",
        () -> new BlockItem(CRBlocks.SMALL_POMEGRANATE_BUSH.get(), (new Item.Properties()).food(
        Nutrition.POMEGRANATE_SEEDS).tab(FarmersDelight.CREATIVE_TAB)));
    public static final RegistryObject<Item> LIME_SEEDS = registerBlock("lime_seeds", CRBlocks.SMALL_LIME_BUSH);
    public static final RegistryObject<Item> LIME = registerFood("lime",
        Nutrition.LIME);
    public static final RegistryObject<Item> LIME_SLICE = registerFood("lime_slice",
        Nutrition.LIME_SLICE);
    public static final RegistryObject<Item> CANDIED_LIME = registerItem("candied_lime",
        () -> new ConsumableItem((new Item.Properties()).food(
        Nutrition.CANDIED_LIME).tab(FarmersDelight.CREATIVE_TAB), true));
    public static final RegistryObject<Item> LIME_PIE = registerBlock(CRBlocks.LIME_PIE);
    public static final RegistryObject<Item> LIME_PIE_SLICE = registerFood("lime_pie_slice",
        Nutrition.LIME_PIE_SLICE);
    public static final RegistryObject<Item> LIME_POPSICLE = registerItem("lime_popsicle",
        () -> new ConsumableItem((new Item.Properties()).food(
        Nutrition.LIME_POPSICLE).tab(FarmersDelight.CREATIVE_TAB), true));
    public static final RegistryObject<Item> LIME_COOKIE = registerItem("lime_cookie",
        () -> new ConsumableItem((new Item.Properties()).food(
        Nutrition.LIME_COOKIE).tab(FarmersDelight.CREATIVE_TAB), true));
    public static final RegistryObject<Item> HONEY_LIME_CHICKEN = registerItem("honey_lime_chicken",
        () -> new ConsumableItem((new Item.Properties()).food(
        Nutrition.HONEY_LIME_CHICKEN).tab(FarmersDelight.CREATIVE_TAB), true));
    public static final RegistryObject<Item> MEDITERRANEAN_SALMON = registerFood("mediterranean_salmon",
        Nutrition.MEDITERRANEAN_SALMON);
    public static final RegistryObject<Item> SALMON_TARTARE = registerFood("salmon_tartare",
        Nutrition.SALMON_TARTARE);
    public static final RegistryObject<Item> POTATO_FRITTERS = registerItem("potato_fritters",
        () -> new ConsumableItem((new Item.Properties()).food(
        Nutrition.POTATO_FRITTERS).tab(FarmersDelight.CREATIVE_TAB), true));
    public static final RegistryObject<Item> COD_CEVICHE = registerFood("cod_ceviche",
        Nutrition.COD_CEVICHE);
    public static final RegistryObject<Item> CRIMSON_CARROT_ROAST = registerItem("crimson_carrot_roast",
        () -> new ConsumableItem(bowlFoodItem(
        Nutrition.CRIMSON_CARROT_ROAST), true));
    public static final RegistryObject<Item> POMEGRANATE_MUTTON = registerItem("pomegranate_mutton",
        () -> new ConsumableItem(bowlFoodItem(
        Nutrition.POMEGRANATE_MUTTON), true));
    public static final RegistryObject<Item> POMEGRANATE_PORK = registerItem("pomegranate_pork",
        () -> new ConsumableItem(bowlFoodItem(
        Nutrition.POMEGRANATE_PORK), true));
    public static final RegistryObject<Item> POMEGRANATE_CHICKEN = registerItem("pomegranate_chicken",
        () -> new ConsumableItem(bowlFoodItem(
        Nutrition.POMEGRANATE_CHICKEN), true));
    public static final RegistryObject<Item> DELUXE_SALAD = registerItem("deluxe_salad",
        () -> new ConsumableItem(bowlFoodItem(
        Nutrition.DELUXE_SALAD), true));
    public static final RegistryObject<Item> POMEGRANATE_CUSTARD = registerItem("pomegranate_custard", () ->
        new DrinkableItem(drinkItem().food(
        Nutrition.POMEGRANATE_CUSTARD), true));
    public static final RegistryObject<Item> LIMEADE = registerItem("limeade", () ->
        new DrinkableItem(drinkItem().food(
        Nutrition.LIMEADE), true));
    public static final RegistryObject<Item> BERRY_LIMEADE = registerItem("berry_limeade", () ->
        new DrinkableItem(drinkItem().food(
        Nutrition.BERRY_LIMEADE), true));
    public static final RegistryObject<Item> PINK_LIMEADE = registerItem("pink_limeade", () ->
        new DrinkableItem(drinkItem().food(
        Nutrition.PINK_LIMEADE), true));
    public static final RegistryObject<Item> LIME_CAKE_SLICE = registerFood("lime_cake_slice",
        Nutrition.LIME_CAKE_SLICE);
    public static final RegistryObject<Item> POMEGRANATE_CAKE_SLICE = registerFood("pomegranate_cake_slice",
        Nutrition.POMEGRANATE_CAKE_SLICE);

    public static final RegistryObject<Item> LIME_CAKE = registerBlock(CRBlocks.LIME_CAKE);
    public static final RegistryObject<Item> POMEGRANATE_CAKE = registerBlock(CRBlocks.POMEGRANATE_CAKE);
    public static final RegistryObject<Item> LIME_CRATE = registerBlock(CRBlocks.LIME_CRATE);
    public static final RegistryObject<Item> POMEGRANATE_CRATE = registerBlock(CRBlocks.POMEGRANATE_CRATE);

    // Nether's Delight Compat
    public static final RegistryObject<Item> GLAZED_STRIDER = registerItem("glazed_strider",
        () -> new CompatConsumable((new Item.Properties()).food(
        Nutrition.GLAZED_STRIDER).craftRemainder(Items.BOWL).stacksTo(16).tab(ModCompat.getNDTab()),
        true, false, "nethersdelight"));
    public static final RegistryObject<Item> SPICY_GRENADINE_JELLY = registerItem("spicy_grenadine_jelly",
        () -> new CompatConsumable((new Item.Properties()).food(
        Nutrition.SPICY_GRENADINE_JELLY).craftRemainder(Items.BOWL).stacksTo(16).tab(ModCompat.getNDTab()),
        true,  false, "nethersdelight"));

    // Neapolitan Compat
    public static final RegistryObject<Item> LIME_ICE_CREAM = registerItem("lime_ice_cream",
        () -> new CompatConsumable((new Item.Properties()).food(
        Nutrition.LIME_ICE_CREAM).craftRemainder(Items.BOWL).stacksTo(1)
        .tab(ModCompat.ifLoaded("neapolitan", CreativeModeTab.TAB_FOOD)), false, false, "neapolitan"));
    public static final RegistryObject<Item> LIME_MILKSHAKE = registerItem("lime_milkshake",
        () -> new ShakeItem(new Item.Properties().food(
        Nutrition.MILKSHAKE).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16)
        .tab(ModCompat.ifLoaded("neapolitan", CreativeModeTab.TAB_FOOD))));
    public static final RegistryObject<Item> POMEGRANATE_ICE_CREAM = registerItem("pomegranate_ice_cream",
        () -> new CompatConsumable((new Item.Properties()).food(
        Nutrition.POMEGRANATE_ICE_CREAM).craftRemainder(Items.BOWL).stacksTo(1)
        .tab(ModCompat.ifLoaded("neapolitan", CreativeModeTab.TAB_FOOD)), false, false, "neapolitan"));
    public static final RegistryObject<Item> POMEGRANATE_MILKSHAKE = registerItem("pomegranate_milkshake",
        () -> new ShakeItem(new Item.Properties().food(
        Nutrition.MILKSHAKE).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16)
        .tab(ModCompat.ifLoaded("neapolitan", CreativeModeTab.TAB_FOOD))));
    public static final RegistryObject<Item> LIME_ICE_CREAM_BLOCK = registerItem("lime_ice_cream_block",
        () -> new BlockItem(CRBlocks.LIME_ICE_CREAM_BLOCK.get(), (new Item.Properties())
            .tab(ModCompat.ifLoaded("neapolitan", CreativeModeTab.TAB_BUILDING_BLOCKS))));
    public static final RegistryObject<Item> POMEGRANATE_ICE_CREAM_BLOCK = registerItem("pomegranate_ice_cream_block",
        () -> new BlockItem(CRBlocks.POMEGRANATE_ICE_CREAM_BLOCK.get(), (new Item.Properties())
            .tab(ModCompat.ifLoaded("neapolitan", CreativeModeTab.TAB_BUILDING_BLOCKS))));

    // Sets Creative Tab
    public static RegistryObject<Item> registerBlock(RegistryObject<Block> block) {
        return registerBlock(Util.name(block), block);
    }

    // Sets Creative Tab
    public static RegistryObject<Item> registerBlock(String name, RegistryObject<Block> block) {
        return registerItem(name, () -> new BlockItem(block.get(), (new Item.Properties().tab(FarmersDelight.CREATIVE_TAB))));
    }

    // Creative tab should be set before calling this function
    public static RegistryObject<Item> registerFood(FoodProperties properties) {
        return registerItem(properties.toString().toLowerCase(Locale.ROOT), () -> new Item((new Item.Properties()
            .tab(FarmersDelight.CREATIVE_TAB).food(properties))));
    }

    // Creative tab should be set before calling this function
    public static RegistryObject<Item> registerFood(String name, FoodProperties properties) {
        return registerItem(name, () -> new Item((new Item.Properties()
            .tab(FarmersDelight.CREATIVE_TAB).food(properties))));
    }

    // Creative tab should be set before calling this function
    public static RegistryObject<Item> registerItem(String name, Supplier<Item> item) {
        return ITEMS.register(name, item);
    }

    public static void create(IEventBus bus) {
        ITEMS.register(bus);
    }
}