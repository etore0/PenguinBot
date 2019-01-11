package me.funchy.penguinbot.command.type.music;

import me.funchy.penguinbot.command.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.io.IOException;

public class MusicCommand implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws IOException {

    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
