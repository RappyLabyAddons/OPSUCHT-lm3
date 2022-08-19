package com.rappytv.opsuchtaddon.server;

import com.rappytv.opsuchtaddon.OPSuchtAddon;
import lombok.Getter;
import lombok.Setter;
import net.labymod.api.events.TabListEvent;
import net.labymod.servermanager.ChatDisplayAction;
import net.labymod.servermanager.Server;
import net.labymod.settings.elements.SettingsElement;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.network.PacketBuffer;

import java.util.List;

public class OPSuchtLabyServer extends Server {
    @Getter
    @Setter
    private Boolean connected = true;

    public OPSuchtLabyServer(String name, String... addressNames) {
        super(name, addressNames);
    }

    @Override
    public void onJoin(ServerData serverData) {
        this.setConnected(true);
    }

    @Override
    public ChatDisplayAction handleChatMessage(String rawMessage, String formattedMessage) {
        return ChatDisplayAction.NORMAL;
    }

    @Override
    public void handlePluginMessage(String s, PacketBuffer packetBuffer) throws Exception {

    }

    @Override
    public void handleTabInfoMessage(TabListEvent.Type type, String formattedMessage, String rawMessage) {

    }

    @Override
    public void fillSubSettings(List<SettingsElement> list) {

    }
}