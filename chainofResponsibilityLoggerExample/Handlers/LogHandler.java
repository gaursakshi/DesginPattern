package chainofResponsibilityLoggerExample.Handlers;


import chainofResponsibilityLoggerExample.LogLevel;

public interface LogHandler {

    public void handle(LogLevel logLevel ,String text);
}
