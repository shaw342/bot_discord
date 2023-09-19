package org.example;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.SlashCommandInteraction;
import org.jetbrains.annotations.NotNull;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Application extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {

        if (event.getMessage().getMentions().getMembers().contains(event.getGuild().getSelfMember())) {
            List<Member> mentionedMembers = event.getMessage().getMentions().getMembers();
            Message message = event.getMessage();
            String Message = event.getMessage().getContentRaw();
            List<String> newMessage = arrayToken(Message);

            if (mentionedMembers.size() == 1 && mentionedMembers.get(0).equals(event.getGuild().getSelfMember()) && !event.getAuthor().isBot()) {
                event.getChannel().sendMessage("Bonjour, je suis le bot !" + newMessage.get(0)).queue();
            }

        }


    }
    public  void onSlashCommandInteraction(@NotNull SlashCommandInteraction event){
        if (event.getName().equals("mob")){
            event.reply("your mob");
        }
    }
    public  static ArrayList<String> arrayToken(String message){
        StringTokenizer st = new StringTokenizer(message);
        List<String> newMessage = new ArrayList<>();
        while (st.hasMoreTokens()){
            for (int i = 0; i < newMessage.size();i++) newMessage.set(i, st.nextToken());
        }
        return (ArrayList<String>) newMessage;
    }
    }


