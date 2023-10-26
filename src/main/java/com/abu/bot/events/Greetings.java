package com.abu.bot.events;

import net.dv8tion.jda.api.events.message.GenericMessageEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

public class Greetings extends ListenerAdapter {

    @Override
    public void onReady(ReadyEvent event) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                LocalTime now = LocalTime.now();
                LocalTime MorningTime = LocalTime.of(6,1);
                LocalTime NightTime = LocalTime.of(21, 1);
                if(now.isAfter(NightTime)){
                    event.getJDA().getTextChannelById("1150429037370556494").sendMessage("Good Night 💤").queue();
                }
            }


        },0,60000);



    }
}
