package me.funchy.penguinbot.command.type.fun;

import me.funchy.penguinbot.command.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.io.IOException;
import java.util.Date;

public class WhoCommand implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws IOException {
        if(event.getJDA().getPing() > 180){
            event.getTextChannel().sendMessage("Eu to puto hoje ! :rage:, olha meu ping " + event.getJDA().getPing());
        }else {
            event.getTextChannel().sendMessage("Eu to dboas hoje ! :smiley:, olha meu ping " + event.getJDA().getPing());

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
