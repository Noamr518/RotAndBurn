package net.noamr.rotandburn.block;

import com.mojang.serialization.MapCodec;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.component.type.MapColorComponent;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.noamr.rotandburn.RotAndBurn;
import net.noamr.rotandburn.block.custom.*;

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

    public static final Block BURNT_WOOD_PLANKS = registerBlock("burnt_wood_planks", new Block(AbstractBlock.Settings.create().requiresTool().strength(1.7f).sounds(BlockSoundGroup.WOOD).mapColor(MapColor.TERRACOTTA_BLACK)));
    public static final Block BURNT_WOOD_STAIRS = registerBlock("burnt_wood_stairs", new StairsBlock(ModBlocks.BURNT_WOOD_PLANKS.getDefaultState(),
            AbstractBlock.Settings.create().strength(1.7f).requiresTool().sounds(BlockSoundGroup.WOOD).mapColor(MapColor.TERRACOTTA_BLACK)));
    public static final Block BURNT_WOOD_SLAB = registerBlock("burnt_wood_slab", new SlabBlock(
            AbstractBlock.Settings.create().strength(1.7f).requiresTool().sounds(BlockSoundGroup.WOOD).mapColor(MapColor.TERRACOTTA_BLACK)));

    public static final Block BURNT_WOOD_BUTTON = registerBlock("burnt_wood_button", new ButtonBlock(BlockSetType.OAK, 16,
            AbstractBlock.Settings.create().strength(1.7f).requiresTool().sounds(BlockSoundGroup.WOOD).mapColor(MapColor.TERRACOTTA_BLACK).noCollision()));
    public static final Block BURNT_WOOD_PRESSURE_PLATE = registerBlock("burnt_wood_pressure_plate", new PressurePlateBlock(BlockSetType.OAK,
            AbstractBlock.Settings.create().strength(1.7f).requiresTool().sounds(BlockSoundGroup.WOOD).mapColor(MapColor.TERRACOTTA_BLACK)));

    public static final Block BURNT_WOOD_FENCE = registerBlock("burnt_wood_fence", new FenceBlock(
            AbstractBlock.Settings.create().strength(1.7f).requiresTool().sounds(BlockSoundGroup.WOOD).mapColor(MapColor.TERRACOTTA_BLACK)));
    public static final Block BURNT_WOOD_FENCE_GATE = registerBlock("burnt_wood_fence_gate", new FenceGateBlock(WoodType.OAK,
            AbstractBlock.Settings.create().strength(1.7f).requiresTool().sounds(BlockSoundGroup.WOOD).mapColor(MapColor.TERRACOTTA_BLACK)));

    public static final Block BURNT_LOG = registerBlock("burnt_log", createBurntLogBlock(MapColor.TERRACOTTA_BLACK, MapColor.BLACK));
    public static final Block STRIPPED_BURNT_LOG = registerBlock("stripped_burnt_log", createBurntLogBlock(MapColor.TERRACOTTA_BLACK, MapColor.TERRACOTTA_BLACK));
    public static final Block BURNT_WOOD = registerBlock("burnt_wood", createBurntLogBlock(MapColor.BLACK, MapColor.BLACK));
    public static final Block STRIPPED_BURNT_WOOD = registerBlock("stripped_burnt_wood", createBurntLogBlock(MapColor.TERRACOTTA_BLACK, MapColor.TERRACOTTA_BLACK));

    public static final Block ASH_LAYER = registerBlock("ash_layer", new SnowBlock(AbstractBlock.Settings.create().strength(0.2f).sounds(BlockSoundGroup.SAND).mapColor(MapColor.LIGHT_GRAY)));

    public static final Block APPLE_LOG = registerBlock("apple_log", createLogBlock(MapColor.OAK_TAN, MapColor.TERRACOTTA_BROWN));
    public static final Block STRIPPED_APPLE_LOG = registerBlock("stripped_apple_log", createLogBlock(MapColor.OAK_TAN, MapColor.OAK_TAN));
    public static final Block APPLE_WOOD = registerBlock("apple_wood", createLogBlock(MapColor.TERRACOTTA_BROWN, MapColor.TERRACOTTA_BROWN));
    public static final Block STRIPPED_APPLE_WOOD = registerBlock("stripped_apple_wood", createLogBlock(MapColor.OAK_TAN, MapColor.OAK_TAN));
    public static final Block APPLE_PLANKS = registerBlock("apple_planks", new Block(AbstractBlock.Settings.create().requiresTool().strength(2f).sounds(BlockSoundGroup.WOOD).mapColor(MapColor.OAK_TAN).burnable()));
    public static final Block APPLE_LEAVES = registerBlock("apple_leaves", createLeavesBlock(BlockSoundGroup.GRASS));

    public static final Block BURNT_LEAVES = registerBlock("burnt_leaves", createLeavesBlock(BlockSoundGroup.GRASS));

    public static final Block APPLE_STAIRS = registerBlock("apple_stairs", new StairsBlock(ModBlocks.BURNT_WOOD_PLANKS.getDefaultState(),
            AbstractBlock.Settings.create().strength(2f).requiresTool().sounds(BlockSoundGroup.WOOD).mapColor(MapColor.OAK_TAN).burnable()));
    public static final Block APPLE_SLAB = registerBlock("apple_slab", new SlabBlock(
            AbstractBlock.Settings.create().strength(2f).requiresTool().sounds(BlockSoundGroup.WOOD).mapColor(MapColor.OAK_TAN).burnable()));
    public static final Block APPLE_BUTTON = registerBlock("apple_button", new ButtonBlock(BlockSetType.OAK, 16,
            AbstractBlock.Settings.create().strength(2f).requiresTool().sounds(BlockSoundGroup.WOOD).mapColor(MapColor.OAK_TAN).noCollision().burnable()));
    public static final Block APPLE_PRESSURE_PLATE = registerBlock("apple_pressure_plate", new PressurePlateBlock(BlockSetType.OAK,
            AbstractBlock.Settings.create().strength(2f).requiresTool().sounds(BlockSoundGroup.WOOD).mapColor(MapColor.OAK_TAN).burnable()));
    public static final Block APPLE_FENCE = registerBlock("apple_fence", new FenceBlock(
            AbstractBlock.Settings.create().strength(2f).requiresTool().sounds(BlockSoundGroup.WOOD).mapColor(MapColor.OAK_TAN).burnable()));
    public static final Block APPLE_FENCE_GATE = registerBlock("apple_fence_gate", new FenceGateBlock(WoodType.OAK,
            AbstractBlock.Settings.create().strength(2f).requiresTool().sounds(BlockSoundGroup.WOOD).mapColor(MapColor.OAK_TAN).burnable()));

    public static final Block APPLE_DOOR = registerBlock("apple_door", new DoorBlock(BlockSetType.OAK,
            AbstractBlock.Settings.create().strength(2f).requiresTool().sounds(BlockSoundGroup.WOOD).mapColor(MapColor.OAK_TAN).nonOpaque().burnable()));

    public static final Block APPLE_TRAPDOOR = registerBlock("apple_trapdoor", new TrapdoorBlock(BlockSetType.OAK,
            AbstractBlock.Settings.create().strength(2f).requiresTool().sounds(BlockSoundGroup.WOOD).mapColor(MapColor.OAK_TAN).nonOpaque().burnable()));




    public static Block createLogBlock(MapColor topMapColor, MapColor sideMapColor) {
        return new PillarBlock(
                AbstractBlock.Settings.create()
                        .mapColor(state -> state.get(PillarBlock.AXIS) == Direction.Axis.Y ? topMapColor : sideMapColor)
                        .instrument(NoteBlockInstrument.BASS)
                        .strength(2.0F)
                        .sounds(BlockSoundGroup.WOOD)
                        .burnable()
        );
    }

    public static Block createLeavesBlock(BlockSoundGroup soundGroup) {
        return new LeavesBlock(
                AbstractBlock.Settings.create()
                        .mapColor(MapColor.DARK_GREEN)
                        .strength(0.3F)
                        .ticksRandomly()
                        .sounds(soundGroup)
                        .nonOpaque()
                        .allowsSpawning(Blocks::canSpawnOnLeaves)
                        .suffocates(Blocks::never)
                        .blockVision(Blocks::never)
                        .burnable()
                        .pistonBehavior(PistonBehavior.DESTROY)
                        .solidBlock(Blocks::never)
        );
    }

    public static Block createBurntLeavesBlock(BlockSoundGroup soundGroup) {
        return new LeavesBlock(
                AbstractBlock.Settings.create()
                        .mapColor(MapColor.TERRACOTTA_BLACK)
                        .strength(0.1F)
                        .ticksRandomly()
                        .sounds(soundGroup)
                        .nonOpaque()
                        .allowsSpawning(Blocks::canSpawnOnLeaves)
                        .suffocates(Blocks::never)
                        .blockVision(Blocks::never)
                        .burnable()
                        .pistonBehavior(PistonBehavior.DESTROY)
                        .solidBlock(Blocks::never)
        );
    }

    public static Block createBurntLogBlock(MapColor topMapColor, MapColor sideMapColor) {
        return new PillarBlock(
                AbstractBlock.Settings.create()
                        .mapColor(state -> state.get(PillarBlock.AXIS) == Direction.Axis.Y ? topMapColor : sideMapColor)
                        .instrument(NoteBlockInstrument.BASS)
                        .strength(1.7F)
                        .sounds(BlockSoundGroup.WOOD)
                        .burnable()
        );
    }

    //Flowers:
    public static final Block WOOD_ANEMONE = registerBlock("wood_anemone", new CarpetFlowerBlock(StatusEffects.RESISTANCE, 0f, AbstractBlock.Settings.create().mapColor(MapColor.EMERALD_GREEN).noCollision().pistonBehavior(PistonBehavior.DESTROY).sounds(BlockSoundGroup.GRASS)));
    public static final Block YELLOW_SWAN_ORCHID = registerBlock("yellow_swan_orchid", new WallFlowerBlock(AbstractBlock.Settings.create().mapColor(MapColor.YELLOW).noCollision().pistonBehavior(PistonBehavior.DESTROY).sounds(BlockSoundGroup.GRASS)));
    public static final Block CARDINAL_FLOWER = registerBlock("cardinal_flower", new TallHexFlower(AbstractBlock.Settings.create().mapColor(MapColor.RED).noCollision().offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY).sounds(BlockSoundGroup.GRASS).dynamicBounds()));
    public static final Block BUTTERFLY_MILKWEED = registerBlock("butterfly_milkweed", new TallHexFlower(AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_ORANGE).noCollision().offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY).sounds(BlockSoundGroup.GRASS).dynamicBounds()));
    public static final Block GOLDENROD = registerBlock("goldenrod", new TallHexFlower(AbstractBlock.Settings.create().mapColor(MapColor.YELLOW).noCollision().offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY).sounds(BlockSoundGroup.GRASS).dynamicBounds()));
    public static final Block INDIAN_PAINTBRUSH = registerBlock("indian_paintbrush", new FlowerBlock(StatusEffects.RESISTANCE, 0f, AbstractBlock.Settings.create().mapColor(MapColor.RED).noCollision().offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY).sounds(BlockSoundGroup.GRASS)));
    public static final Block THISTLE = registerBlock("thistle", new ThistleBlock(AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_PURPLE).noCollision().offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY).sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));
    public static final Block BLUEBERRY_BUSH = registerBlock("blueberry_bush", new BlueberryBushBlock(AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).noCollision().offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY).sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));
    public static final Block BROADLEAF_PLANTAIN = registerBlock("broadleaf_plantain", new ModSmallPlantBlock(AbstractBlock.Settings.create().mapColor(MapColor.GREEN).noCollision().offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY).sounds(BlockSoundGroup.GRASS).replaceable()));
    public static final Block TRIM_GRASS = registerBlock("trim_grass", new ModSmallPlantBlock(AbstractBlock.Settings.create().mapColor(MapColor.GREEN).noCollision().offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY).sounds(BlockSoundGroup.GRASS).replaceable()));
    public static final Block SHRUB = registerBlock("shrub", new ModMediumPlantBlock(AbstractBlock.Settings.create().mapColor(MapColor.GREEN).pistonBehavior(PistonBehavior.DESTROY).sounds(BlockSoundGroup.GRASS)));
    public static final Block GRASS_CARPET = registerBlock("grass_carpet", new ModCarpetPlantBlock(AbstractBlock.Settings.create().mapColor(MapColor.GREEN).pistonBehavior(PistonBehavior.DESTROY).sounds(BlockSoundGroup.GRASS).replaceable().noCollision()));
    public static final Block IVY = registerBlock("ivy", new IvyBlock(AbstractBlock.Settings.create().mapColor(MapColor.GREEN).pistonBehavior(PistonBehavior.DESTROY).sounds(BlockSoundGroup.GRASS).replaceable().noCollision()));
    public static final Block POISON_IVY = registerBlock("poison_ivy", new PoisonIvyBlock(AbstractBlock.Settings.create().mapColor(MapColor.GREEN).pistonBehavior(PistonBehavior.DESTROY).sounds(BlockSoundGroup.GRASS).replaceable().noCollision()));
    public static final Block WITHERED_IVY = registerBlock("withered_ivy", new WitherIvyBlock(AbstractBlock.Settings.create().mapColor(MapColor.BLACK).pistonBehavior(PistonBehavior.DESTROY).sounds(BlockSoundGroup.GRASS).replaceable().noCollision()));
    public static final Block CLOVER = registerBlock("clover", new ModCarpetPlantBlock(AbstractBlock.Settings.create().mapColor(MapColor.GREEN).pistonBehavior(PistonBehavior.DESTROY).sounds(BlockSoundGroup.GRASS).replaceable().noCollision()));
    public static final Block TALL_PLAINS_GRASS = registerBlock("tall_plains_grass", new TallHexFlower(AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_YELLOW).noCollision().offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY).sounds(BlockSoundGroup.GRASS).dynamicBounds()));
    public static final Block MARIGOLD = registerBlock("marigold", new FlowerBlock(StatusEffects.RESISTANCE, 0f, AbstractBlock.Settings.create().mapColor(MapColor.ORANGE).noCollision().offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY).sounds(BlockSoundGroup.GRASS)));
    public static final Block LARGE_BUSH_GRASS = registerBlock("large_bush_grass", new ModMediumPlantBlock(AbstractBlock.Settings.create().mapColor(MapColor.GREEN).noCollision().offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY).sounds(BlockSoundGroup.GRASS)));
    public static final Block DUNE_GRASS = registerBlock("dune_grass", new ModSandPlant(AbstractBlock.Settings.create().mapColor(MapColor.OAK_TAN).noCollision().offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY).sounds(BlockSoundGroup.GRASS)));
    public static final Block BUSHY_FERN = registerBlock("bushy_fern", new ModMediumPlantBlock(AbstractBlock.Settings.create().mapColor(MapColor.GREEN).noCollision().offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY).sounds(BlockSoundGroup.GRASS)));

    public static final Set<Block> MOD_TRANS_BLOCKS = Set.of(
            CARDINAL_FLOWER,
            GOLDENROD,
            WOOD_ANEMONE,
            YELLOW_SWAN_ORCHID,
            INDIAN_PAINTBRUSH,
            THISTLE,
            BUTTERFLY_MILKWEED,
            BLUEBERRY_BUSH,
            BROADLEAF_PLANTAIN,
            TRIM_GRASS,
            SHRUB,
            GRASS_CARPET,
            IVY,
            POISON_IVY,
            WITHERED_IVY,
            CLOVER,
            TALL_PLAINS_GRASS,
            APPLE_DOOR,
            APPLE_TRAPDOOR,
            MARIGOLD,
            LARGE_BUSH_GRASS,
            DUNE_GRASS,
            BUSHY_FERN
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
