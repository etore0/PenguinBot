package me.funchy.penguinbot.command.type.admin;

import me.funchy.penguinbot.command.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.io.IOException;

public class CreatorCommand implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws IOException {
         if(event.getAuthor().getId().equals("524928786073124864")){
             event.getTextChannel().sendMessage("ID do servidor: " + event.getGuild().getId()).queue();

         }
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
