package com.discordapi.Dataholder;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Configuration
public class ChurchillQuotes {

    public static ArrayList<String> data;

    public ChurchillQuotes() {
        String filePath = "src/main/resources/churchill_365_quotes.csv";
        data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] valuesArray = line.split(",");
                String values = String.join(",", valuesArray);
                data.add(values);
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }







}
