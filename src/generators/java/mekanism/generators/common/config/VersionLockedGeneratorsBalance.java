package mekanism.generators.common.config;

import net.neoforged.fml.ModContainer;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;

/** Configurable generation and optional throughput for the Version Locked industrial turbine. */
public final class VersionLockedGeneratorsBalance {
    public static final ModConfigSpec SPEC;
    private static final ModConfigSpec.IntValue THROUGHPUT;
    private static final ModConfigSpec.IntValue GENERATION;

    static {
        var builder = new ModConfigSpec.Builder();
        THROUGHPUT = builder.comment("Industrial turbine steam throughput and steam-storage multiplier. Energy per mB stays unchanged. Higher generation requires proportionally more steam. 1 restores the previous throughput.")
                .defineInRange("turbineThroughputMultiplier", 1, 1, 1000);
        GENERATION = builder.comment("Turbine power multiplier, applied to both actual generation and its maximum reading. Does not increase the steam rate. 1 restores the previous energy per mB.")
                .defineInRange("turbineGenerationMultiplier", 100, 1, 1000);
        SPEC = builder.build();
    }

    private VersionLockedGeneratorsBalance() {}

    public static int generationMultiplier() {
        return SPEC.isLoaded() ? GENERATION.get() : GENERATION.getDefault();
    }

    public static void register(ModContainer container) {
        container.registerConfig(ModConfig.Type.SERVER, SPEC, "MekanismGenerators/version-locked-balance.toml");
    }

    public static int multiplier() {
        return SPEC.isLoaded() ? THROUGHPUT.get() : THROUGHPUT.getDefault();
    }
}
