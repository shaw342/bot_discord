package org.example;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Activity;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.entities.Guild;

public class DiscordBot {


    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure().load();
        String token = dotenv.get("DISCORD_BOT_TOKEN");
        JDA jdaBuilder = JDABuilder.createDefault(token)
                .setActivity(Activity.listening("your name"))
                .addEventListeners(new Application()).build();

       // Guild guild = jdaBuilder.getGuildById("1152207053473988658");
        jdaBuilder.upsertCommand("mob","mob is good").setGuildOnly(true).queue();

    }

}