package com.abu.Bot.events;

import net.dv8tion.jda.api.events.channel.ChannelCreateEvent;
import net.dv8tion.jda.api.events.channel.ChannelDeleteEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ChannelCreateandDelete extends ListenerAdapter {




    @Override
    public void onChannelCreate(ChannelCreateEvent event) {
        String newChannel = event.getChannel().getAsMention();

        String message = newChannel+" channel was created in the "+event.getGuild().getName();

       event.getGuild().getSystemChannel().sendMessage(message).queue();


    }

    @Override
    public void onChannelDelete(ChannelDeleteEvent event) {
        String delchannel = event.getChannel().getName();


        String message = "'"+delchannel+"' Channel was deleted from '"+event.getGuild().getName()+"'";

        event.getGuild().getSystemChannel().sendMessage(message).queue();
    }




}
