package net.noamr.rotandburn.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.noamr.rotandburn.RotAndBurn;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> CARPET_FLOWERS = createTag("carpet_flowers");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(RotAndBurn.MOD_ID, name));
        }
    }
    public static class Items {

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(RotAndBurn.MOD_ID, name));
        }
    }
}
