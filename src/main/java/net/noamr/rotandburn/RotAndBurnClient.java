package net.noamr.rotandburn;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockRenderView;
import net.noamr.rotandburn.block.ModBlocks;

public class RotAndBurnClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModBlocks.MOD_TRANS_BLOCKS.forEach(block ->
                BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout()));

        ColorProviderRegistry.BLOCK.register(
                (BlockState state, BlockRenderView world, BlockPos pos, int tintIndex) -> {
                    if (world != null && pos != null) {
                        return BiomeColors.getGrassColor(world, pos);
                    }
                    // Return a default greenish color if the world or pos is null, like in item form.
                    return 0x00FF00;
                },
                ModBlocks.CARDINAL_FLOWER,
                ModBlocks.GOLDENROD,
                ModBlocks.INDIAN_PAINTBRUSH,
                ModBlocks.BUTTERFLY_MILKWEED
        );
    }

}
