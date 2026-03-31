package logger;

import logger.Appender.ConsoleAppender;
import logger.enums.LogLevel;
import logger.formatter.SimpleTextFormatter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LoggerManager {
    private static final LoggerManager INSTANCE = new LoggerManager();
    private final Map<String, Logger> loggers = new ConcurrentHashMap<>();
    private final Logger rootLogger;

    private LoggerManager() {
        rootLogger = new Logger("root");
        rootLogger.setLevel(LogLevel.INFO);
        rootLogger.addAppender(new ConsoleAppender(new SimpleTextFormatter()));
        loggers.put("root", rootLogger);
    }

    public static LoggerManager getInstance() {
        return INSTANCE;
    }

    public synchronized Logger getLogger(String name) {
        if (loggers.containsKey(name)) return loggers.get(name);

        Logger logger = new Logger(name);
        logger.setParent(findParent(name));
        loggers.put(name, logger);
        return logger;
    }

    private Logger findParent(String name) {
        int dotIndex = name.lastIndexOf('.');
        if (dotIndex == -1) return rootLogger;

        String parentName = name.substring(0, dotIndex);
        return getLogger(parentName);
    }
}
