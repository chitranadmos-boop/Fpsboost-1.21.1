package com.fpsboost;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.command.CommandRegistrationCallback;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class FpsBoostMod implements ModInitializer {

    public static final String MOD_ID = "fpsboost";

    @Override
    public void onInitialize() {
        // Initialize server-side commands
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            CommandRegistry.registerCommands(dispatcher);
        });
    }
}
