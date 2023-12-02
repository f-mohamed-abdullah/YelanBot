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
            embeds.setTitle("Yelan Discord Bot");
            embeds.setUrl("https://github.com/mdxabu/YelanBot");
            embeds.setDescription("It is an multi-purpose discord bot");

            event.getGuild().getTextChannelById(messageRecievedChannel).sendMessage("").setEmbeds(embeds.build()).queue();
        }

    }
}
