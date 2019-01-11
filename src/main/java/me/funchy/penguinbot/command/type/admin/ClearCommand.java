package me.funchy.penguinbot.command.type.admin;

import me.funchy.penguinbot.command.Command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageHistory;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.utils.PermissionUtil;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ClearCommand implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    private int getInt(String arg) {

        try {
            return Integer.parseInt(arg);
        } catch (Exception e) {
            return 0;
        }

    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        Member author = event.getMember();
        if(!author.hasPermission(Permission.ADMINISTRATOR)){
             event.getTextChannel().sendMessage("Você não tem permissão para executar esse comando!");
        }else {
            MessageHistory history = new MessageHistory(event.getTextChannel());
            List<Message> msgs;
            if (args.length == 1 && args[0].equalsIgnoreCase("tudo")) {
                try {
                    while (true) {
                        msgs = history.retrievePast(1).complete();
                        msgs.get(0).delete().queue();
                    }
                } catch (Exception ex) {
                    //Nichts tun
                }

                Message answer = event.getTextChannel().sendMessage(MSGS.success().setDescription("Chat limpo com sucesso"
                ).build()).complete();

                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        answer.delete().queue();
                    }
                }, 3000);

            }else if (args.length < 1 || (args.length > 0 ? getInt(args[0]) : 1) == 1 && (args.length > 0 ? getInt(args[0]) : 1) < 2) {

                event.getMessage().delete().queue();
                msgs = history.retrievePast(2).complete();
                msgs.get(0).delete().queue();


                Message answer = event.getTextChannel().sendMessage(MSGS.success().setDescription(
                        "Você deletou as ultimas mensagens com sucesso"
                ).build()).complete();

                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        answer.delete().queue();
                    }
                }, 3000);

            } else if(args.length == 2) {
                // 24/03/2013 21:54
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                StringBuilder builder = new StringBuilder();

                for (String arg: args) {
                    builder.append(" " + arg);
                }

                try
                {
                    Date date = simpleDateFormat.parse(builder.toString());

                    boolean weiter = true;
                    try {
                        while (weiter) {
                            msgs = history.retrievePast(1).complete();
                            if (date.before(Date.from(msgs.get(0).getCreationTime().toZonedDateTime().toInstant()))) {
                                msgs.get(0).delete().queue();
                            } else {
                                weiter = false;
                            }

                        }

                        Message answer = event.getTextChannel().sendMessage(MSGS.success().setDescription(
                                "Chat liimpo com sucesso !"
                        ).build()).complete();

                        new Timer().schedule(new TimerTask() {
                            @Override
                            public void run() {
                                answer.delete().queue();
                            }
                        }, 3000);
                    } catch (Exception ex) {
                        //Nichts tun
                    }
                }
                catch (ParseException ex)
                {
                    event.getTextChannel().sendMessage(MSGS.error()
                            .addField("Error Type", "Wrong Timeformat.", false)
                            .addField("Description", "Pleas enter the Time in the right Timeformat:\n" + simpleDateFormat.format(new Date()), false)
                            .build()
                    ).queue();
                }

            } else if (getInt(args[0]) <= 100) {

                event.getMessage().delete().queue();
                msgs = history.retrievePast(getInt(args[0])).complete();
                event.getTextChannel().deleteMessages(msgs).queue();

                Message answer = event.getTextChannel().sendMessage(MSGS.success().setDescription(
                        "Você deletou " + args[0] + " mensagens com sucesso"
                ).build()).complete();

                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        answer.delete().queue();
                    }
                }, 3000);
            } else {
                event.getTextChannel().sendMessage(MSGS.error()
                        .addField("Error Type", "Message value out of bounds.", false)
                        .addField("Description", "The entered number if messages can not be more than 100 messages!", false)
                        .build()
                ).queue();
            }
        }


    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }

    public static class MSGS {

        public static EmbedBuilder success() {
            return new EmbedBuilder().setColor(Color.green);
        }

        public static EmbedBuilder error() {
            return new EmbedBuilder().setColor(Color.red);
        }

    }

    }
