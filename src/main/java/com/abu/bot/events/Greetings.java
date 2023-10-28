package com.abu.bot.events;

import net.dv8tion.jda.api.events.message.GenericMessageEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Greetings extends ListenerAdapter {

    @Override
    public void onReady(ReadyEvent event) {

        ArrayList<String> MorningMessageList = new ArrayList<>();
        MorningMessageList.add("Good morning 🌞 ! May your day be as wonderful as the first sip of coffee. @everyone");
        MorningMessageList.add("It's a new day to make new memories. Good morning 🌞! @everyone");
        MorningMessageList.add("A beautiful morning to a beautiful soul. Good morning 🌞! @everyone");
        MorningMessageList.add("Each morning brings a new opportunity. Seize it with both hands. Good morning 🌞! @everyone");
        MorningMessageList.add("A cup of kindness and a dash of positivity – that's the recipe for a great morning. Good morning 🌞! @everyone");
        MorningMessageList.add("The early bird catches the worm, but the second mouse gets the cheese. Good morning 🌞! @everyone");


        ArrayList<String> NightMessageList = new ArrayList<>();
        NightMessageList.add("Wishing you a restful night's sleep and beautiful dreams. Good night 🌛! @everyone");
        NightMessageList.add("The day may be over, but our connection remains. Good night 🌛, my dear friend. @everyone");
        NightMessageList.add("Dream big and dream sweet. Good night 🌛 and sleep well 🛌💤! @everyone");
        NightMessageList.add("Sending you a gentle night breeze filled with love and peace. Good night 🌛! @everyone");
        NightMessageList.add("May your dreams be as peaceful as a silent night. Good night 🌛! @everyone");
        NightMessageList.add("Sleep is the best meditation. Good night 🌛 and find your inner peace ✌️. @everyone");



        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                LocalTime now = LocalTime.now();
                LocalTime MorningTimeAfter = LocalTime.of(6,1);
                LocalTime MorningTimeBefore = LocalTime.of(6,2);

                LocalTime NightTimeAfter = LocalTime.of(21, 25);
                LocalTime NightTimeBefore = LocalTime.of(21, 26);
                if (now.isAfter(MorningTimeAfter) && now.isBefore(MorningTimeBefore)){
                    int index = new Random().nextInt(MorningMessageList.size());
                    event.getJDA().getTextChannelById("1150429037370556494").sendMessage(MorningMessageList.get(index)).queue();
                }
                else if(now.isAfter(NightTimeAfter) && now.isBefore(NightTimeBefore)){
                    //event.getJDA().getTextChannelById("").sendFiles().queue();
                    int index = new Random().nextInt(NightMessageList.size());
                    event.getJDA().getTextChannelById("1150429037370556494").sendMessage(NightMessageList.get(index)).queue();
                }
            }


        },0,60000);



    }
}
