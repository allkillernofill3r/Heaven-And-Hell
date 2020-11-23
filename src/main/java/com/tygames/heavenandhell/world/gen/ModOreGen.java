package com.tygames.heavenandhell.world.gen;

import com.tygames.heavenandhell.HeavenandHell;
import com.tygames.heavenandhell.init.INIT;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = HeavenandHell.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD) public class ModOreGen {

    @SubscribeEvent
    public static void generateOres (FMLLoadCompleteEvent event){
        for (Biome biome : ForgeRegistries.BIOMES){
            genOre(biome, 1, 0, 5, 15, OreFeatureConfig.FillerBlockType.NATURAL_STONE, INIT.HOLY_ORE.get().getDefaultState(), 4);
            genOre(biome, 2, 0, 5,15, OreFeatureConfig.FillerBlockType.NATURAL_STONE, INIT.SINFUL_ORE.get().getDefaultState(),6);

        }
    }
    public static void genOre(Biome biome, int count, int bottomOffset, int topOffset, int max, OreFeatureConfig.FillerBlockType filler, BlockState defaultBlockState, int size){
        CountRangeConfig range = new CountRangeConfig(count, bottomOffset, topOffset, max);
        OreFeatureConfig feature = new OreFeatureConfig(filler, defaultBlockState, size);
        ConfiguredPlacement config = Placement.COUNT_RANGE.configure(range);
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(feature).withPlacement(config));
    }

}
