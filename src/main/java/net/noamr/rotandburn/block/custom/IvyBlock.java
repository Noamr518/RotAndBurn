package net.noamr.rotandburn.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.LichenGrower;
import net.minecraft.block.MultifaceGrowthBlock;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.noamr.rotandburn.block.ModBlocks;
import net.noamr.rotandburn.item.ModItems;

public class IvyBlock extends MultifaceGrowthBlock implements Fertilizable {
    public IvyBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends MultifaceGrowthBlock> getCodec() {
        return null;
    }

    @Override
    public LichenGrower getGrower() {
        return null;
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        // Specify the item to drop, replace 'YOUR_PLANT_ITEM' with the item of your plant
        ItemStack drop = new ItemStack(this.asItem());

        // Spawn the item entity at the IvyBlock's position
        ItemEntity itemEntity = new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, drop);
        world.spawnEntity(itemEntity);
    }
}
