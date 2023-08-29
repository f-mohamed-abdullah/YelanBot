package com.abu.bot.events;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class EventListener extends ListenerAdapter {

    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent event) {

    	// get the user who reacts to the messages
        User username = event.getUser();

        // get the reacted emoji
        String emoji = event.getReaction().getEmoji().getAsReactionCode();

        // get the channel the user reacted
        String channelMention = event.getChannel().getAsMention();

        // this message was displayed
        String message = username.getAsMention()+" reacted with this "+emoji+" emoji in "+channelMention+" Channel";

        
        event.getGuild().getTextChannelById("1146097570112884838").sendMessage(message).queue();


    }
}
