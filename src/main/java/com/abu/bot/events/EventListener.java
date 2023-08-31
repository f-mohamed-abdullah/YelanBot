package com.abu.bot.events;

import java.nio.channels.Channel;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.user.update.UserUpdateOnlineStatusEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.w3c.dom.Text;

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
        String message = null;
        if (username != null) {
            message = username.getAsMention()+" reacted with this "+emoji+" emoji in "+channelMention+" Channel";
        }


        event.getGuild().getTextChannelById("1146752522975981719").sendMessage(message).queue();


    }


    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()){
            return;
        }

        User username = event.getAuthor();


        String channel = event.getChannel().getAsMention();

        String message = username.getAsMention()+" messaged in "+channel+" Channel";

        event.getGuild().getTextChannelById("1146753250893254727").sendMessage(message).queue();
    }

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
    	

    	
        User username = event.getUser();
    	
    	String message ="Welcome to the server Mr/Ms."+username.getAsMention()+" </3";
    	
    	event.getGuild().getTextChannelById("1146096682996596837").sendMessage(message).queue();
    }


}
