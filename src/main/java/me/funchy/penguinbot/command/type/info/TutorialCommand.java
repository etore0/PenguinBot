package me.funchy.penguinbot.command.type.info;

import me.funchy.penguinbot.command.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.io.IOException;

public class TutorialCommand implements Command {


    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws IOException {
        if(args.length == 0)  {
         event.getTextChannel().sendMessage("Tutoriais disponiveis: ").queue();
         event.getTextChannel().sendMessage("SteamID: Como pegar seu SteamID").queue();
         event.getTextChannel().sendMessage("digite !tutorial <tuturial> para ver o tutorial").queue();
         event.getTextChannel().sendMessage("ex: !tutorial steamid").queue();
        }
        if (args[1].equalsIgnoreCase("steamid")) {
            event.getTextChannel().sendMessage("Para pegar seu SteamID basta ir ao site: ").queue();
            event.getTextChannel().sendMessage("https://vacbanned.com e coloque o link da ").queue();
            event.getTextChannel().sendMessage("sua steam e copie o seu hex").queue();
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
