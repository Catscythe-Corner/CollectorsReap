package net.brdle.collectorsreap.data.gen;

import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.common.block.PortobelloColonyBlock;
import net.brdle.collectorsreap.common.block.CRBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.common.block.PieBlock;
import vectorwing.farmersdelight.data.BlockStates;

public class CRBlockStateProvider extends BlockStateProvider {
    public CRBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, CollectorsReap.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        this.pieBlock(CRBlocks.PORTOBELLO_QUICHE);
        this.pieBlock(CRBlocks.LIME_PIE);
        this.stageBlock(CRBlocks.PORTOBELLO_COLONY.get(), PortobelloColonyBlock.COLONY_AGE);
        this.cross(CRBlocks.PORTOBELLO.get());
        this.simpleBlock(CRBlocks.SMALL_LIME_BUSH.get(), existingModel("small_lime_bush"));
        this.simpleBlock(CRBlocks.MEDIUM_LIME_BUSH.get(), models()
                .withExistingParent("block/medium_lime_bush", Util.rl("minecraft", "block/template_azalea"))
                .texture("side", CRBlockStateProvider.resourceBlock("medium_lime_bush_side"))
                .texture("top", CRBlockStateProvider.resourceBlock("medium_lime_bush_top"))
                .texture("plant", CRBlockStateProvider.resourceBlock("medium_lime_bush_plant"))
                .texture("particle", CRBlockStateProvider.resourceBlock("medium_lime_bush_plant"))
                .renderType("cutout"));
        this.crateBlock(CRBlocks.LIME_CRATE.get(), "lime");
        this.crateBlock(CRBlocks.POMEGRANATE_CRATE.get(), "pomegranate");
    }

    public void crateBlock(Block block, String cropName) {
        this.simpleBlock(block, this.models().cubeBottomTop(Util.name(block), resourceBlock(cropName + "_crate_side"), Util.rl(FarmersDelight.MODID, "block/crate_bottom"), resourceBlock(cropName + "_crate_top")));
    }

    // Adapted from: https://github.com/vectorwing/FarmersDelight/blob/1.19/src/main/java/vectorwing/farmersdelight/data/BlockStates.java
    public static ResourceLocation resourceBlock(String path) {
        return Util.rl(CollectorsReap.MODID, "block/" + path);
    }

    public ModelFile existingModel(String path) {
        return new ModelFile.ExistingModelFile(resourceBlock(path), models().existingFileHelper);
    }

    public void cross(Block block) {
        this.simpleBlock(block, models().cross("block/" + Util.name(block),
            CRBlockStateProvider.resourceBlock(Util.name(block))).renderType("cutout"));
    }

    // Adapted from: https://github.com/vectorwing/FarmersDelight/blob/1.19/src/main/java/vectorwing/farmersdelight/data/BlockStates.java
    public void stageBlock(Block block, IntegerProperty ageProperty, Property<?>... ignored) {
        getVariantBuilder(block)
            .forAllStatesExcept(state -> {
                String stageName = Util.name(block) + "_stage" + state.getValue(ageProperty);
                return ConfiguredModel.builder()
                    .modelFile(models().cross(stageName, resourceBlock(stageName)).renderType("cutout")).build();
            }, ignored);
    }

    // Adapted from: https://github.com/vectorwing/FarmersDelight/blob/1.19/src/main/java/vectorwing/farmersdelight/data/BlockStates.java
    public void pieBlock(RegistryObject<Block> block) {
        getVariantBuilder(block.get()).forAllStates(state -> {
            int bites = state.getValue(PieBlock.BITES);
            String suffix = bites > 0 ? "_slice" + bites : "";
            return ConfiguredModel.builder()
                .modelFile(existingModel(block.getId().getPath() + suffix))
                .rotationY(((int) state.getValue(PieBlock.FACING).toYRot() + 180) % 360)
                .build();
            }
        );
    }
}
