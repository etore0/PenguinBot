package me.funchy.penguinbot.command.type.admin;

import me.funchy.penguinbot.command.Command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zekro on 05.06.2017 / 10:17
 * DiscordBot/commands.chat
 * © zekro 2017
 */

public class PollCommand implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws IOException {

        if (args.length < 1) {
            event.getTextChannel().sendMessage(ClearCommand.MSGS.error().setDescription(help()).build()).queue();
            return;
        }

        event.getMessage().delete().queue();

        Message chanMSG = event.getTextChannel().sendMessage(new EmbedBuilder().setDescription("Searching for message in text channels...").build()).complete();

        List<Message> msg = new ArrayList<>();
        event.getGuild().getTextChannels().forEach(c -> {
            try {
                msg.add(c.getMessageById(args[0]).complete());
            } catch (Exception e) {}
        });

        if (msg.size() < 1) {
            chanMSG.editMessage(ClearCommand.MSGS.error().setDescription(
                    "Ocorreu  um erro ao tentar achar o id da mensagem `" + args[0] + "`."
            ).build()).queue();
            return;
        }

        chanMSG.editMessage(new EmbedBuilder()
                .setAuthor(msg.get(0).getAuthor().getName(), null, msg.get(0).getAuthor().getAvatarUrl())
                .setDescription(msg.get(0).getContentDisplay())
                .setFooter(
                        msg.get(0).getCreationTime().getDayOfMonth() + ". " +
                                msg.get(0).getCreationTime().getMonth() + " " +
                                msg.get(0).getCreationTime().getYear() +
                                " ha " + msg.get(0).getCreationTime().getHour() + ":" +
                                msg.get(0).getCreationTime().getMinute() + ":" +
                                msg.get(0).getCreationTime().getSecond() +
                                " no canal #" + msg.get(0).getTextChannel().getName(),
                        null)
                .build()
        ).queue();

    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return "**USAGE:** `-quote <msg id>`";
    }

    public String description() {
        return "Quote a message in any channel on guild";
    }


    public int permission() {
        return 0;
    }
}