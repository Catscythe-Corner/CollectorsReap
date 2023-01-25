package net.brdle.collectorsreap.data.gen;

import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.common.block.CRBlocks;
import net.brdle.collectorsreap.common.item.CRItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class CRLanguageProvider extends LanguageProvider {
    public CRLanguageProvider(DataGenerator gen) {
        super(gen, CollectorsReap.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        addBlocks();
        addItems();
    }

    private void addBlocks() {
        addBlock(CRBlocks.PORTOBELLO, "Portobello");
        addBlock(CRBlocks.PORTOBELLO_COLONY, "Portobello Colony");
        addBlock(CRBlocks.PORTOBELLO_QUICHE, "Portobello Quiche");
        addBlock(CRBlocks.LIME_PIE, "Key Lime Pie");
        addBlock(CRBlocks.SMALL_LIME_BUSH, "Lime Seeds");
        addBlock(CRBlocks.LIME_BUSH, "Lime Bush");
        addBlock(CRBlocks.LIME_CRATE, "Lime Crate");
        addBlock(CRBlocks.SMALL_POMEGRANATE_BUSH, "Pomegranate Seeds");
        addBlock(CRBlocks.POMEGRANATE_BUSH, "Pomegranate Bush");
        addBlock(CRBlocks.POMEGRANATE_CRATE, "Pomegranate Crate");
    }

    private void addItems() {
        addItem(CRItems.BAKED_PORTOBELLO_CAP, "Baked Portobello Cap");
        addItem(CRItems.STUFFED_PORTOBELLO_CAP, "Stuffed Portobello");
        addItem(CRItems.PORTOBELLO_BURGER, "Portoburger");
        addItem(CRItems.PORTOBELLO_PASTA, "Mushroom Pasta");
        addItem(CRItems.PORTOBELLO_RISOTTO, "Portobello Risotto");
        addItem(CRItems.PORTOBELLO_WRAP, "Veggie Wrap");
        addItem(CRItems.PORTOBELLO_RICE_SOUP, "Wild Rice Soup");
        addItem(CRItems.PORTOBELLO_QUICHE_SLICE, "Slice of Portobello Quiche");
        addItem(CRItems.LIME_PIE_SLICE, "Slice of Key Lime Pie");
        addItem(CRItems.LIME, "Lime");
        addItem(CRItems.LIME_SLICE, "Lime Slice");
        addItem(CRItems.LIME_POPSICLE, "Lime Popsicle");
        addItem(CRItems.LIME_COOKIE, "Lime Cookie");
        addItem(CRItems.CANDIED_LIME, "Candied Lime");
        addItem(CRItems.HONEY_LIME_CHICKEN, "Honey Lime Chicken");
        addItem(CRItems.COD_CEVICHE, "Cod Ceviche");
        addItem(CRItems.MEDITERRANEAN_SALMON, "Mediterranean Salmon");
        addItem(CRItems.SALMON_TARTARE, "Salmon Tartare");
        addItem(CRItems.POTATO_FRITTERS, "Potato Fritters");
        addItem(CRItems.LIMEADE, "Limeade");
        addItem(CRItems.BERRY_LIMEADE, "Berry Limeade");
        addItem(CRItems.POMEGRANATE, "Pomegranate");
        addItem(CRItems.POMEGRANATE_SLICE, "Pomegranate Slice");
        addItem(CRItems.POMEGRANATE_MUTTON, "Pomegranate Mutton");
        addItem(CRItems.POMEGRANATE_CHICKEN, "Pomegranate Chicken");
        addItem(CRItems.POMEGRANATE_PORK, "Pomegranate Pork");
        addItem(CRItems.POMEGRANATE_CUSTARD, "Pomegranate Custard");
        addItem(CRItems.PINK_LIMEADE, "Pink Limeade");
        addItem(CRItems.SPICY_GRENADINE_JELLY, "Spicy Grenadine Jelly");
        addItem(CRItems.GLAZED_STRIDER, "Glazed Strider");
        addItem(CRItems.CRIMSON_CARROT_ROAST, "Crimson Carrot Roast");
        addItem(CRItems.DELUXE_SALAD, "Deluxe Salad");
        add("tooltip.requires_modid", "Requires modid:");
    }
}
