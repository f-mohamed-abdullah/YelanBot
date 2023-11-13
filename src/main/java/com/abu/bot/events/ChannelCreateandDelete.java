package com.abu.bot.events;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.channel.ChannelCreateEvent;
import net.dv8tion.jda.api.events.channel.ChannelDeleteEvent;
import net.dv8tion.jda.api.events.role.RoleCreateEvent;
import net.dv8tion.jda.api.events.role.RoleDeleteEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public void onRoleCreate(RoleCreateEvent event) {

        List<TextChannel> channelList = event.getGuild().getTextChannelsByName("general",true);
        String role = event.getRole().getAsMention();
        String message = role + " New role was added to the server.";

//        event.getGuild().getTextChannelsByName(channelList).get(0).sendMessage(message).queue();
        sendMessage(channelList,message);
    }



    @Override
    public void onRoleDelete(RoleDeleteEvent event) {

        List<TextChannel> channelList = event.getGuild().getTextChannelsByName("general",true);
        String role = event.getRole().getName();
        String message = "This ***"+role+"*** role was deleted from the server.";
        sendMessage(channelList,message);
    }
    private void sendMessage(List<TextChannel> channelList, String message) {
        channelList.get(0).sendMessage(message).queue();

    }

}
