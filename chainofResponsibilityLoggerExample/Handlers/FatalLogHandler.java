package chainofResponsibilityLoggerExample.Handlers;

import chainofResponsibilityLoggerExample.LogLevel;

public class FatalLogHandler implements LogHandler {
    private LogHandler nextHandler;

    public FatalLogHandler(LogHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
    @Override
    public void handle(LogLevel logLevel,String text) {
        System.out.println("Inside the fatal log handler");
        this.nextHandler.handle(logLevel,text);

    }
}
