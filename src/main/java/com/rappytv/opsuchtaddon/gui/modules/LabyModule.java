package com.rappytv.opsuchtaddon.gui.modules;

import com.rappytv.opsuchtaddon.OPSuchtAddon;
import com.rappytv.opsuchtaddon.settings.PlayerSettings;
import net.labymod.ingamegui.ModuleCategory;
import net.labymod.ingamegui.moduletypes.SimpleModule;
import net.minecraft.client.Minecraft;

public abstract class LabyModule extends SimpleModule {

    @Override
    public ModuleCategory getCategory() {
        return OPSuchtAddon.getInstance().getOpSuchtModuleCategory();
    }

    @Override
    public boolean isShown() {
        return PlayerSettings.getBooleanValue(this.getSettingName()) && OPSuchtAddon.getInstance().getOpSuchtLabyServer().getConnected();
    }

    @Override
    public String getDefaultValue() {
        return "?";
    }

    @Override
    public void loadSettings() {

    }

    @Override
    public String getDescription() {
        return "";
    }
}