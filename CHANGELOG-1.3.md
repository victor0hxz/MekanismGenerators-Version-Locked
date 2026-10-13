# Mekanism Generators Version Locked 1.3

- Fix reactor logic adapter redstone changes: use real neighbor signal updates, including comparator/weak signal notifications, instead of the block-entity-only onNeighborChange callback.
- Fission and fusion outputs notify their redstone circuits when the logical output changes, without requiring wire replacement.
- Dedicated regression: five damage-output rising/falling cycles and critical waste activation/clearing with real redstone dust.
- Keep the 1.2 turbine balance, capacity/conservation fixes and connected reactor glass. Do not change reactor thresholds or world radiation data.
