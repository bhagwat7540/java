package logger;

import logger.Appender.ConsoleAppender;
import logger.enums.LogLevel;
import logger.formatter.SimpleTextFormatter;

public class LoggerDemo {
    public static void main(String[] args) {
        LoggerManager manager = LoggerManager.getInstance();

        Logger dbLogger = manager.getLogger("database");
        dbLogger.setLevel(LogLevel.INFO);
        dbLogger.addAppender(new ConsoleAppender(new SimpleTextFormatter()));

        Logger queryLogger = manager.getLogger("database.queries");
// queryLogger has NO level set, NO appender set
// → inherits DEBUG level from "database"
// → delegates appending to "database"'s FileAppender

        Logger paymentLogger = manager.getLogger("payment");
// paymentLogger has NO config at all
// → inherits INFO level from root
// → delegates to root's ConsoleAppender

        queryLogger.warning("SELECT * FROM users");
        paymentLogger.info("Payment processed");
        paymentLogger.error("Internal detail");
    }
}
