package net.noamr.rotandburn.block;

import com.mojang.serialization.MapCodec;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.noamr.rotandburn.RotAndBurn;
import net.noamr.rotandburn.block.custom.BlueberryBushBlock;
import net.noamr.rotandburn.block.custom.CarpetFlowerBlock;
import net.noamr.rotandburn.block.custom.TallHexFlower;
import net.noamr.rotandburn.block.custom.ThistleBlock;

import java.util.Set;

public class ModBlocks {
    //Blocks:
    public static final Block SHALE = registerBlock("shale", new Block(AbstractBlock.Settings.create().strength(2.0f).requiresTool().sounds(BlockSoundGroup.PACKED_MUD).mapColor(MapColor.DEEPSLATE_GRAY)));
    public static final Block SHALE_FOSSIL = registerBlock("shale_fossil", new Block(AbstractBlock.Settings.create().strength(2.5f).requiresTool().sounds(BlockSoundGroup.MUD_BRICKS).mapColor(MapColor.DEEPSLATE_GRAY)));
    public static final Block SALT_BLOCK = registerBlock("salt_block", new Block(AbstractBlock.Settings.create().strength(0.5f).requiresTool().sounds(BlockSoundGroup.SUSPICIOUS_SAND).mapColor(MapColor.WHITE)));
    public static final Block ASH_BLOCK = registerBlock("ash_block", new FallingBlock(AbstractBlock.Settings.create().strength(0.2f).sounds(BlockSoundGroup.SAND).mapColor(MapColor.LIGHT_GRAY)) {
        @Override
        protected MapCodec<? extends FallingBlock> getCodec() {
            return null;
        }});
    public static final Block YELLOW_EARTH = registerBlock("yellow_earth", new Block(AbstractBlock.Settings.create().strength(1.0f).sounds(BlockSoundGroup.MUD).mapColor(MapColor.TERRACOTTA_YELLOW)));

    public static final Block BURNT_WOOD_PLANKS = registerBlock("burnt_wood_planks", new Block(AbstractBlock.Settings.create().requiresTool().strength(2.0f).sounds(BlockSoundGroup.WOOD).mapColor(MapColor.TERRACOTTA_BLACK)));
    public static final Block BURNT_WOOD_STAIRS = registerBlock("burnt_wood_stairs", new StairsBlock(ModBlocks.BURNT_WOOD_PLANKS.getDefaultState(),
            AbstractBlock.Settings.create().strength(2.0f).requiresTool().sounds(BlockSoundGroup.WOOD).mapColor(MapColor.TERRACOTTA_BLACK)));
    public static final Block BURNT_WOOD_SLAB = registerBlock("burnt_wood_slab", new SlabBlock(
            AbstractBlock.Settings.create().strength(2.0f).requiresTool().sounds(BlockSoundGroup.WOOD).mapColor(MapColor.TERRACOTTA_BLACK)));

    public static final Block BURNT_WOOD_BUTTON = registerBlock("burnt_wood_button", new ButtonBlock(BlockSetType.OAK, 16,
            AbstractBlock.Settings.create().strength(2.0f).requiresTool().sounds(BlockSoundGroup.WOOD).mapColor(MapColor.TERRACOTTA_BLACK).noCollision()));
    public static final Block BURNT_WOOD_PRESSURE_PLATE = registerBlock("burnt_wood_pressure_plate", new PressurePlateBlock(BlockSetType.OAK,
            AbstractBlock.Settings.create().strength(2.0f).requiresTool().sounds(BlockSoundGroup.WOOD).mapColor(MapColor.TERRACOTTA_BLACK)));

    public static final Block BURNT_WOOD_FENCE = registerBlock("burnt_wood_fence", new FenceBlock(
            AbstractBlock.Settings.create().strength(2.0f).requiresTool().sounds(BlockSoundGroup.WOOD).mapColor(MapColor.TERRACOTTA_BLACK)));
    public static final Block BURNT_WOOD_FENCE_GATE = registerBlock("burnt_wood_fence_gate", new FenceGateBlock(WoodType.OAK,
            AbstractBlock.Settings.create().strength(2.0f).requiresTool().sounds(BlockSoundGroup.WOOD).mapColor(MapColor.TERRACOTTA_BLACK)));

    public static final Block ASH_LAYER = registerBlock("ash_layer", new SnowBlock(AbstractBlock.Settings.create().strength(0.2f).sounds(BlockSoundGroup.SAND).mapColor(MapColor.LIGHT_GRAY)));

    //Flowers:
    public static final Block WOOD_ANEMONE = registerBlock("wood_anemone", new CarpetFlowerBlock(StatusEffects.RESISTANCE, 20f, AbstractBlock.Settings.create().mapColor(MapColor.EMERALD_GREEN).noCollision().pistonBehavior(PistonBehavior.DESTROY).sounds(BlockSoundGroup.GRASS)));
    public static final Block YELLOW_SWAN_ORCHID = registerBlock("yellow_swan_orchid", new VineBlock(AbstractBlock.Settings.create().mapColor(MapColor.YELLOW).noCollision().pistonBehavior(PistonBehavior.DESTROY).sounds(BlockSoundGroup.GRASS)));
    public static final Block CARDINAL_FLOWER = registerBlock("cardinal_flower", new TallHexFlower(AbstractBlock.Settings.create().mapColor(MapColor.RED).noCollision().offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY).sounds(BlockSoundGroup.GRASS).dynamicBounds()));
    public static final Block BUTTERFLY_MILKWEED = registerBlock("butterfly_milkweed", new TallHexFlower(AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_ORANGE).noCollision().offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY).sounds(BlockSoundGroup.GRASS).dynamicBounds()));
    public static final Block GOLDENROD = registerBlock("goldenrod", new TallHexFlower(AbstractBlock.Settings.create().mapColor(MapColor.YELLOW).noCollision().offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY).sounds(BlockSoundGroup.GRASS).dynamicBounds()));
    public static final Block INDIAN_PAINTBRUSH = registerBlock("indian_paintbrush", new FlowerBlock(StatusEffects.RESISTANCE, 20f, AbstractBlock.Settings.create().mapColor(MapColor.RED).noCollision().offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY).sounds(BlockSoundGroup.GRASS)));
    public static final Block THISTLE = registerBlock("thistle", new ThistleBlock(AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_PURPLE).noCollision().offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY).sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));
    public static final Block BLUEBERRY_BUSH = registerBlock("blueberry_bush", new BlueberryBushBlock(AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_PURPLE).noCollision().offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY).sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));
    public static final Block BROADLEAF_PLANTAIN = registerBlock("broadleaf_plantain", new ShortPlantBlock(AbstractBlock.Settings.create().mapColor(MapColor.EMERALD_GREEN).noCollision().offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY).sounds(BlockSoundGroup.SWEET_BERRY_BUSH).replaceable()));

    public static final Set<Block> MOD_TRANS_BLOCKS = Set.of(
            CARDINAL_FLOWER,
            GOLDENROD,
            WOOD_ANEMONE,
            YELLOW_SWAN_ORCHID,
            INDIAN_PAINTBRUSH,
            THISTLE,
            BUTTERFLY_MILKWEED,
            BLUEBERRY_BUSH,
            BROADLEAF_PLANTAIN
    );

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(RotAndBurn.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(RotAndBurn.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        RotAndBurn.LOGGER.info("Registering Mod Blocks for " + RotAndBurn.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            //entries.add(ModBlocks.SHALE);
        });
    }
}
