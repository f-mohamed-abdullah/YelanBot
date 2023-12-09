package com.abu.Bot.events;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class AnonymousMessageSender extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String channelId = event.getMessage().getChannelId();

        if (event.getMessage().getContentRaw().startsWith("!anonymous-")){
            String message = event.getMessage().getContentRaw().substring(11);

            event.getMessage().delete().queue();
            event.getGuild().getTextChannelById(channelId).sendMessage(message).queue();
        }


    }
}
