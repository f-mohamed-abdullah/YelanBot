package com.abu.Bot.events;

import net.dv8tion.jda.api.events.emoji.EmojiAddedEvent;
import net.dv8tion.jda.api.events.emoji.EmojiRemovedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class EmojiEvents extends ListenerAdapter {

    @Override
    public void onEmojiAdded(EmojiAddedEvent event) {
        String message = "*** New Emoji is added!!! ***";

    }

    @Override
    public void onEmojiRemoved(EmojiRemovedEvent event) {

    }
}
