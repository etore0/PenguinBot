package me.funchy.penguinbot.command.type.info;

import me.funchy.penguinbot.command.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class PingCommand implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
         event.getTextChannel().sendMessage(":ping_pong: O Meu ping atual é " + event.getJDA().getPing()).queue();
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

   @Override
    public String help() {
        return null;
    }
}
