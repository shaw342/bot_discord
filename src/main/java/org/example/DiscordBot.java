package org.example;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Activity;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.interactions.commands.DefaultMemberPermissions;
import java.util.Queue;
import net.dv8tion.jda.api.Permission;

public class DiscordBot {


    public static void main(String[] args)  {

        Dotenv dotenv = Dotenv.configure().load();
        String token = dotenv.get("DISCORD_BOT_TOKEN");
        String serverId = dotenv.get("ID_SERVEUR");
        JDA jdaBuilder = JDABuilder.createDefault(token)
                .setActivity(Activity.listening("your name"))
                .addEventListeners(new Application()).build();


    }



}