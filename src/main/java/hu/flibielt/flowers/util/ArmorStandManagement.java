package hu.flibielt.flowers.util;

import org.bukkit.Location;
import org.bukkit.Material;

public interface ArmorStandManagement {
    void newArmorStand(Location location, Material material);
    void newArmorStand(Location location, Material material, Boolean small, Boolean visible);
}
