package org.example;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import java.util.List;
public class Application extends ListenerAdapter {
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if (event.getMessage().getMentions().getMembers().contains(event.getGuild().getSelfMember())) {
            List<Member> mentionedMembers = event.getMessage().getMentions().getMembers();
            Message message = event.getMessage();
            if (mentionedMembers.size() == 1 && mentionedMembers.get(0).equals(event.getGuild().getSelfMember())) {
                event.getChannel().sendMessage("Bonjour, je suis le bot !").queue();
            }
        }

    }
    }


