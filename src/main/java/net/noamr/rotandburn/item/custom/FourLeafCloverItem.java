package net.noamr.rotandburn.item.custom;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;

public class FourLeafCloverItem extends Item {
    public FourLeafCloverItem(Settings settings) {
        super(settings);

        ServerTickEvents.END_SERVER_TICK.register(server -> {
            for (PlayerEntity player : server.getPlayerManager().getPlayerList()) {
                World world = player.getWorld();

                if (!world.isClient) {
                    boolean hasClover = false;

                    for (ItemStack itemStack : player.getInventory().main) {
                        if (itemStack.getItem() instanceof FourLeafCloverItem) {
                            hasClover = true;
                            break;
                        }
                    }

                    // Apply or remove the Luck effect
                    if (hasClover) {
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.LUCK, 180, 5, true, false));
                    } else {
                        player.removeStatusEffect(StatusEffects.LUCK);
                    }
                }
            }
        });
    }
}
