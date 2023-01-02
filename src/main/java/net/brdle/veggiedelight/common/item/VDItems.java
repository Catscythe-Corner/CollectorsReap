package net.brdle.veggiedelight.common.item;

import net.brdle.veggiedelight.Util;
import net.brdle.veggiedelight.VeggieDelight;
import net.brdle.veggiedelight.common.block.VDBlocks;
import net.brdle.veggiedelight.common.item.food.Nutrition;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.registry.ModItems;

import java.util.function.Supplier;

public class VDItems extends ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, VeggieDelight.MODID);

    public static final RegistryObject<Item> PORTOBELLO_COLONY = registerBlock(VDBlocks.PORTOBELLO_COLONY);
    public static final RegistryObject<Item> PORTOBELLO = registerBlock(VDBlocks.PORTOBELLO);
    public static final RegistryObject<Item> BAKED_PORTOBELLO_CAP = registerFood("baked_portobello_cap",
        Nutrition.BAKED_PORTOBELLO_CAP);
    public static final RegistryObject<Item> STUFFED_PORTOBELLO_CAP = registerFood("stuffed_portobello_cap",
        Nutrition.STUFFED_PORTOBELLO_CAP);
    public static final RegistryObject<Item> PORTOBELLO_BURGER = registerFood("portobello_burger",
        Nutrition.PORTOBELLO_BURGER);
    public static final RegistryObject<Item> PORTOBELLO_WRAP = registerFood("portobello_wrap",
        Nutrition.PORTOBELLO_WRAP);
    public static final RegistryObject<Item> PORTOBELLO_RICE_SOUP = registerItem("portobello_rice_soup",
        () -> new ConsumableItem(bowlFoodItem(Nutrition.PORTOBELLO_RICE_SOUP)));
    public static final RegistryObject<Item> PORTOBELLO_RISOTTO = registerItem("portobello_risotto",
        () -> new ConsumableItem(bowlFoodItem(Nutrition.PORTOBELLO_RISOTTO)));
    public static final RegistryObject<Item> PORTOBELLO_PASTA = registerItem("portobello_pasta",
        () -> new ConsumableItem(bowlFoodItem(Nutrition.PORTOBELLO_PASTA)));
    public static final RegistryObject<Item> PORTOBELLO_QUICHE = registerBlock(VDBlocks.PORTOBELLO_QUICHE);
    public static final RegistryObject<Item> PORTOBELLO_QUICHE_SLICE = registerFood("portobello_quiche_slice",
        Nutrition.PORTOBELLO_QUICHE_SLICE);
    public static final RegistryObject<Item> POMEGRANATE = registerFood("pomegranate",
        Nutrition.POMEGRANATE);
    public static final RegistryObject<Item> LEMON_SEEDS = registerBlock("lemon_seeds",
        VDBlocks.SMALL_LEMON_BUSH);
    public static final RegistryObject<Item> LEMON = registerFood("lemon",
        Nutrition.LEMON);
    public static final RegistryObject<Item> LEMON_PIE_SLICE = registerFood("lemon_pie_slice",
        Nutrition.LEMON_PIE_SLICE);
    public static final RegistryObject<Item> LEMON_POPSICLE = registerFood("lemon_popsicle",
        Nutrition.LEMON_POPSICLE);
    public static final RegistryObject<Item> LEMON_COOKIE = registerFood("lemon_cookie",
        Nutrition.LEMON_COOKIE);

    // Sets Creative Tab
    public static RegistryObject<Item> registerBlock(RegistryObject<Block> block) {
        return registerBlock(Util.name(block), block);
    }

    // Sets Creative Tab
    public static RegistryObject<Item> registerBlock(String name, RegistryObject<Block> block) {
        return registerItem(name, () -> new BlockItem(block.get(), (new Item.Properties().tab(FarmersDelight.CREATIVE_TAB))));
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