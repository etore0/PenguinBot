package me.funchy.penguinbot.manager.type;

import lombok.Getter;
import lombok.Setter;
import me.funchy.penguinbot.server.GuildType;
import net.dv8tion.jda.core.entities.Guild;

public class GuildManager {


    @Getter
    @Setter
    private GuildType guildType;


    public static void setupGuild(Guild guild){

    }
}
