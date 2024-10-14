package net.noamr.rotandburn.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;

import java.util.List;

public class FlamePasteItem extends Item {

    public FlamePasteItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.rotandburn.flame_paste.shift_down_line1"));
            tooltip.add(Text.translatable("tooltip.rotandburn.flame_paste.shift_down_line2"));
            tooltip.add(Text.translatable("tooltip.rotandburn.flame_paste.shift_down_line3"));
        } else {
            tooltip.add(Text.translatable("tooltip.rotandburn.flame_paste"));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}
