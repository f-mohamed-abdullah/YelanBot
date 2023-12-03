package com.abu.Bot.events;

import com.abu.Bot.Embeds.EmbeddedMessageBuilder;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Information extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
//        EmbeddedMessageBuilder embed = new EmbeddedMessageBuilder();
        String messageRecievedChannel = event.getMessage().getChannelId();

        if(event.getMessage().getContentRaw().equals("!info"))
        {
            EmbedBuilder embeds = new EmbeddedMessageBuilder().getEmbeds();
            embeds.setTitle("\uD835\uDD84\uD835\uDD8A\uD835\uDD91\uD835\uDD86\uD835\uDD93");
            embeds.setUrl("https://github.com/mdxabu/YelanBot");
            embeds.setDescription("It is an multi-purpose discord bot");

            event.getGuild().getTextChannelById(messageRecievedChannel).sendMessage("").setEmbeds(embeds.build()).queue();
        }

    }
}
