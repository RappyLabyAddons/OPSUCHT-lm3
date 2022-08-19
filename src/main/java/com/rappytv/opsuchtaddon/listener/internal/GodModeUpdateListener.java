package com.rappytv.opsuchtaddon.listener.internal;

import com.rappytv.opsuchtaddon.settings.PlayerSettings;

public class GodModeUpdateListener {
    public static void onGodModeUpdate(boolean state) {
        PlayerSettings.setGodMode(state);
    }
}