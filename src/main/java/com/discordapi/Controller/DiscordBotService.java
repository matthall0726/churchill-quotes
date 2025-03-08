package com.discordapi.Controller;

import jakarta.annotation.PostConstruct;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class DiscordBotService {

    @Value("${token}")
    private String token;

    private JDA jda;

    @PostConstruct
    public void init() {
        try {
            jda = JDABuilder.createDefault(token)
                    .setActivity(Activity.listening("\"War\" by Chief Keef"))
                    .build()
                    .awaitReady();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendMessageToChannel(String channelId, String message) {
        TextChannel channel = jda.getTextChannelById(channelId);
        if (channel != null) {
            channel.sendMessage(message).queue();
        } else {
            System.out.println("Channel not found!");
        }
    }
}
