package com.rappytv.opsuchtaddon.listener.forge;

import com.rappytv.opsuchtaddon.OPSuchtAddon;
import lombok.AllArgsConstructor;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;

@AllArgsConstructor
public class ClientDisconnectionFromServerEvent {

    private final OPSuchtAddon addon;

    @SubscribeEvent
    public void onPlayerLeftServer(FMLNetworkEvent.ClientDisconnectionFromServerEvent event) {
        Minecraft.getMinecraft().addScheduledTask(() -> {
            if (!addon.getOpSuchtLabyServer().getConnected()) return;

            addon.getOpSuchtLabyServer().setConnected(false);
        });
    }
}
