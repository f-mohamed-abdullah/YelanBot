package com.abu.Bot;


import com.abu.Bot.Embeds.EmbeddedMessageBuilder;
import com.abu.Bot.Lavaplayer.AudioForwarder;
import com.abu.Bot.commands.*;
import com.abu.Bot.events.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.io.IOException;


public class yelanBot {


    JDA botManager ;
    public yelanBot() throws IOException {
        String token = getEnvToken();
        JDABuilder builder = JDABuilder.createDefault(token);

        builder.enableIntents(GatewayIntent.GUILD_MEMBERS,GatewayIntent.GUILD_MESSAGES,GatewayIntent.MESSAGE_CONTENT,GatewayIntent.GUILD_PRESENCES);
        builder.addEventListeners(new ChannelCreateandDelete());
        builder.addEventListeners(new EmojiEvents());
//        builder.addEventListeners(new Play());
//        builder.addEventListeners(new RoleCreateandDelete());
        builder.addEventListeners(new ViolentWords());
        builder.addEventListeners(new Greetings());
//        builder.addEventListeners(new CommandManager());
        builder.addEventListeners(new GuildJoinandLeave());
        builder.addEventListeners(new Information());

//        builder.addEventListeners(new music());
        builder.addEventListeners(new developer());
        builder.addEventListeners(new EmbeddedMessageBuilder());
        builder.addEventListeners(new AnonymousMessageSender());

        builder.addEventListeners(new EmbeddedMessageBuilder());


        CommandManager manager = new CommandManager();
        
        manager.add(new Play());
        manager.add(new Skip());
        manager.add(new Stop());
        manager.add(new NowPlaying());
        manager.add(new Queue());
        manager.add(new Repeat());
        builder.addEventListeners(manager);

//        builder.setActivity(Activity.listening("Shadow in the Rain"));
        builder.setActivity(Activity.playing("Genshin Impact"));

        botManager = builder.build();




    }

    private static String getEnvToken() {

        // getting environmental variables
        return System.getenv("TOKEN");
    }

}
