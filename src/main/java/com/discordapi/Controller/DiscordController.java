package com.discordapi.Controller;

import com.discordapi.Dataholder.ChurchillQuotes;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;


@RestController
@RequestMapping("/discord")
public class DiscordController {

    private final DiscordBotService discordBotService;

    public DiscordController(DiscordBotService discordBotService) {
        this.discordBotService = discordBotService;
        sendMessage("1273470899957530656", "I'm up in this hoe");
    }

    @PostMapping("/send")
    public String sendMessage(String channelId, String churchHillQuote) {
        discordBotService.sendMessageToChannel(channelId, churchHillQuote);
        return "Message sent!";
    }


    @Scheduled(cron = "0 0 12 * * ?")
    public void callSlashCommand() {
        LocalDate date = LocalDate.now();
        int dayOfYear = date.getDayOfYear();
        sendMessage("1273470899957530656", String.format("\"%s\" - Winston Churchill", ChurchillQuotes.data.get(dayOfYear)));
    }



}


