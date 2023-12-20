package com.abu.Bot.events;

import com.abu.Bot.Embeds.EmbeddedMessageBuilder;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Information extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        EmbedBuilder embed = EmbeddedMessageBuilder.getEmbeddedMessageBuilder();


//        if(event.getMessage().getContentRaw().equals("!info"))
//        {
//
////           embed.
//
//            event.getGuild().getTextChannelById(messageRecievedChannel).sendMessage("").setEmbeds(embed.build()).queue();
//        }
        if (event.getMessage().getContentRaw().substring(0,7).equals("-avatar:")){

        }

    }
}
