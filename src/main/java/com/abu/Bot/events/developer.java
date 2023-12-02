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
            devEmbed.setThumbnail("https://media.tenor.com/cKkNLp8vVBEAAAAC/patrick-bateman-american-psycho.gif");
            devEmbed.setColor(new Color(255, 0, 0));
            devEmbed.setDescription("I'm developing this bot for fun!");
            event.getGuild().getTextChannelById(messagedChanel).sendMessage("").setEmbeds(devEmbed.build()).queue();
        }
    }
}
