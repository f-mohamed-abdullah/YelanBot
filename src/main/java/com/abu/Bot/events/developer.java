package com.abu.Bot.events;

import com.abu.Bot.Embeds.EmbeddedMessageBuilder;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class developer extends ListenerAdapter {
    public developer() {
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String messagedChanel = event.getMessage().getChannelId();

        if (event.getMessage().getContentRaw().equals("!dev")){
            EmbedBuilder devEmbed = new EmbeddedMessageBuilder().getEmbeds();

            devEmbed.setTitle("mdxabu","https://github.com/mdxabu");
            devEmbed.setThumbnail("https://c.tenor.com/nxccQmb_0ksAAAAd/tenor.gif");
            devEmbed.setColor(new Color(255, 0, 0));
            devEmbed.setDescription("I'm developing this bot for fun!");
            devEmbed.setImage("https://c.tenor.com/Q4fpWPR5xjwAAAAC/tenor.gif");
            event.getGuild().getTextChannelById(messagedChanel).sendMessage("").setEmbeds(devEmbed.build()).queue();
            event.getMessage().delete().queue();
        }
    }
}
