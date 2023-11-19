package com.abu.Bot;

import com.abu.Bot.commands.CommandManager;
import com.abu.Bot.events.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;



public class yelanBot {


    JDA botManager ;
    public yelanBot() {
        String token = getEnvToken();
        JDABuilder builder = JDABuilder.createDefault(token);

        builder.enableIntents(GatewayIntent.GUILD_MEMBERS,GatewayIntent.GUILD_MESSAGES,GatewayIntent.MESSAGE_CONTENT,GatewayIntent.GUILD_PRESENCES);
        builder.addEventListeners(new ChannelCreateandDelete());
        builder.addEventListeners(new EmojiEvents());
        builder.addEventListeners(new RoleCreateandDelete());
        builder.addEventListeners(new ViolentWords());
        builder.addEventListeners(new Greetings());
        builder.addEventListeners(new CommandManager());
        builder.addEventListeners(new GuildJoinandLeave());

//        builder.setActivity(Activity.listening("Shadow in the Rain"));
        builder.setActivity(Activity.playing("Genshin Impact"));
        botManager = builder.build();


    }

    private static String getEnvToken() {

        // getting environmental variables
        return System.getenv("TOKEN");
    }

}
