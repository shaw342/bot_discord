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
            String[] newMessage = Message.split(" ");
            if (mentionedMembers.size() == 1 && mentionedMembers.get(0).equals(event.getGuild().getSelfMember()) && !event.getAuthor().isBot()) {
                if (newMessage[1].equals("calculatrice")) {
                    int number1 = Integer.parseInt(newMessage[2]);
                    int number2 = Integer.parseInt(newMessage[4]);
                    int result = 0;
                    if (newMessage[3].equals("+")) {
                        result = Operation.add(number1, number2);
                    } else if (newMessage[3].equals("-")) {
                        result = Operation.sub(number1,number2);
                    }
                    event.getChannel().sendMessage(Integer.toString(result)).queue();
                }

            }

        }


    }
    public  void onSlashCommandInteraction(@NotNull SlashCommandInteraction event){
        if (event.getName().equals("mob")){
            event.reply("your mob");
        }
    }



    }
