# Mekanism Generators Version Locked — 1.2

- Rebalance industrial turbine generation with a configurable power multiplier, default 100. With the supplied maximum-size design (28 blades, 7 coils, 345 vents), the default settings produce 55.2 MFE/t at 11,040,000 mB/t of steam, instead of 552 kFE/t.
- Keep the normal steam throughput and storage by default; existing steam contents are preserved. This is a deliberate increase in energy produced per mB, not a display-only correction.
- Add `turbineGenerationMultiplier` (default 100) and optional `turbineThroughputMultiplier` (default 1) in `config/MekanismGenerators/version-locked-balance.toml`. Setting generation to 1 restores the previous efficiency. Throughput scales steam processing and storage independently.
- Both current production and maximum production use the same configured multiplier. The energy buffer automatically accommodates four ticks of maximum production.
- Generate energy only from the whole mB of steam actually consumed, preventing fractional-flow rounding from creating unpaid energy with an almost-full buffer.
- Preserve 1.1 transaction checks and connected reactor glass.

Validation: dedicated-server tests verify configuration registration/loading, 55.2 MFE/t real generation at the existing steam flow, equality of stored energy and reported generation, and zero steam consumption with a full energy buffer. JMM client calculations match generation, flow, steam capacity and energy capacity.

Replace the older Generators JAR on clients and server. Keep Mekanism core 2.7 or newer. Install JMM port4 for accurate predictions. Minecraft 26.1.2 / NeoForge / Java 25. Original Mekanism credits and MIT license preserved.
