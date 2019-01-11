package me.funchy.penguinbot.command.type.fun;

import me.funchy.penguinbot.command.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class CatCommand implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws IOException, NullPointerException, JSONException {
        String url = new String();
        OkHttpClient caller = new OkHttpClient();
        Request request = new Request.Builder().url("https://aws.random.cat/meow").build();
        Response response = caller.newCall(request).execute();
        JSONObject json = new JSONObject(response.body().string());
        url = (String) json.get("file");
        System.out.println(json);
        event.getTextChannel().sendMessage("Acho que vi um gatinho :cat:").queue();
        event.getTextChannel().sendMessage(url).queue();
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
