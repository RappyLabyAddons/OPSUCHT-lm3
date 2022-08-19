package com.rappytv.opsuchtaddon.listener.labymod;

import com.google.common.eventbus.Subscribe;
import com.rappytv.opsuchtaddon.OPSuchtAddon;
import lombok.AllArgsConstructor;
import net.labymod.api.events.MessageModifyChatEvent;
import net.labymod.api.events.MessageReceiveEvent;
import net.labymod.utils.ModColor;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentUtils;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.ClickEvent.Action;
import net.minecraft.util.text.event.HoverEvent;

import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@AllArgsConstructor
public class MessageModifyListener implements MessageModifyChatEvent {

    private final OPSuchtAddon addon;

    @Override
    public Object onModifyChatMessage(Object o) {
        if (o instanceof TextComponentString) {
            if (!this.addon.getAddonSettings().getClickableNicks() || !this.addon.getOpSuchtLabyServer().getConnected())
                return o;
            TextComponentString tc = (TextComponentString) o;
            String text = tc.getUnformattedText();
            if (!text.contains("|") || !text.contains("~")) return o;

            String nick = Arrays.stream(text.split(" ")).filter(s -> s.startsWith("~")).findFirst().orElse(null);
            if (!nick.equalsIgnoreCase(text.split(" ")[2])) return o;

            return applyStyle(tc, nick);
        }
        return o;
    }

    private TextComponentString applyStyle(TextComponentString tc, String nick) {
        String[] words = tc.getFormattedText().split(" ");
        TextComponentString msg = new TextComponentString("");
        for (int i = 0; i < 3; i++) {
            TextComponentString word = new TextComponentString(words[i] + " ");

            if (i == 2) {
                Style style = tc.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TextComponentString(ModColor.GREEN + "Klicke, um den richtigen Namen anzusehen!"))).setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/realname " + nick.substring(1)));
                word.setStyle(style);
            }
            msg.appendSibling(word);
        }
        StringBuilder message = new StringBuilder();
        for (int i = 3; i < words.length; i++) {
            message.append(words[i]).append(" ");
        }
        msg.appendSibling(new TextComponentString(message.toString()));
        return msg;
    }
}