package com.tygames.heavenandhell.init;

import com.tygames.heavenandhell.HeavenandHell;
import com.tygames.heavenandhell.armor.ArmorTier;
import com.tygames.heavenandhell.blocks.*;
import com.tygames.heavenandhell.entities.Vampire;
import com.tygames.heavenandhell.fluid.FluidProperties;
import com.tygames.heavenandhell.item.ItemCreativeTab;
import com.tygames.heavenandhell.item.ModSpawnEggItem;
import com.tygames.heavenandhell.tools.ModItemTier;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.ArmorDyeRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import org.lwjgl.system.CallbackI;

import java.rmi.registry.Registry;

public class INIT {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, HeavenandHell.MOD_ID);
    public static final DeferredRegister<Fluid> FLUIDS = new DeferredRegister<>(ForgeRegistries.FLUIDS, HeavenandHell.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, HeavenandHell.MOD_ID);


    public static void init() {
        FLUIDS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //ITEMS
    public static final RegistryObject<Item> HOLY_BIBLE = ITEMS.register("holy_bible", ItemCreativeTab::new);
    public static final RegistryObject<Item> HOLY_WATER = ITEMS.register("holy_water", ItemCreativeTab::new);
    public static final RegistryObject<Item> SHIELD_OF_FAITH = ITEMS.register("shield_of_faith", ItemCreativeTab::new);
    public static final RegistryObject<Item> HEAVEN_AND_HELL_GUIDE = ITEMS.register("heaven_and_hell_guide", ItemCreativeTab::new);
    public static final RegistryObject<Item> SHIELD_OF_WRATH = ITEMS.register("shield_of_wrath", ItemCreativeTab::new);
    public static final RegistryObject<Item> SINFUL_INGOT = ITEMS.register("sinful_ingot", ItemCreativeTab::new);
    public static final RegistryObject<Item> HOLY_DUST = ITEMS.register("holy_dust", ItemCreativeTab::new);
    public static final RegistryObject<Item> SINFUL_DUST = ITEMS.register("sinful_dust", ItemCreativeTab::new);
    public static final RegistryObject<Item> HOLY_INGOT = ITEMS.register("holy_ingot", ItemCreativeTab::new);
    public static final RegistryObject<Item> ANGELIC_GRACE = ITEMS.register("angelic_grace", ItemCreativeTab::new);
    public static final RegistryObject<Item> DEMONIC_SOUL = ITEMS.register("demonic_soul", ItemCreativeTab::new);
    public static final RegistryObject<ModSpawnEggItem> VAMPIRE_SPAWN_EGG = ITEMS.register("vampire_spawn_egg", () -> new ModSpawnEggItem(ModEntityTypes.VAMPIRE, 0xFF329F, 0xFF329F, new Item.Properties().group(HeavenandHell.TAB).maxStackSize(16)));
    public static final RegistryObject<BucketItem> BLOOD_BUCKET = ITEMS.register("blood_bucket", () -> new BucketItem(INIT.BLOOD_FLUID, new Item.Properties().group(HeavenandHell.TAB).maxStackSize(1)));


    //BLOCKS
    public static final RegistryObject<Block> HOLY_BLOCK = BLOCKS.register("holy_block", HolyBlock::new);
    public static final RegistryObject<Block> HOLY_DIRT = BLOCKS.register("holy_dirt", () -> new Block(Block.Properties.from(Blocks.DIRT)));
    public static final RegistryObject<Block> HELL_BLOCK = BLOCKS.register("hell_block", HellBlock::new);
    public static final RegistryObject<Block> FLESH_BLOCK = BLOCKS.register("flesh_block", () -> new Block(Block.Properties.from(Blocks.SPONGE)));
    public static final RegistryObject<Block> HOLY_ORE = BLOCKS.register("holy_ore", HolyOre::new);
    public static final RegistryObject<Block> SINFUL_ORE = BLOCKS.register("sinful_ore",SinfulOre::new);
    public static final RegistryObject<Block> CROSS = BLOCKS.register("cross", Cross::new);
    public static final RegistryObject<Block> HEAVENLY_CLOUD = BLOCKS.register("heavenly_cloud", HeavenlyCloud::new);
    public static final RegistryObject<Block> HELL_DIRT = BLOCKS.register("hell_dirt", HellDirt::new);
    public static final RegistryObject<FlowingFluidBlock> BLOOD_FLUID_BLOCK = BLOCKS.register("blood_fluid_block", () -> new FlowingFluidBlock(INIT.BLOOD_FLUID, Block.Properties.create(Material.WATER).hardnessAndResistance(100f).doesNotBlockMovement().noDrops()));
    public static final RegistryObject<Block> KILLERPLAYZ_BLOCK = BLOCKS.register("killerplayz_block", KillerPlayzBlock::new);


    //BLOCK ITEM
    public static final RegistryObject<Item> HOLY_BLOCK_ITEM = ITEMS.register("holy_block", () -> new BlockItemBase(HOLY_BLOCK.get()));
    public static final RegistryObject<Item> HOLY_ORE_ITEM = ITEMS.register("holy_ore", () -> new BlockItemBase(HOLY_ORE.get()));
    public static final RegistryObject<Item> SINFUL_ORE_ITEM = ITEMS.register("sinful_ore", () -> new BlockItemBase(SINFUL_ORE.get()));
    public static final RegistryObject<Item> HELL_BLOCK_ITEM = ITEMS.register("hell_block", () -> new BlockItemBase(HELL_BLOCK.get()));
    public static final RegistryObject<Item> FLESH_BLOCK_ITEM = ITEMS.register("flesh_block", () -> new BlockItemBase(FLESH_BLOCK.get()));
    public static final RegistryObject<Item> CROSS_ITEM = ITEMS.register("cross", () -> new BlockItemBase(CROSS.get()));
    public static final RegistryObject<Item> HOLY_DIRT_ITEM = ITEMS.register("holy_dirt", () -> new BlockItemBase(HOLY_DIRT.get()));
    public static final RegistryObject<Item> HEAVENLY_CLOUD_ITEM = ITEMS.register("heavenly_cloud", () -> new BlockItemBase(HEAVENLY_CLOUD.get()));
    public static final RegistryObject<Item> HELL_DIRT_ITEM = ITEMS.register("hell_dirt", () -> new BlockItemBase(HELL_DIRT.get()));
    public static final RegistryObject<Item> KILLERPLAYZ_BLOCK_ITEM = ITEMS.register("killerplayz_block", () -> new BlockItemBase(KILLERPLAYZ_BLOCK.get()));

    //TOOLS
    public static final RegistryObject<SwordItem> SWORD_OF_THE_SPIRIT = ITEMS.register("sword_of_the_spirit", () ->
            new SwordItem(ModItemTier.HOLY, 10, -2.4f, new Item.Properties().group(HeavenandHell.TAB)));
    public static final RegistryObject<SwordItem> SWORD_OF_SIN = ITEMS.register("sword_of_sin", () ->
            new SwordItem(ModItemTier.SINFUL, 9, -2.4f, new Item.Properties().group(HeavenandHell.TAB)));
    public static final RegistryObject<PickaxeItem> PICKAXE_OF_THE_SPIRIT= ITEMS.register("pickaxe_of_the_spirit",() ->
            new PickaxeItem(ModItemTier.HOLY, 0, -2.4f, new Item.Properties().group(HeavenandHell.TAB)));
    public static final RegistryObject<PickaxeItem> PICKAXE_OF_ENVY= ITEMS.register("pickaxe_of_envy",() ->
            new PickaxeItem(ModItemTier.SINFUL, 0, -2.4f, new Item.Properties().group(HeavenandHell.TAB)));
    public static final RegistryObject<AxeItem> AXE_OF_GREED= ITEMS.register("axe_of_greed", () ->
            new AxeItem(ModItemTier.SINFUL, 0, -2.4f, new Item.Properties().group(HeavenandHell.TAB)));
    public static final RegistryObject<AxeItem> AXE_OF_THE_SPIRIT= ITEMS.register("axe_of_the_spirit", () ->
            new AxeItem(ModItemTier.HOLY, 0, -2.4f, new Item.Properties().group(HeavenandHell.TAB)));
    public static final RegistryObject<ShovelItem> SHOVEL_OF_PRIDE= ITEMS.register("shovel_of_pride", () ->
            new ShovelItem(ModItemTier.SINFUL, 0, -2.4f, new Item.Properties().group(HeavenandHell.TAB)));
    public static final RegistryObject<ShovelItem> SHOVEL_OF_THE_SPIRIT= ITEMS.register("shovel_of_the_spirit", () ->
            new ShovelItem(ModItemTier.HOLY, 0, -2.4f, new Item.Properties().group(HeavenandHell.TAB)));
    public static final RegistryObject<HoeItem> TILLER_OF_THE_SPIRIT= ITEMS.register("tiller_of_the_spirit", () ->
            new HoeItem(ModItemTier.HOLY,0f, new Item.Properties().group(HeavenandHell.TAB)));
    public static final RegistryObject<HoeItem> HOE_OF_LUST= ITEMS.register("hoe_of_lust", () ->
            new HoeItem(ModItemTier.SINFUL, 0f, new Item.Properties().group(HeavenandHell.TAB)));


    //ARMOR
    public static final RegistryObject<ArmorItem> HELMET_OF_SALVATION = ITEMS.register("helmet_of_salvation", () ->
            new ArmorItem(ArmorTier.HOLY, EquipmentSlotType.HEAD, new Item.Properties().group(HeavenandHell.TAB)));
    public static final RegistryObject<ArmorItem> BREASTPLATE_OF_RIGHTEOUSNESS = ITEMS.register("breastplate_of_righteousness", () ->
            new ArmorItem(ArmorTier.HOLY, EquipmentSlotType.CHEST, new Item.Properties().group(HeavenandHell.TAB)));
    public static final RegistryObject<ArmorItem> BELT_OF_TRUTH = ITEMS.register("belt_of_truth", () ->
            new ArmorItem(ArmorTier.HOLY, EquipmentSlotType.LEGS, new Item.Properties().group(HeavenandHell.TAB)));
    public static final RegistryObject<ArmorItem> SHOES_OF_PEACE = ITEMS.register("shoes_of_peace", () ->
            new ArmorItem(ArmorTier.HOLY, EquipmentSlotType.FEET, new Item.Properties().group(HeavenandHell.TAB)));
    public static final RegistryObject<ArmorItem> SATANS_HELM = ITEMS.register("satans_helm", () ->
            new ArmorItem(ArmorTier.SINFUL, EquipmentSlotType.HEAD, new Item.Properties().group(HeavenandHell.TAB)));
    public static final RegistryObject<ArmorItem> SATANS_BREASTPLATE = ITEMS.register("satans_breastplate", () ->
            new ArmorItem(ArmorTier.SINFUL, EquipmentSlotType.CHEST, new Item.Properties().group(HeavenandHell.TAB)));
    public static final RegistryObject<ArmorItem> SATANS_LEGGINGS = ITEMS.register("satans_leggings", () ->
            new ArmorItem(ArmorTier.SINFUL, EquipmentSlotType.LEGS, new Item.Properties().group(HeavenandHell.TAB)));
    public static final RegistryObject<ArmorItem> SATANS_BOOTS = ITEMS.register("satans_boots", () ->
            new ArmorItem(ArmorTier.SINFUL, EquipmentSlotType.FEET, new Item.Properties().group(HeavenandHell.TAB)));
    public static final RegistryObject<ArmorItem> ANGELIC_HELMET = ITEMS.register("angelic_helmet", () ->
            new ArmorItem(ArmorTier.ANGELIC, EquipmentSlotType.HEAD, new Item.Properties().group(HeavenandHell.TAB)));
    public static final RegistryObject<ArmorItem> ANGELIC_CHESTPLATE = ITEMS.register("angelic_chestplate", () ->
            new ArmorItem(ArmorTier.ANGELIC, EquipmentSlotType.CHEST, new Item.Properties().group(HeavenandHell.TAB)));
    public static final RegistryObject<ArmorItem> ANGELIC_LEGGINGS = ITEMS.register("angelic_leggings", () ->
            new ArmorItem(ArmorTier.ANGELIC, EquipmentSlotType.LEGS, new Item.Properties().group(HeavenandHell.TAB)));
    public static final RegistryObject<ArmorItem> ANGELIC_BOOTS = ITEMS.register("angelic_boots", () ->
            new ArmorItem(ArmorTier.ANGELIC, EquipmentSlotType.FEET, new Item.Properties().group(HeavenandHell.TAB)));
    public static final RegistryObject<ArmorItem> DEMONIC_HELMET = ITEMS.register("demonic_helmet", () ->
            new ArmorItem(ArmorTier.DEMONIC, EquipmentSlotType.HEAD, new Item.Properties().group(HeavenandHell.TAB)));
    public static final RegistryObject<ArmorItem> DEMONIC_CHESTPLATE = ITEMS.register("demonic_chestplate", () ->
            new ArmorItem(ArmorTier.DEMONIC, EquipmentSlotType.CHEST, new Item.Properties().group(HeavenandHell.TAB)));
    public static final RegistryObject<ArmorItem> DEMONIC_LEGGINGS = ITEMS.register("demonic_leggings", () ->
            new ArmorItem(ArmorTier.DEMONIC, EquipmentSlotType.LEGS, new Item.Properties().group(HeavenandHell.TAB)));
    public static final RegistryObject<ArmorItem> DEMONIC_BOOTS = ITEMS.register("demonic_boots", () ->
            new ArmorItem(ArmorTier.DEMONIC, EquipmentSlotType.FEET, new Item.Properties().group(HeavenandHell.TAB)));

    //FLUID
    public static final RegistryObject<FlowingFluid> BLOOD_FLUID = FLUIDS.register("blood_fluid", () -> new ForgeFlowingFluid.Source(FluidProperties.BLOOD_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> BLOOD_FLUID_FLOWING = FLUIDS.register("blood_fluid_flowing", () -> new ForgeFlowingFluid.Flowing(FluidProperties.BLOOD_FLUID_PROPERTIES));
}

