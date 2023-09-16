package org.example;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Activity;
public class discordBot {
    public static void main(String[] args) {
        JDA jdaBuilder =  JDABuilder.createDefault("MTE1MTk3MTA5NDk5NjIwMTU2Mg.GU-CT1.T4p9pgQHWpmWGKqfZvp-TV6u9hQpyuE10XBJ-E")
                .setActivity(Activity.listening("your name"))
                .addEventListeners(new application()).build();
    }

}