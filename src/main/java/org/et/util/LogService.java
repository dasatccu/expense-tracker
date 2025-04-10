package org.et.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogService {
    private static boolean bannerPrinted = false;

    private static Logger getLogger() {
        printBannerOnce();
        String className = Thread.currentThread().getStackTrace()[3].getClassName();
        return LogManager.getLogger(className);
    }

    private static void printBannerOnce() {
        if (!bannerPrinted) {
            System.out.println("\n" +
                    "___________                                            ___________                     __                 \n" +
                    "\\_   _____/__  _________   ____   ____   ______ ____   \\__    ___/___________    ____ |  | __ ___________ \n" +
                    " |    __)_\\  \\/  /\\____ \\_/ __ \\ /    \\ /  ___// __ \\    |    |  \\_  __ \\__  \\ _/ ___\\|  |/ // __ \\_  __ \\\n" +
                    " |        \\>    < |  |_> >  ___/|   |  \\\\___ \\\\  ___/    |    |   |  | \\// __ \\\\  \\___|    <\\  ___/|  | \\/\n" +
                    "/_______  /__/\\_ \\|   __/ \\___  >___|  /____  >\\___  >   |____|   |__|  (____  /\\___  >__|_ \\\\___  >__|   \n" +
                    "        \\/      \\/|__|        \\/     \\/     \\/     \\/                        \\/     \\/     \\/    \\/       \n");
            bannerPrinted = true;
        }
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
