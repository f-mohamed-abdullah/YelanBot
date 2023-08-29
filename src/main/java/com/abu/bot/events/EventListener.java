package com.abu.bot.events;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class EventListener extends ListenerAdapter {

    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent event) {

        User username = event.getUser();

        String emoji = event.getReaction().getEmoji().getAsReactionCode();

        String channelMention = event.getChannel().getAsMention();

        String message = username.getAsMention()+" reacted with this "+emoji+" emoji in "+channelMention+" Channel";

        event.getGuild().getTextChannelById("1146097570112884838").sendMessage(message).queue();


    }
}
