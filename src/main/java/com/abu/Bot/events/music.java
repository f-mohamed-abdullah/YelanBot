package com.abu.Bot.events;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class music extends ListenerAdapter {



    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if(event.getAuthor().isBot()){
            return;
        }

        Message message = event.getMessage();
        String command = message.getContentRaw();

        if(command.startsWith("!play")){
            String songName = command.substring(6);

            event.getChannel().sendMessage("Playing "+songName).queue();

        }
    }




}
