package com.abu.bot.events;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.utils.FileUpload;

import java.io.File;
import java.util.ArrayList;

public class ViolentWords extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        String[] dontusethesewords = {"fuck","bitch","bastard","dick","pussy","boobs","motherfucker","asshole"};

        ArrayList<String> angrypicspath = new ArrayList<>();
        angrypicspath.add("images/angry/angry-1.jpeg");
        angrypicspath.add("images/angry/angry-2.jpeg");
        angrypicspath.add("images/angry/angry-3.jpeg");
        angrypicspath.add("images/angry/angry-4.jpeg");
        angrypicspath.add("images/angry/angry-5.jpeg");

        String message = event.getMessage().getContentRaw().toLowerCase();

        for (String i:dontusethesewords){
            if (message.contains(i)){
                File f = new File("images/angry/angry-2.jpeg");
                event.getGuild().getSystemChannel().sendFiles(FileUpload.fromData(f)).queue();
                event.getGuild().getSystemChannel().sendMessage(event.getMember().getAsMention()+" Don't use violent words in server!!!").queue();
            }
        }
    }
}
