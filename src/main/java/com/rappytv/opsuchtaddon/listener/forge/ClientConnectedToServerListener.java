package com.rappytv.opsuchtaddon.listener.forge;

import com.google.gson.JsonObject;
import com.rappytv.opsuchtaddon.OPSuchtAddon;
import com.rappytv.opsuchtaddon.settings.PlayerSettings;
import lombok.AllArgsConstructor;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;

@AllArgsConstructor
public class ClientConnectedToServerListener {

    private final OPSuchtAddon addon;

    @SubscribeEvent
    public void onPlayerLeftServer(FMLNetworkEvent.ClientConnectedToServerEvent event) {
        Minecraft.getMinecraft().addScheduledTask(new Runnable() {
            @Override
            public void run() {
                if (!addon.getOpSuchtLabyServer().getConnected()) return;

                PlayerSettings.setPlayerSettings(new JsonObject());
            }
        });
    }
}
