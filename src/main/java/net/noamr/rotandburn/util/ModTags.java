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
        public static final TagKey<Block> APPLE_LOGS = createTag("apple_logs");
        public static final TagKey<Block> BURNT_LOGS = createTag("burnt_logs");
        public static final TagKey<Block> BURNT_BLOCKS = createTag("burnt_blocks");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(RotAndBurn.MOD_ID, name));
        }
    }
    public static class Items {
        public static final TagKey<Item> APPLE_LOGS = createTag("apple_logs");
        public static final TagKey<Item> BURNT_LOGS = createTag("burnt_logs");
        public static final TagKey<Item> BURNT_BLOCKS = createTag("burnt_blocks");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(RotAndBurn.MOD_ID, name));
        }
    }
}
