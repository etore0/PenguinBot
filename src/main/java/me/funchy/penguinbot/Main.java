package me.funchy.penguinbot;

import me.funchy.penguinbot.command.Command;
import me.funchy.penguinbot.command.CommandHandler;
import me.funchy.penguinbot.command.type.admin.ClearCommand;
import me.funchy.penguinbot.command.type.admin.CreatorCommand;
import me.funchy.penguinbot.command.type.admin.SpamCommand;
import me.funchy.penguinbot.command.type.fun.CatCommand;
import me.funchy.penguinbot.command.type.fun.DogCommand;
import me.funchy.penguinbot.command.type.fun.PoliceCommand;
import me.funchy.penguinbot.command.type.fun.WhoCommand;
import me.funchy.penguinbot.command.type.info.*;
import me.funchy.penguinbot.listeners.Listeners;
import me.funchy.penguinbot.listeners.onJoin;
import me.funchy.penguinbot.listeners.onLeave;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;

import javax.security.auth.login.LoginException;

public class Main {


   public static void main(String[] args) throws LoginException {
      JDABuilder builder = new JDABuilder(AccountType.BOT);
      String token = "NTIxODU3NTg5NDI4ODc5MzY1.DvChZw.rL0Jdxj0VZXg1KJI8kY1u-IkCH0";
      builder.setToken(token);
      builder.setGame(Game.of(Game.GameType.DEFAULT, "Desenvolvido por Funchy"));
//      timeStart = System.currentTimeMillis();
      builder.addEventListener(new Listeners());
      builder.addEventListener(new onJoin());
      builder.addEventListener(new onLeave());
      CommandHandler.commands.put("ajuda", new HelpCommand());
      CommandHandler.commands.put("ping", new PingCommand());
      CommandHandler.commands.put("limpar", new ClearCommand());
      CommandHandler.commands.put("cachorrinho", new DogCommand());
      CommandHandler.commands.put("fuckpolice", new PoliceCommand());
      CommandHandler.commands.put("spam", new SpamCommand());
      CommandHandler.commands.put("guilds", new GuildsCommand());
      CommandHandler.commands.put("tutorial", new TutorialCommand());
      CommandHandler.commands.put("comovaiodia", new WhoCommand());
      CommandHandler.commands.put("gatinho", new CatCommand());
      CommandHandler.commands.put("autor", new OwnerCommand());
      CommandHandler.commands.put("avatar", new AvatarCommand());
      CommandHandler.commands.put("ip", new IPCommand());
      CommandHandler.commands.put("uptime", new UpTimeCommand());
      CommandHandler.commands.put("creator", new CreatorCommand());
       builder.buildAsync();
   }

}
