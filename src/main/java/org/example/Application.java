package org.example;

import com.google.gson.Gson;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.guild.update.GuildUpdateNSFWLevelEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.jetbrains.annotations.NotNull;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {

        List<String>  name = new ArrayList<>();
        try {
            String apiUrl = "https://jsonplaceholder.typicode.com/users";
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine = null;
                StringBuilder response = new StringBuilder();
                while ((inputLine = (reader.readLine())) != null) {
                    response.append(inputLine);

                }
                Gson gson =  new Gson();
                List<User> users = Arrays.asList(gson.fromJson(response.toString(), User[].class));

                for (int i = 0;i < 5 ;i++){
                    name.add(users.get(i).getName());
                }

            String[] newMessage;
            if (event.getMessage().getMentions().getMembers().contains(event.getGuild().getSelfMember()))
            {
                List<Member> mentionedMembers = event.getMessage().getMentions().getMembers();
                String Message = event.getMessage().getContentRaw();
                newMessage = Message.split(" ");
                if (mentionedMembers.size() == 1 && mentionedMembers.get(0).equals(event.getGuild().getSelfMember()) && !event.getAuthor().isBot())
                {
                    EmbedBuilder embed = new EmbedBuilder();
                    if (newMessage[1].equals("calculatrice"))
                    {
                        int number1 = Integer.parseInt(newMessage[2]);
                        int number2 = Integer.parseInt(newMessage[4]);
                        int result = 0;
                        if (newMessage[3].equals("+"))
                        {
                            result = Operation.add(number1, number2);
                        } else if (newMessage[3].equals("-"))
                        {
                            result = Operation.sub(number1, number2);
                        }
                        embed.setTitle(Integer.toString(result));
                        embed.setTitle(name.toString());
                        event.getChannel().sendMessage(Integer.toString(result)).setEmbeds(embed.build()).queue();
                        embed.clear();
                    } else if (newMessage[1].equals("initpower4")) {
                        Power4.initGrid(Power4.gridArray);
                        event.getChannel().sendMessage(Power4.printGrid(Power4.gridArray)).queue();
                    } else if (newMessage[1].equals("power4"))
                    {
                     /*event.getChannel().sendMessage(
                                    "choisissez vôtre couleur BLUE OU RED après le power4 exemple: "
                                    + event.getGuild().getName()+ " " + newMessage[1] + " red");

                        final String namePlayer1 = event.getMember().getUser().getName();
                        final String namePlayer2 = event.getMember().getUser().getName();

                     */

                        int position = Integer.parseInt(newMessage[2]);
                        position_Status player = Power4.inEnum(newMessage[3]);
                        Power4.addPawn(Power4.gridArray, position, player);

                        event.getChannel().sendMessage(Power4.printGrid(Power4.gridArray)).queue();
                    }
                    else
                    {
                        if (newMessage[1].equals("!help")) {
                            event.getChannel().sendMessage("hello\n"+name.toString()).queue();
                        }
                    }


                }
            }
            reader.close();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }





    private static class User
    {
        private String name;
        private String email;

        public String getName()
        {
            return name;
        }

        public String getEmail()
        {
            return email;
        }
    }

}