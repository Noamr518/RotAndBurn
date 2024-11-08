package net.noamr.rotandburn.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.noamr.rotandburn.RotAndBurn;
import net.noamr.rotandburn.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerSmithingTrimRecipe(exporter, ModItems.RUIN_TRIM, Identifier.of(RotAndBurn.MOD_ID, "ruin"));
    }
}
