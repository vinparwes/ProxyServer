package com.example.ProxyServer;

import java.time.LocalDateTime;

public class Logger {

    public static String logEntry(String details) {
        return String.format("%s%s%s%s%s", LocalDateTime.now(),"  ", "INTERNAL", "   --- ", details);
    }
}
