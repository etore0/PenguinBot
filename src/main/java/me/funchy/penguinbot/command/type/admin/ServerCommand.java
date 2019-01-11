package me.funchy.penguinbot.command.type.admin;

import me.funchy.penguinbot.command.Command;
import me.funchy.penguinbot.manager.ManagerHandler;
import me.funchy.penguinbot.server.GuildType;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.io.IOException;

public class ServerCommand implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws IOException {
        if(event.getGuild().getId().equals("518102753034108950")){

        }
       event.getTextChannel().sendMessage("");
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
