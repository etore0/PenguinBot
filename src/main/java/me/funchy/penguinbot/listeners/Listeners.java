package me.funchy.penguinbot.listeners;

import me.funchy.penguinbot.command.CommandHandler;
import me.funchy.penguinbot.utils.Utils;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.io.IOException;

public class Listeners extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) {
            return;
        }
        if (event.getChannelType() == ChannelType.PRIVATE) {
            event.getAuthor().openPrivateChannel().complete().sendMessage("Não aceito mensagens privadas !").queue();
            System.out.println(event.getMessage().toString());
            return;
        }
        String message = event.getMessage().getContentDisplay();
        if (message.startsWith(Utils.getPrefix) && event.getAuthor().getId() != event.getJDA().getSelfUser().getId()) {
            try {
                CommandHandler.handleCommand(CommandHandler.paser.parse(message, event));
                System.out.println(event.getMessage().toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
