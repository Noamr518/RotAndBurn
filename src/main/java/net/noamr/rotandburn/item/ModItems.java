package net.noamr.rotandburn.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.util.Identifier;
import net.noamr.rotandburn.RotAndBurn;
import net.noamr.rotandburn.item.custom.FlamePasteItem;
import net.noamr.rotandburn.item.custom.FourLeafCloverItem;
import net.noamr.rotandburn.item.custom.GrassSeedsItem;

public class ModItems {
    public static final Item ASH = registerItem("ash", new Item(new Item.Settings()));
    public static final Item AMETHYST_DUST = registerItem("amethyst_dust", new Item(new Item.Settings()));
    public static final Item SALT = registerItem("salt", new Item(new Item.Settings()));
    public static final Item CALCITE_DUST = registerItem("calcite_dust", new Item(new Item.Settings()));
    public static final Item CHARCOAL_DUST = registerItem("charcoal_dust", new Item(new Item.Settings()));
    public static final Item COPPER_OXIDE = registerItem("copper_oxide", new Item(new Item.Settings()));
    public static final Item LAPIS_DUST = registerItem("lapis_dust", new Item(new Item.Settings()));
    public static final Item YELLOW_OCHRE = registerItem("yellow_ochre", new Item(new Item.Settings()));
    public static final Item GARNET = registerItem("garnet", new Item(new Item.Settings()));

    public static final Item RUIN_TRIM = registerItem("ruin_trim", SmithingTemplateItem.of(Identifier.of(
            RotAndBurn.MOD_ID, "ruin"), FeatureFlags.VANILLA));

    public static final Item GRASS_SEEDS = registerItem("grass_seeds", new GrassSeedsItem(new Item.Settings()));
    public static final Item BLUEBERRY = registerItem("blueberry", new Item(new Item.Settings().food(ModFoodComponents.BLUEBERRY)));
    public static final Item BLUEBERRY_PIE = registerItem("blueberry_pie", new Item(new Item.Settings().food(ModFoodComponents.BLUEBERRY_PIE)));
    public static final Item FLAME_PASTE = registerItem("flame_paste", new FlamePasteItem(new Item.Settings().fireproof()));
    public static final Item FOUR_LEAF_CLOVER = registerItem("four_leaf_clover", new FourLeafCloverItem(new Item.Settings()));



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(RotAndBurn.MOD_ID, name), item);
    }

    public static void registerModItems() {
        RotAndBurn.LOGGER.info("Registering Mod Items for " + RotAndBurn.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            //entries.add(ASH);
        });
    }
}