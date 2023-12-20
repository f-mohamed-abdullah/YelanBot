package com.abu.Bot.Embeds;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class EmbeddedMessageBuilder extends ListenerAdapter {

    static EmbedBuilder embed;

    public static EmbedBuilder getEmbeddedMessageBuilder() {
        embed = new EmbedBuilder();
        embed.setColor(new Color(76, 0, 130));
//        embed.setThumbnail("https://media.tenor.com/SPkSdlAdNaUAAAAd/yelan-genshin-yelan.gif");
//        embed.setFooter("See you again...");
        return embed;
    }
}
