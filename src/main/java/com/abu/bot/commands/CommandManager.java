package com.abu.bot.commands;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.utils.FileUpload;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CommandManager extends ListenerAdapter {



    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        String command = event.getName();

        switch (command) {
            // This command show the information about discord bot
            case "info" -> {
                event.reply("- ***Yelan*** is an Multipurpose discord bot 🤖.\n" +
                        "- Inspired from genshin impact pc game 🎮 character.").queue();
            }
            // This command show all roles available in server
            case "showallroles" -> {
                event.deferReply().queue();
                StringBuilder response = new StringBuilder();
                for (Role role : event.getGuild().getRoles()) {
                    response.append(role.getAsMention()).append("\n");
                }
                event.getHook().sendMessage(response.toString()).queue();
            }
            case "ily" -> {
                ArrayList<String> cutePicsofYelan = new ArrayList<>();
                cutePicsofYelan.add("images/ily/cute1.jpg");
                cutePicsofYelan.add("images/ily/cute2.jpg");
                cutePicsofYelan.add("images/ily/cute3.jpg");
                cutePicsofYelan.add("images/ily/cute4.jpg");
                cutePicsofYelan.add("images/ily/cute5.jpg");
                cutePicsofYelan.add("images/ily/cute6.jpg");
                cutePicsofYelan.add("images/ily/cute7.jpg");

                String username = event.getUser().getAsMention();
                int index = new Random().nextInt(cutePicsofYelan.size());
                String path = cutePicsofYelan.get(index);
                File f = new File(path);

                event.replyFiles(FileUpload.fromData(f)).queue();
                event.getHook().sendMessage("I Love You too " + username + " </3 !!!").queue();
            }
            case "hiii_yelan" -> {
                String username = event.getUser().getAsMention();
                event.reply("Hello "+username+" ❤️❤️❤️").queue();
            }
            case "hug" -> {
                ArrayList<String> hugPicsofgenshin = new ArrayList<>();

                hugPicsofgenshin.add("images/hug/hug-1.gif");
                hugPicsofgenshin.add("images/hug/hug-2.jpeg");
                hugPicsofgenshin.add("images/hug/hug-3.jpeg");
                hugPicsofgenshin.add("images/hug/hug-4.jpeg");
                hugPicsofgenshin.add("images/hug/hug-5.jpeg");
                hugPicsofgenshin.add("images/hug/hug-6.jpg");
                hugPicsofgenshin.add("images/hug/hug-7.jpg");
                hugPicsofgenshin.add("images/hug/hug-8.gif");
                hugPicsofgenshin.add("images/hug/hug-9.gif");


                OptionMapping hugOption = event.getOption("user");

                String huggedBy = event.getUser().getAsMention();

                assert hugOption != null;
                String huggedUser = hugOption.getAsUser().getAsMention();


                int index = new Random().nextInt(hugPicsofgenshin.size());
                String path = hugPicsofgenshin.get(index);
                File f = new File(path);

                event.replyFiles(FileUpload.fromData(f)).queue();
                event.getHook().sendMessage(huggedUser + " was hugged by " + huggedBy + " 🫂❤️").queue();
            }
        }
    }



    @Override
    public void onGuildReady(GuildReadyEvent event) {
        List<CommandData> commandData = new ArrayList<>();

        commandData.add(Commands.slash("info","Information about yelan bot"));
        commandData.add(Commands.slash("ily","Say I Love You </3 to yelan"));
        commandData.add(Commands.slash("showallroles","See all roles on server"));
        commandData.add(Commands.slash("hiii_yelan","say hi to yelan"));

//        OptionData option1 = new OptionData(OptionType.USER,"username","hug the user you want",false);
        OptionData option2 = new OptionData(OptionType.MENTIONABLE,"user","hugging");

        commandData.add(Commands.slash("hug","hug the user you want !!!").addOptions(option2));
        event.getGuild().updateCommands().addCommands(commandData).queue();
    }


}
