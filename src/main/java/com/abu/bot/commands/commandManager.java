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

public class commandManager extends ListenerAdapter {


    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        String command = event.getName();
        if (command.equals("welcome")){
            String username = event.getUser().getAsMention();
            event.reply("Welcome to the server "+username+" 💖!!!").queue();
        }
        else if (command.equals("seeroles")) {
            event.deferReply().queue();
            String response = "";
            for (Role role : event.getGuild().getRoles()){
                response += role.getAsMention() +"\n";
            }
            event.getHook().sendMessage(response).queue();
        }
        else if (command.equals("ily")) {
            String username = event.getUser().getAsMention();
            File f = new File("images/cute2.jpg");

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
        commandData.add(Commands.slash("seeroles","See all roles on server"));
        event.getGuild().updateCommands().addCommands(commandData).queue();
    }
}
