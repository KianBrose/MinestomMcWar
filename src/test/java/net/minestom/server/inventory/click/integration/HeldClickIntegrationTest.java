package net.minestom.server.inventory.click.integration;

import net.minestom.server.api.Env;
import net.minestom.server.api.EnvTest;
import net.minestom.server.coordinate.Pos;
import net.minestom.server.entity.Player;
import net.minestom.server.event.inventory.InventoryPreClickEvent;
import net.minestom.server.inventory.Inventory;
import net.minestom.server.inventory.InventoryType;
import net.minestom.server.inventory.click.ClickType;
import net.minestom.server.item.ItemStack;
import net.minestom.server.item.Material;
import net.minestom.server.network.packet.client.play.ClientClickWindowPacket;
import net.minestom.server.utils.inventory.PlayerInventoryUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@EnvTest
public class HeldClickIntegrationTest {

    @Test
    public void heldSelf(Env env) {
        var instance = env.createFlatInstance();
        var player = env.createPlayer(instance, new Pos(0, 40, 0));
        var inventory = player.getInventory();
        var listener = env.listen(InventoryPreClickEvent.class);
        inventory.setItemStack(1, ItemStack.of(Material.DIAMOND));
        inventory.setItemStack(2, ItemStack.of(Material.GOLD_INGOT));
        inventory.setItemStack(5, ItemStack.of(Material.DIAMOND));
        // Empty
        {
            listener.followup(event -> {
                assertNull(event.getInventory()); // Player inventory
                assertEquals(3, event.getSlot());
                assertEquals(ClickType.CHANGE_HELD, event.getClickType());

                assertEquals(ItemStack.AIR, inventory.getCursorItem());
                assertEquals(ItemStack.AIR, event.getCursorItem());

                assertEquals(ItemStack.AIR, event.getClickedItem());
            });
            heldClick(player, 3, 4);
        }
        // Swap air
        {
            listener.followup(event -> {
                assertNull(event.getInventory()); // Player inventory
                assertEquals(1, event.getSlot());
                assertEquals(ClickType.CHANGE_HELD, event.getClickType());

                assertEquals(ItemStack.AIR, inventory.getCursorItem());
                assertEquals(ItemStack.AIR, event.getCursorItem());

                assertEquals(ItemStack.of(Material.DIAMOND), event.getClickedItem());
            });
            heldClick(player, 1, 0);
            assertEquals(ItemStack.AIR, inventory.getCursorItem());
            assertEquals(ItemStack.AIR, inventory.getItemStack(1));
            assertEquals(ItemStack.of(Material.DIAMOND), inventory.getItemStack(0));
        }
        // Swap items
        {
            listener.followup(event -> {
                assertEquals(0, event.getSlot());
                assertEquals(ItemStack.AIR, inventory.getCursorItem());
                assertEquals(ItemStack.AIR, inventory.getItemStack(1));
            });
            heldClick(player, 0, 2);
            assertEquals(ItemStack.AIR, inventory.getCursorItem());
            assertEquals(ItemStack.AIR, inventory.getItemStack(1));
            assertEquals(ItemStack.of(Material.DIAMOND), inventory.getItemStack(2));
            assertEquals(ItemStack.of(Material.GOLD_INGOT), inventory.getItemStack(0));
        }
        // Cancel event
        {
            listener.followup(event -> event.setCancelled(true));
            heldClick(player, 2, 0);
            assertEquals(ItemStack.AIR, inventory.getCursorItem());
            assertEquals(ItemStack.AIR, inventory.getItemStack(1));
            assertEquals(ItemStack.of(Material.DIAMOND), inventory.getItemStack(2));
            assertEquals(ItemStack.of(Material.GOLD_INGOT), inventory.getItemStack(0));
        }
    }

    @Test
    public void heldExternal(Env env) {
        var instance = env.createFlatInstance();
        var player = env.createPlayer(instance, new Pos(0, 40, 0));
        var inventory = new Inventory(InventoryType.HOPPER, "test");
        var playerInv = player.getInventory();
        player.openInventory(inventory);
        var listener = env.listen(InventoryPreClickEvent.class);
        inventory.setItemStack(1, ItemStack.of(Material.DIAMOND));
        inventory.setItemStack(2, ItemStack.of(Material.GOLD_INGOT));
        inventory.setItemStack(4, ItemStack.of(Material.DIAMOND));
        // Empty
        {
            listener.followup(event -> {
                assertEquals(inventory, event.getInventory());
                assertEquals(0, event.getSlot());
                assertEquals(ClickType.CHANGE_HELD, event.getClickType());
                assertEquals(ItemStack.AIR, inventory.getCursorItem(player));
            });
            heldClickOpenInventory(player, 0, 0);
            assertEquals(ItemStack.AIR, inventory.getCursorItem(player));
            assertEquals(ItemStack.AIR, inventory.getItemStack(0));
        }
        // Swap empty
        {
            listener.followup(event -> {
                assertEquals(inventory, event.getInventory());
                assertEquals(1, event.getSlot());
                assertEquals(ItemStack.AIR, inventory.getCursorItem(player));
            });
            heldClickOpenInventory(player, 1, 0);
            assertEquals(ItemStack.AIR, inventory.getCursorItem(player));
            assertEquals(ItemStack.AIR, inventory.getItemStack(1));
            assertEquals(ItemStack.of(Material.DIAMOND), playerInv.getItemStack(0));
        }
        // Swap items
        {
            listener.followup(event -> {
                assertEquals(inventory, event.getInventory());
                assertEquals(2, event.getSlot());
                assertEquals(ItemStack.AIR, inventory.getCursorItem(player));
            });
            heldClickOpenInventory(player, 2, 0);
            assertEquals(ItemStack.AIR, inventory.getCursorItem(player));
            assertEquals(ItemStack.of(Material.DIAMOND), inventory.getItemStack(2));
            assertEquals(ItemStack.of(Material.GOLD_INGOT), playerInv.getItemStack(0));
        }
        // Cancel event
        {
            listener.followup(event -> event.setCancelled(true));
            heldClickOpenInventory(player, 2, 0);
            assertEquals(ItemStack.AIR, inventory.getCursorItem(player));
            assertEquals(ItemStack.of(Material.DIAMOND), inventory.getItemStack(2));
            assertEquals(ItemStack.of(Material.GOLD_INGOT), playerInv.getItemStack(0));
        }
    }

    private void heldClickOpenInventory(Player player, int slot, int target) {
        _heldClick(player.getOpenInventory(), true, player, slot, target);
    }

    private void heldClick(Player player, int slot, int target) {
        _heldClick(player.getOpenInventory(), false, player, slot, target);
    }

    private void _heldClick(Inventory openInventory, boolean clickOpenInventory, Player player, int slot, int target) {
        final byte windowId = openInventory != null ? openInventory.getWindowId() : 0;
        if (clickOpenInventory) {
            assert openInventory != null;
            // Do not touch slot
        } else {
            int offset = openInventory != null ? openInventory.getInnerSize() : 0;
            slot = PlayerInventoryUtils.convertToPacketSlot(slot);
            if (openInventory != null) {
                slot = slot - 9 + offset;
            }
        }
        player.addPacketToQueue(new ClientClickWindowPacket(windowId, 0, (short) slot, (byte) target,
                ClientClickWindowPacket.ClickType.SWAP, List.of(), ItemStack.AIR));
        player.interpretPacketQueue();
    }
}
