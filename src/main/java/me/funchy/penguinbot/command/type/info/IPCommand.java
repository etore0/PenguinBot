package me.funchy.penguinbot.command.type.info;

import me.funchy.penguinbot.command.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.io.IOException;

public class IPCommand implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws IOException {
        if(event.getGuild().getId().equals("518102753034108950")){
            event.getTextChannel().sendMessage("O ip do servidor é : 35.247.221.82:30120").queue();
        }else {
            event.getTextChannel().sendMessage("Essa guild ainda não possui nenhum IP").queue();
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
