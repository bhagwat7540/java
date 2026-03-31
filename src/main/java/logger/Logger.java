package logger;

import logger.Appender.LogAppender;
import logger.entities.LogMessage;
import logger.enums.LogLevel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Logger {
    private final String name;
    private Logger parent;
    private LogLevel level;
    private List<LogAppender> logAppenderList = new CopyOnWriteArrayList<>();

    public Logger(String name) {
        this.name = name;
    }

    void setParent(Logger parent) {
        this.parent = parent;
    }

    public void setLevel(LogLevel level) {
        this.level = level;
    }

    public void addAppender(LogAppender appender) {
        logAppenderList.add(appender);
    }

    public void removeAppender(LogAppender appender) {
        logAppenderList.remove(appender);
    }

    private LogLevel getEffectiveLevel() {
        if (this.level != null) return this.level;
        if (parent != null) return parent.getEffectiveLevel();
        return LogLevel.INFO;
    }

    public void info(String message) {
        this.log(LogLevel.INFO, message);
    }

    public void warning(String message) {
        this.log(LogLevel.WARN, message);
    }

    public void error(String message) {
        this.log(LogLevel.ERROR, message);
    }

    private void log(LogLevel msgLevel, String message) {
        if (msgLevel.getLevel() < getEffectiveLevel().getLevel()) return;

        LogMessage logMessage = new LogMessage(msgLevel, name, message);

        if (!logAppenderList.isEmpty()) {
            for (LogAppender a : logAppenderList) a.append(logMessage);
        } else if (parent != null) {
            parent.callAppenders(logMessage);
        }
    }

    void callAppenders(LogMessage logMessage) {
        if (!logAppenderList.isEmpty()) {
            for (LogAppender a : logAppenderList) a.append(logMessage);
        } else if (parent != null) {
            parent.callAppenders(logMessage);
        }
    }
}



