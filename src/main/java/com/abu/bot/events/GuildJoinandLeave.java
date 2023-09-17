/*
* This class for greetings for member join and leave in the discord server
* It send greeting with pictures
*/



package com.abu.bot.events;

import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildJoinandLeave extends ListenerAdapter {

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        // Get the joined member name from discord server
        String member = event.getMember().getAsMention();

        // It is the greeting message for member who join in the discord server
        String message = "Welcome to the Server </3 "+ member+" ❤️";

        // but it only send in the server's system channel
        event.getGuild().getSystemChannel().sendMessage(message).queue();

    }

    @Override
    public void onGuildMemberRemove(GuildMemberRemoveEvent event) {
        String member = event.getMember().getAsMention();

        String message = "We'll miss you "+ member + " 🥹💔";

        event.getGuild().getSystemChannel().sendMessage(message).queue();
    }
}
