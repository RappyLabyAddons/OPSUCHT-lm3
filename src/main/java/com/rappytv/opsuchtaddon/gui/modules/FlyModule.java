package com.rappytv.opsuchtaddon.gui.modules;

import com.rappytv.opsuchtaddon.listener.internal.FlyModeUpdateListener;
import com.rappytv.opsuchtaddon.settings.PlayerSettings;
import net.labymod.core.LabyModCore;
import net.labymod.settings.elements.ControlElement;
import net.labymod.settings.elements.ControlElement.IconData;
import net.labymod.utils.ModColor;
import net.minecraft.util.ResourceLocation;

public class FlyModule extends LabyModule {

    @Override
    public String getDisplayName() {
        return "Fly";
    }

    @Override
    public boolean isShown() {
        return super.isShown() && !LabyModCore.getMinecraft().getPlayer().isCreative() && !LabyModCore.getMinecraft().getPlayer().isSpectator();
    }

    @Override
    public String getDisplayValue() {
        return PlayerSettings.getFlyMode() ? ModColor.GREEN + "An" : ModColor.RED + "Aus";
    }

    @Override
    public IconData getIconData() {
        return new ControlElement.IconData(new ResourceLocation("opsuchtaddon/textures/elytra.png"));
    }

    @Override
    public String getControlName() {
        return "Fly";
    }

    @Override
    public String getSettingName() {
        return "fly_state";
    }

    @Override
    public int getSortingId() {
        return 0;
    }

}