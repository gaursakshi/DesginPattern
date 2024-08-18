package chainofResponsibilityLoggerExample.Handlers;

import chainofResponsibilityLoggerExample.LogLevel;

public class LogData {

    private final LogLevel logLevel;
    private final String message;
    public LogData(LogLevel logLevel, String message) {
        this.logLevel = logLevel;
        this.message = message;
    }
    public LogLevel getLogLevel() {
        return logLevel;
    }
    public String getMessage() {
        return message;
    }
}
