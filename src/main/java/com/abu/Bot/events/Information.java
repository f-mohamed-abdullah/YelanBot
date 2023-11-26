package com.abu.Bot.events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class Information extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String messageRecievedChannel = event.getMessage().getChannelId();

        if(event.getMessage().getContentRaw().equals("!info"))
        {
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle("Yelan");
            embed.setColor(new Color(76, 0, 130));
            embed.setDescription("- ***Yelan*** is an Multipurpose discord bot 🤖\n"+
                    "- Inspired from genshin impact pc game 🎮 character.");

            embed.setFooter("See you again...");

            event.getGuild().getTextChannelById(messageRecievedChannel).sendMessage("").setEmbeds(embed.build()).queue();
        }

    }
}
