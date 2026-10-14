# Generators 26.1.2-1.4 fission failure safety

Changed only GeneratorsConfig and FissionReactorMultiblockData production classes. Based on Generators 26.1.2-1.3; original generated computer handlers, logic adapter fix and unrelated jar entries are retained.

Default `fission_reactor.meltdowns.safeFailures=true (mekanism-generators-server.toml)` enables a one-shot reactor failure at 100% damage. Damage is clamped to 0-100, including existing excessive damage. Reactor shuts down and uses its existing persisted `forceDisable` cache latch. Nearby entities retain explosion damage; the explosion uses vanilla NONE block interaction and no fire. No core meltdown queue and no failure radiation are created. Existing world radiation is untouched.

Reactor remains disabled through cache serialization/rebuilding until damage repairs completely to zero and temperature drops below 1200 K. Activation at damage >=100 is denied before the first damage tick. Existing `meltdowns.enabled=false` suppresses the failure explosion while retaining shutdown. Explicit `safeFailures=false` selects original legacy meltdown behavior.

Validation: isolated NeoForge 26.1.2.109 real dedicated server with Core 26.1.2-2.8. Original Generators 1.3 fails the 40000-to-100 damage regression. Patched jar validates single explosion, nearby living entity damage, unchanged reactor/stone blocks, 3000 additional hot damage ticks without repeat/growth, no core meltdown queue, unchanged environmental radiation, cache NBT save/load latch, denied activation, partial-repair lock, fully repaired safe restart and disabled-meltdown suppression. Test-only fixture remains outside production jar.
