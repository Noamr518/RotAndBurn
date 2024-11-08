package net.noamr.rotandburn.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.noamr.rotandburn.RotAndBurn;
import net.noamr.rotandburn.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup PLANTS = Registry.register(Registries.ITEM_GROUP, Identifier.of(RotAndBurn.MOD_ID, "rot_and_burn_plants"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.YELLOW_SWAN_ORCHID))
                    .displayName(Text.translatable("itemgroup.rotandburn.rot_and_burn_plants"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.GRASS_SEEDS);
                        entries.add(ModBlocks.WOOD_ANEMONE);
                        entries.add(ModBlocks.YELLOW_SWAN_ORCHID);
                        entries.add(ModBlocks.CARDINAL_FLOWER);
                        entries.add(ModBlocks.GOLDENROD);
                        entries.add(ModBlocks.INDIAN_PAINTBRUSH);
                        entries.add(ModBlocks.THISTLE);
                        entries.add(ModBlocks.BUTTERFLY_MILKWEED);
                        entries.add(ModBlocks.BLUEBERRY_BUSH);
                        entries.add(ModBlocks.BROADLEAF_PLANTAIN);
                        entries.add(ModBlocks.TRIM_GRASS);
                        entries.add(ModBlocks.GRASS_CARPET);
                        entries.add(ModBlocks.SHRUB);
                        entries.add(ModBlocks.IVY);
                        entries.add(ModBlocks.POISON_IVY);
                        entries.add(ModBlocks.WITHERED_IVY);
                        entries.add(ModBlocks.APPLE_LEAVES);
                        entries.add(ModBlocks.CLOVER);
                        entries.add(ModItems.FOUR_LEAF_CLOVER);
                        entries.add(ModBlocks.TALL_PLAINS_GRASS);
                        entries.add(ModBlocks.BURNT_LEAVES);
                        entries.add(ModBlocks.MARIGOLD);
                        entries.add(ModBlocks.LARGE_BUSH_GRASS);
                        entries.add(ModBlocks.DUNE_GRASS);
                        entries.add(ModBlocks.BUSHY_FERN);

                    }).build());

    public static final ItemGroup INGREDIENTS = Registry.register(Registries.ITEM_GROUP, Identifier.of(RotAndBurn.MOD_ID, "rot_and_burn_ingredients"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.AMETHYST_DUST))
                    .displayName(Text.translatable("itemgroup.rotandburn.rot_and_burn_ingredients"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.ASH);
                        entries.add(ModItems.AMETHYST_DUST);
                        entries.add(ModItems.SALT);
                        entries.add(ModItems.CALCITE_DUST);
                        entries.add(ModItems.CHARCOAL_DUST);
                        entries.add(ModItems.COPPER_OXIDE);
                        entries.add(ModItems.LAPIS_DUST);
                        entries.add(ModItems.YELLOW_OCHRE);
                        entries.add(ModItems.FLAME_PASTE);
                        entries.add(ModItems.GARNET);
                        entries.add(ModItems.RUIN_TRIM);
                    }).build());

    public static final ItemGroup BLOCKS = Registry.register(Registries.ITEM_GROUP, Identifier.of(RotAndBurn.MOD_ID, "rot_and_burn_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.SHALE))
                    .displayName(Text.translatable("itemgroup.rotandburn.rot_and_burn_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.SALT_BLOCK);
                        entries.add(ModBlocks.ASH_BLOCK);
                        entries.add(ModBlocks.ASH_LAYER);
                        entries.add(ModBlocks.SHALE);
                        entries.add(ModBlocks.SHALE_FOSSIL);
                        entries.add(ModBlocks.YELLOW_EARTH);
                        entries.add(ModBlocks.BURNT_LOG);
                        entries.add(ModBlocks.BURNT_WOOD);
                        entries.add(ModBlocks.STRIPPED_BURNT_LOG);
                        entries.add(ModBlocks.STRIPPED_BURNT_WOOD);
                        entries.add(ModBlocks.BURNT_WOOD_PLANKS);
                        entries.add(ModBlocks.BURNT_WOOD_STAIRS);
                        entries.add(ModBlocks.BURNT_WOOD_SLAB);
                        entries.add(ModBlocks.BURNT_WOOD_FENCE);
                        entries.add(ModBlocks.BURNT_WOOD_FENCE_GATE);
                        entries.add(ModBlocks.BURNT_WOOD_PRESSURE_PLATE);
                        entries.add(ModBlocks.BURNT_WOOD_BUTTON);
                        entries.add(ModBlocks.APPLE_LOG);
                        entries.add(ModBlocks.APPLE_WOOD);
                        entries.add(ModBlocks.STRIPPED_APPLE_LOG);
                        entries.add(ModBlocks.STRIPPED_APPLE_WOOD);
                        entries.add(ModBlocks.APPLE_PLANKS);
                        entries.add(ModBlocks.APPLE_STAIRS);
                        entries.add(ModBlocks.APPLE_SLAB);
                        entries.add(ModBlocks.APPLE_FENCE);
                        entries.add(ModBlocks.APPLE_FENCE_GATE);
                        entries.add(ModBlocks.APPLE_PRESSURE_PLATE);
                        entries.add(ModBlocks.APPLE_BUTTON);
                        entries.add(ModBlocks.APPLE_DOOR);
                        entries.add(ModBlocks.APPLE_TRAPDOOR);

                    }).build());

    public static final ItemGroup FOOD = Registry.register(Registries.ITEM_GROUP, Identifier.of(RotAndBurn.MOD_ID, "rot_and_burn_food"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.BLUEBERRY))
                    .displayName(Text.translatable("itemgroup.rotandburn.rot_and_burn_food"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.BLUEBERRY);
                        entries.add(ModItems.BLUEBERRY_PIE);
                    }).build());

    public static void registerItemGroups(){
        RotAndBurn.LOGGER.info("Registering Item Groups for " + RotAndBurn.MOD_ID);
    }
}
