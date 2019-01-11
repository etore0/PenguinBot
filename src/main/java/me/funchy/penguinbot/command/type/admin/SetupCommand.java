package me.funchy.penguinbot.command.type.admin;

import me.funchy.penguinbot.command.Command;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.utils.PermissionUtil;

public class SetupCommand implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if(!PermissionUtil.checkPermission(event.getTextChannel(), event.getMember(), Permission.ADMINISTRATOR)){
            event.getTextChannel().sendMessage("Você não tem permissão para executar esse comando! " + event.getAuthor().getName());
        }else {
        }
        event.getTextChannel().getId();
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
