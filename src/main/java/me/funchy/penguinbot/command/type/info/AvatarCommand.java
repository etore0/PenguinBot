package me.funchy.penguinbot.command.type.info;

import me.funchy.penguinbot.command.Command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;
import java.io.IOException;

public class AvatarCommand implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws IOException {
        User avatar = null;

        if(args.length == 0) {  // Self
            avatar = event.getAuthor();
        } else if(args[0].length() == 18) {  // ID (18 characters)
            avatar = event.getJDA().getUserById(args[0]);
        } else if(!event.getMessage().getMentionedUsers().isEmpty()) {  // Mention
            avatar = event.getMessage().getMentionedUsers().get(0);
        }

        if(avatar != null) {
            EmbedBuilder embed = new EmbedBuilder().setColor(new Color(74, 138, 230))
                    .setDescription("**["+avatar.getName()+"#"+avatar.getDiscriminator()+"](" + avatar.getEffectiveAvatarUrl() + "):**")
                    .setImage(avatar.getEffectiveAvatarUrl());

            event.getChannel().sendMessage(embed.build()).queue();
        } else {
            event.getChannel().sendMessage("Error").queue();
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
