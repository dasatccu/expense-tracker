package org.et.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogService {

    private static Logger getLogger() {
        String className = Thread.currentThread().getStackTrace()[3].getClassName();
        return LogManager.getLogger(className);
    }

    public static void info(String tag, String message) {
        String formatted = formatMessage(tag, message);
        getLogger().info(formatted);
    }

    public static void debug(String tag, String message){
        String formatted = formatMessage(tag, message);
        getLogger().debug(formatted);
    }

    public static void error(String tag, String message, Throwable t) {
        String formatted = formatMessage(tag, message);
        getLogger().error(formatted, t);
    }

    private static String formatMessage(String tag, String message) {
        // Customize your log format here
        String timestamp = java.time.LocalDateTime.now().toString();
        return String.format("[%s] [%s] %s", timestamp, tag.toUpperCase(), message);
    }
}
