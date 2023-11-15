package com.abu.bot.events;

import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.role.RoleCreateEvent;
import net.dv8tion.jda.api.events.role.RoleDeleteEvent;
import net.dv8tion.jda.api.events.role.update.RoleUpdateColorEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.List;

public class RoleCreateandDelete extends ListenerAdapter {




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


    @Override
    public void onRoleUpdateColor(RoleUpdateColorEvent event) {
        List<TextChannel> channelList = event.getGuild().getTextChannelsByName("general",true);

        String old_color = String.valueOf(event.getOldColor());
        String new_color = String.valueOf(event.getNewColor());
        String role = event.getRole().getAsMention();
        String message = role+" Color was changed from "+old_color+" to "+new_color;
        sendMessage(channelList,message);

    }

    private void sendMessage(List<TextChannel> channelList, String message) {
        channelList.get(0).sendMessage(message).queue();

    }

}
