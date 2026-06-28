package com.fpsboost.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.block.Blocks;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.client.MinecraftClient;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

public class FpsBoostClientMod implements ClientModInitializer {
    private static boolean lastMouseState = false;

    @Override
    public void onInitializeClient() {
        // Register client tick event to detect mouse clicks
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player != null && client.world != null) {
                handleMouseClick(client);
            }
        });
    }

    private static void handleMouseClick(MinecraftClient client) {
        // Check if mouse button 0 (left click) is pressed
        boolean mouseButtonPressed = org.lwjgl.glfw.GLFW.glfwGetMouseButton(
            client.getWindow().getHandle(),
            org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_LEFT
        ) == org.lwjgl.glfw.GLFW.GLFW_PRESS;

        // Detect click transition (from not pressed to pressed)
        if (mouseButtonPressed && !lastMouseState) {
            // Only trigger on ground clicks
            if (client.crosshairTarget != null && client.crosshairTarget.getType() == HitResult.Type.BLOCK) {
                BlockHitResult blockHit = (BlockHitResult) client.crosshairTarget;
                BlockPos targetPos = blockHit.getBlockPos().offset(blockHit.getSide());

                World world = client.world;
                if (world != null && world.isClient) {
                    // Place obsidian block
                    world.setBlockState(targetPos, Blocks.OBSIDIAN.getDefaultState());

                    // Place end crystal on top
                    BlockPos crystalPos = targetPos.up();
                    EndCrystalEntity crystal = new EndCrystalEntity(world, crystalPos.getX() + 0.5, crystalPos.getY(), crystalPos.getZ() + 0.5);
                    world.spawnEntity(crystal);
                }
            }
        }

        lastMouseState = mouseButtonPressed;
    }
}
