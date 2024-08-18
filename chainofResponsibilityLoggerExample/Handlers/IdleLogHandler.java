package chainofResponsibilityLoggerExample.Handlers;

import chainofResponsibilityLoggerExample.LogLevel;

public class IdleLogHandler implements LogHandler {
    private LogHandler nextHandler;
    

    @Override
    public void handle(LogLevel logLevel, String text) {
        System.out.println("IDLE: " + text);
        
    }
}
