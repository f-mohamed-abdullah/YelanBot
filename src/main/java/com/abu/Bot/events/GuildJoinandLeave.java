/*
* This class for greetings for member join and leave in the discord server
* It sends greeting with pictures
*/



package com.abu.Bot.events;

import net.dv8tion.jda.api.events.emoji.EmojiAddedEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.Random;

public class GuildJoinandLeave extends ListenerAdapter {



    // This method is for greeting the joining members in server
    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        // Get the joined member name from discord server
        String member = event.getMember().getAsMention();

        ArrayList<StringBuilder> message = new ArrayList<>();
        message.add(new StringBuilder("\uD83D\uDC4B Welcome to "+event.getGuild().getName()+"!\n" +
                "\n" +
                "We're thrilled to have you here. Please take a moment to read the rules in the #rules channel and introduce yourself in #introductions.\n" +
                "\n" +
                "If you have any questions or need assistance, feel free to reach out to our friendly staff members. Enjoy your time here!\n"));

        message.add(new StringBuilder("\uD83D\uDC4B Welcome to "+event.getGuild().getName()+"!\n" +
                "\n" +
                "We're glad you're here! Please read the rules in #rules and introduce yourself in #introductions. If you have any questions or need assistance, our friendly staff is here to help.\n" +
                "\n" +
                "Enjoy your stay and have fun chatting with the community!\n"));

        message.add(new StringBuilder("\uD83D\uDC4B Welcome to "+event.getGuild().getName()+"! Read #rules and say hi in #introductions. Enjoy your time here!\n"));

        int index = new Random().nextInt(message.size());


        event.getGuild().getSystemChannel().sendMessage(message.get(index)).queue();

    }

    // This method for leaved member fom server
    @Override
    public void onGuildMemberRemove(GuildMemberRemoveEvent event) {
        String member = event.getMember().getAsMention();

        String message = "We'll miss you "+ member + " 🥹💔";

        event.getGuild().getSystemChannel().sendMessage(message).queue();
    }


}
