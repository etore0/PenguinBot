package me.funchy.penguinbot.command.type.info;

import me.funchy.penguinbot.command.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.io.IOException;

public class OwnerCommand implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws IOException {
        event.getTextChannel().sendMessage("-------------------------------------").queue();
        event.getTextChannel().sendMessage("Fui criado pelo @Funchy").queue();
        event.getTextChannel().sendMessage("Redes sociais dele:").queue();
        event.getTextChannel().sendMessage("Discord: Funchy#2381").queue();
        event.getTextChannel().sendMessage("Twitter: twitter.com/drfunchy").queue();
        event.getTextChannel().sendMessage("Github: github.com/Funchyy").queue();
        event.getTextChannel().sendMessage("Bitbucket: bitbucket.org/Funchyy/").queue();
        event.getTextChannel().sendMessage("Site: funchyy.github.io").queue();
        event.getTextChannel().sendMessage("-------------------------------------").queue();

    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
