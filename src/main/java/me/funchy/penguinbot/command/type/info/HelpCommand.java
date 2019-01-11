package me.funchy.penguinbot.command.type.info;

import me.funchy.penguinbot.command.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class HelpCommand implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getTextChannel().sendMessage("Minha lista de comandos: ").queue();
        event.getTextChannel().sendMessage("`!help` - Mostra a minha lista de comandos.").queue();
        event.getTextChannel().sendMessage("`!ping` - Mostra meu ping").queue();
        event.getTextChannel().sendMessage("`!gatinho` - Mostro um gatinho").queue();
        event.getTextChannel().sendMessage("`!cachorrinho` - Mostro um cachorrinho").queue();
        event.getTextChannel().sendMessage("`!limpar` - Limpa o chat").queue();
        event.getTextChannel().sendMessage("`!autor` - Mostra os dados do meu criador").queue();
        event.getTextChannel().sendMessage("`!avatar` - Mostra o avatar do usuario mensionado").queue();
        event.getTextChannel().sendMessage("`!guilds` - Mostra em quantos servidores eu estou").queue();
        event.getTextChannel().sendMessage("`!status` - Mostra meus status no servidor").queue();
        event.getTextChannel().sendMessage("`!version` - Mostra minha versão").queue();
        event.getTextChannel().sendMessage("`!tutorial` - Mostro alguns tutoriais").queue();
        event.getTextChannel().sendMessage("`!ip` - Mostro o ip do servidor").queue();
//        event.getTextChannel().sendMessage("``!enquete` - Cria uma enquete").queue();
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
