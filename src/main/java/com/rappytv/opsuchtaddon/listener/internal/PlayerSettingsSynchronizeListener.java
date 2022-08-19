package com.rappytv.opsuchtaddon.listener.internal;

import com.google.gson.JsonObject;
import com.rappytv.opsuchtaddon.settings.PlayerSettings;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PlayerSettingsSynchronizeListener {

    public static void onPlayerSettingsSynchronize(JsonObject playerSettings) {
        PlayerSettings.setPlayerSettings(playerSettings);
    }
}