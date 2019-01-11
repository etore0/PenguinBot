package me.funchy.penguinbot.command;

import me.funchy.penguinbot.utils.Utils;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.ArrayList;

public class CommandParser {

    public commandContainer parse(String raw, MessageReceivedEvent event){

        String bheaded = raw.replaceFirst(Utils.getPrefix ,  "");
        String[] splitBeheaded = bheaded.split(" ");
        String invoke = splitBeheaded[0];
        ArrayList<String> split = new ArrayList <String>();
        for(String s : splitBeheaded){
            split.add(s);
        }
        String[] args = new String[split.size() -1];
        split.subList(1, split.size()).toArray(args);

        return new commandContainer(raw, bheaded, splitBeheaded, invoke, args, event);
    }

    public class commandContainer{
        public final String raw;
        public final String beheaded;
        public final String[] splitBeheaded;
        public final String invoke;
        public final String[] args;
        public final MessageReceivedEvent event;

        public commandContainer(String rw,String beheaded,String[] splitBeheaded,String invoke,String[] args, MessageReceivedEvent event){
            this.raw = rw;
            this.beheaded = beheaded;
            this.invoke = invoke;
            this.splitBeheaded = splitBeheaded;
            this.args = args;
            this.event = event;
        }
    }


}
