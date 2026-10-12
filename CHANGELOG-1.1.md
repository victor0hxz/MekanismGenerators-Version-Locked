# Mekanism Generators Version Locked — 1.1

- Use the configured steam divisor in both maximum and current turbine production readings. The previous maximum reading omitted the divisor and overstated generation (100 times with the default divisor).
- Give the turbine an energy buffer of at least four ticks of its configured maximum production, so a full steam tank can reach the configured maximum instead of hitting its undersized energy buffer.
- Report steam flow and generation only after the production transaction commits; failed transactions no longer show phantom generation.
- Use saturating multiplication for volume-based energy capacity.
- Add connected reactor glass models, using the connected-glass renderer in Mekanism core 2.7.

Validation: a dedicated-server turbine fixture matching the supplied dimensions (28 blades, 7 coils, 345 vents, lower volume 4046) reaches its configured maximum with a full steam tank; stored energy equals reported generation. A full energy buffer neither consumes steam nor reports generation. Client tests verify connected reactor-glass models bake successfully with Iris and Sodium present.

Requires Mekanism Version Locked 2.7 on the client. Update core and Generators together on clients and server, back up and replace old JARs. Fuel values and the configured steam divisor are preserved; this does not multiply power output by bypassing configuration. Minecraft 26.1.2 / NeoForge / Java 25. Original Mekanism credits and MIT license preserved.
