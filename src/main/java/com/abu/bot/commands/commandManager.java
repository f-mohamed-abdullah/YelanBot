package com.abu.bot.commands;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.utils.FileUpload;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class commandManager extends ListenerAdapter {


    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        String command = event.getName();
        if (command.equals("welcome")){
            String username = event.getUser().getAsMention();
            event.reply("Welcome to the server "+username+" 💖!!!").queue();
        }
        else if (command.equals("showallroles")) {
            event.deferReply().queue();
            String response = "";
            for (Role role : event.getGuild().getRoles()){
                response += role.getAsMention() +"\n";
            }
            event.getHook().sendMessage(response).queue();
        }
        else if (command.equals("ily")) {
            ArrayList<String> cutePicsofYelan = new ArrayList<>();
            cutePicsofYelan.add("images/ily/cute.jpg");
            cutePicsofYelan.add("images/ily/cute2.jpg");
            String username = event.getUser().getAsMention();
            String path = cutePicsofYelan.get(getRandomNumberUsingNextInt(1,cutePicsofYelan.size()-1));
            File f = new File(path);

            event.replyFiles(FileUpload.fromData(f)).queue();
            event.getHook().sendMessage("I Love You too "+username+" </3 !!!").queue();
//            event.reply("I Love You too "+username+" </3 !!!").queue();
        }
    }


    @Override
    public void onGuildReady(GuildReadyEvent event) {
        List<CommandData> commandData = new ArrayList<>();

        commandData.add(Commands.slash("welcome","Get Welcomed by yelan"));
        commandData.add(Commands.slash("ily","Say I Love You </3 to yelan"));
        commandData.add(Commands.slash("showallroles","See all roles on server"));
        event.getGuild().updateCommands().addCommands(commandData).queue();
    }

    public int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
