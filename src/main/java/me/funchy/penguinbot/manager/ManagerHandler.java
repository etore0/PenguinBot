package me.funchy.penguinbot.manager;

import lombok.Getter;
import me.funchy.penguinbot.manager.type.ChatManager;
import me.funchy.penguinbot.manager.type.GuildManager;

public class ManagerHandler {


    @Getter
    private static ChatManager chatManager;
    @Getter
    private static GuildManager  guildManager;




    public ManagerHandler(ChatManager chatManager, GuildManager guildManager) {
        this.chatManager = chatManager;
        this.guildManager = guildManager;
    }
}
