package me.funchy.penguinbot.command.type.admin;

import me.funchy.penguinbot.command.Command;
import net.dv8tion.jda.core.entities.PrivateChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.List;

public class SpamCommand implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if(event.getAuthor().getId().equals("524928786073124864") && !event.getMessage().getMentionedMembers().isEmpty()){
            List<User> mentionedUsers = event.getMessage().getMentionedUsers();
            for(User u : mentionedUsers) {
                event.getMessage().getTextChannel().sendMessage("Vo mete a porrada no "  + u.getAsMention() + " ! :angry:").queue();
                PrivateChannel pc = u.openPrivateChannel().complete();
                pc.sendMessage("Vo te mete a porrada :angry: !").queue();
                pc.sendMessage("Vo te mete a porrada :angry: !").queue();
                pc.sendMessage("Vo te mete a porrada :angry: !").queue();
                pc.sendMessage("Vo te mete a porrada :angry: !").queue();
                pc.sendMessage("Vo te mete a porrada :angry: !").queue();
                pc.sendMessage("Vo te mete a porrada :angry: !").queue();
                pc.sendMessage("Vo te mete a porrada :angry: !").queue();
                pc.sendMessage("Vo te mete a porrada :angry: !").queue();
                pc.sendMessage("Vo te mete a porrada :angry: !").queue();
                pc.sendMessage("Vo te mete a porrada :angry: !").queue();
            }
        }else {
            event.getMessage().getTextChannel().sendMessage("Você precisa ser o @Funchy para executar esse comando !");
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
