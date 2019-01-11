package me.funchy.penguinbot.command.type.info;

import me.funchy.penguinbot.command.Command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UpTimeCommand implements Command {

    public static Date lastRestart;


    private String getTime(Date date, String pattern) {
        return new SimpleDateFormat(pattern).format(date);
    }

    private String getTimeDiff(Date date1, Date date2) {
        long diff = date1.getTime() - date2.getTime();
        long diffSeconds = diff / 1000 % 60;
        long diffMinutes = diff / (60 * 1000) % 60;
        long diffHours = diff / (60 * 60 * 1000) % 24;
        long diffDays = diff / (24 * 60 * 60 * 1000);
        return diffDays + " d, " + parseTimeNumbs(diffHours) + " h, " + parseTimeNumbs(diffMinutes) + " min, " + parseTimeNumbs(diffSeconds) + " sec";
    }

    private String parseTimeNumbs(long time) {
        String timeString = time + "";
        if (timeString.length() < 2)
            timeString = "0" + time;
        return timeString;
    }


    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws IOException {

       // event.getTextChannel().sendMessage("Estou acordado por ", getTimeDiff(new Date(), this.lastRestart), false).queue();
        event.getTextChannel().sendMessage(
                new EmbedBuilder()
                        .setColor(new Color(255, 71,0))
                        .setDescription(":alarm_clock:   **Status**")
                 //       .addField("Last restart", getTime(this.lastRestart, "dd.MM.yyyy - HH:mm:ss (z)"), false)
                        .addField("Estou acorado por ", getTimeDiff(new Date(), this.lastRestart), false)
                        .build()
        ).queue();

    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return "USAGE: -uptime";
}
}
