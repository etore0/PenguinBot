package me.funchy.penguinbot.command.type.admin;

import me.funchy.penguinbot.command.Command;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.utils.PermissionUtil;

import java.io.IOException;

public class SayCommand implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws IOException {
        if(PermissionUtil.checkPermission(event.getTextChannel(), event.getMember(), Permission.ADMINISTRATOR)){
            String text = new String();
            for(String arg : args) {
                if(arg.equals("@everyone")) continue; //cause people don't like to be ping'd at all it seems
                text += arg + " ";
            }
            event.getMessage().delete().queue();
            event.getTextChannel().sendMessage(text).queue();
        }else {
            event.getTextChannel().sendMessage("Você não tem permissão para executar esse comando").queue();
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
