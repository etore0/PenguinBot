package me.funchy.penguinbot.listeners;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;

public class onLeave extends ListenerAdapter {


    @Override
    public void onGuildMemberLeave(GuildMemberLeaveEvent event){
        User u = event.getUser();
        Guild guild = event.getGuild();

        if(guild.getId().equals("506205235698728962")){
            event.getGuild().getTextChannelById("522397520064937985").sendMessage(new EmbedBuilder().setColor(new Color(230, 17, 9)).setAuthor(u.getName() + " saiu do servidor! ", null, u.getAvatarUrl()).setDescription(u.getName() + "é muito mal, tomem cuidado com ele").build()).queue();
        }else {
            event.getGuild().getTextChannelById("527464751811264522").sendMessage(new EmbedBuilder().setColor(new Color(230, 17, 9)).setAuthor(u.getName() + " saiu do servidor! ", null, u.getAvatarUrl()).setDescription(":(").build()).queue();
        }
    }

}
