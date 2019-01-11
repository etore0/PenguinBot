package me.funchy.penguinbot.listeners;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;

public class onJoin extends ListenerAdapter {


    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event){
        User u = event.getUser();
        Guild guild = event.getGuild();
        if(guild.getId().equals("506205235698728962")){
            event.getGuild().getTextChannelById("522397520064937985").sendMessage(new EmbedBuilder().setColor(new Color(99, 230, 100)).setAuthor(u.getName() + " entrou no servidor! ", null, u.getAvatarUrl()).setDescription("Uma nova pessoa juntou-se ao servidor!").build()).queue();
        }else {
            event.getGuild().getTextChannelById("527464751811264522").sendMessage(new EmbedBuilder().setColor(new Color(99, 230, 100)).setAuthor(u.getName() + " entrou no servidor! ", null, u.getAvatarUrl()).setDescription("Uma nova pessoa juntou-se ao servidor!").build()).queue();
            event.getGuild().getController().addRolesToMember(event.getMember(), event.getGuild().getRolesByName("Cidadão", true)).queue();
        }
    }

}
