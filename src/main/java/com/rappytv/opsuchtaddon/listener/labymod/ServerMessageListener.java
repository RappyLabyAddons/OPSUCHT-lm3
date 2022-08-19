package com.rappytv.opsuchtaddon.listener.labymod;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.rappytv.opsuchtaddon.listener.internal.FlyModeUpdateListener;
import com.rappytv.opsuchtaddon.listener.internal.GodModeUpdateListener;
import com.rappytv.opsuchtaddon.listener.internal.PlayerSettingsSynchronizeListener;
import com.rappytv.opsuchtaddon.listener.internal.VanishModeUpdateListener;
import net.labymod.api.events.ServerMessageEvent;
import net.labymod.main.LabyMod;

public class ServerMessageListener implements ServerMessageEvent {

    @Override
    public void onServerMessage(String s, JsonElement jsonElement) {
        LabyMod.getInstance().displayMessageInChat(s);
        LabyMod.getInstance().displayMessageInChat(jsonElement.toString());
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        switch (s) {
            case "opsucht_settings": {
                PlayerSettingsSynchronizeListener.onPlayerSettingsSynchronize(jsonObject);
                break;
            }

            case "opsucht_fly_mode": {
                FlyModeUpdateListener.onFlyModeUpdate(jsonObject.get("value").getAsBoolean());
                break;
            }

            case "opsucht_vanish_mode": {
                VanishModeUpdateListener.onVanishModeUpdate(jsonObject.get("value").getAsBoolean());
                break;
            }

            case "opsucht_god_mode": {
                GodModeUpdateListener.onGodModeUpdate(jsonObject.get("value").getAsBoolean());
                break;
            }

            default:
                break;

        }
    }
}