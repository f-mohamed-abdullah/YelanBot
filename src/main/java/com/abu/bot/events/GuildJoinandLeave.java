package com.abu.bot.events;

import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildJoinandLeave extends ListenerAdapter {

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        String member = event.getMember().getAsMention();

        String message = "Welcome to the Server </3 "+ member+" ❤️";

        event.getGuild().getSystemChannel().sendMessage(message).queue();

    }

    @Override
    public void onGuildMemberRemove(GuildMemberRemoveEvent event) {
        String member = event.getMember().getAsMention();

        String message = "We'll miss you "+ member + " 🥹💔";

        event.getGuild().getSystemChannel().sendMessage(message).queue();
    }
}
