package com.rappytv.opsuchtaddon.listener.internal;

import com.rappytv.opsuchtaddon.settings.PlayerSettings;

public class FlyModeUpdateListener {
    public static void onFlyModeUpdate(boolean state) {
        PlayerSettings.setFlyMode(state);
    }
}