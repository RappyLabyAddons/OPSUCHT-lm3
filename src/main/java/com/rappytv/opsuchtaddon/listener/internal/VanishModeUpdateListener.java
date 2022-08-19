package com.rappytv.opsuchtaddon.listener.internal;

import com.rappytv.opsuchtaddon.settings.PlayerSettings;

public class VanishModeUpdateListener {
    public static void onVanishModeUpdate(boolean state) {
        PlayerSettings.setVanishMode(state);
    }
}