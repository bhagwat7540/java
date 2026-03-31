package logger.formatter;

import logger.entities.LogMessage;

public interface LogFormatter {
    public String format(LogMessage logMessage);
}
