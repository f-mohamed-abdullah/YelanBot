package com.abu.Bot.events;


import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.utils.FileUpload;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class ViolentWords extends ListenerAdapter {


    // This method is used for give warning to server members for using badwords on the chat
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {



        String[] dontusethesewords = {"fuck","bitch","bastard","dick","pussy","boobs","boob","motherfucker","asshole","nigga",
                                        "cum","slut","whore","cunt"," ass"};

        ArrayList<String> angrypicspath = new ArrayList<>();
        angrypicspath.add("images/angry/angry-1.jpeg");
        angrypicspath.add("images/angry/angry-2.jpeg");
        angrypicspath.add("images/angry/angry-3.jpg");
        angrypicspath.add("images/angry/angry-4.jpg");
        angrypicspath.add("images/angry/angry-5.jpg");

        String message = event.getMessage().getContentRaw().toLowerCase();

        for (String i:dontusethesewords){
            if (message.contains(i)){
                int index = new Random().nextInt(angrypicspath.size());
                String path = angrypicspath.get(index);
                File f = new File(path);
                User user = event.getAuthor();
                user.openPrivateChannel().flatMap(channel -> channel.sendFiles(FileUpload.fromData(f))).queue();
                user.openPrivateChannel().flatMap(channel -> channel.sendMessage("Hey,Don't use badwords on "+event.getGuild().getName()+" Server !!!")).queue();

            }
        }
    }
}
