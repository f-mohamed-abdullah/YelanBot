package com.abu.Bot.events;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Information extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String messageRecievedChannel = event.getMessage().getChannelId();
        if(event.getMessage().getContentRaw().equals("!info")){
            event.getGuild().getTextChannelById(messageRecievedChannel).sendMessage("- ***Yelan*** is an Multipurpose discord bot 🤖.\n" +
                    "- Inspired from genshin impact pc game 🎮 character.").queue();
        }
    }
}
