package hu.flibielt.flowers;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;

import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        System.out.println("FLOWERS ON EVERYTHING IS ENABLED!");
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onCreateFlower(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();
        Material itemInHand;

        if (action.equals(Action.RIGHT_CLICK_BLOCK)) {
            itemInHand = player.getInventory().getItemInMainHand().getType();
            if (itemInHand.equals(Material.STICK)) {
                Location location = event.getClickedBlock().getLocation();
                location.setY(location.getBlockY() + 1);
                location.setX(location.getBlockX() + 0.5);
                location.setZ(location.getBlockZ() + 0.5);
                System.out.println(location.toString());
                createNewArmorStand(location, true, false);
            }
        }
    }

    private void createNewArmorStand(Location location, boolean visible, boolean small) {
        ArmorStand armorStand = location.getWorld().spawn(location, ArmorStand.class);

        armorStand.setArms(true);
        armorStand.setVisible(visible);
        armorStand.setSmall(small);
        armorStand.setItemInHand(new ItemStack(Material.CORNFLOWER));

    }
}
