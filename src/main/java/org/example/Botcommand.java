package org.example;

import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.SlashCommandInteraction;
import org.jetbrains.annotations.NotNull;

public class Botcommand extends ListenerAdapter {
    public void onSlashCommandInteraction(@NotNull SlashCommandInteraction event){
        if (event.getName().equals("spoiler")){
            event.reply("tu a spoiler");
        }
    }
}
