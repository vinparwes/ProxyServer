package com.example.ProxyServer.rest_controllers;

import com.example.ProxyServer.Logger;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/horoscope")
public class HoroscropeRestController {

    private final String dailyURL = "https://horoscope-app-api.vercel.app/api/v1/get-horoscope/daily?sign=";
    private final String weeklyURL = "https://horoscope-app-api.vercel.app/api/v1/get-horoscope/weekly?sign=";
    private final String monthlyURL = "https://horoscope-app-api.vercel.app/api/v1/get-horoscope/monthly?sign=";
    private RestTemplate restTemplate;

    @Autowired
    public HoroscropeRestController() {
        this.restTemplate = new RestTemplate();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/daily")
    public String getDaily(@RequestParam(name = "sign") String sign,
                           @RequestParam(name = "day", required = false) String day) {
        StringBuilder builder = new StringBuilder();
        builder.append(dailyURL).append(sign);
        if(day != null) {
            builder.append("&day=").append(day.toUpperCase());
        }
        System.out.println(Logger.logEntry("FETCHING: " + weeklyURL + sign));
        return restTemplate.getForObject(builder.toString(), String.class);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/weekly")
    public String getWeekly(@RequestParam(name = "sign") String sign) {
        System.out.println(Logger.logEntry(weeklyURL + sign));
        return restTemplate.getForObject("FETCHING: " + weeklyURL + sign, String.class);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/monthly")
    public String getMonthly(@RequestParam(name = "sign") String sign) {
        System.out.println(Logger.logEntry(weeklyURL + sign));
        return restTemplate.getForObject("FETCHING: " + monthlyURL + sign, String.class);
    }
}
