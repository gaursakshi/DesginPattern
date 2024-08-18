package chainofResponsibilityLoggerExample.Handlers;

import chainofResponsibilityLoggerExample.LogLevel;

public class InfoLogHandler implements LogHandler {

    private LogHandler nextHandler;

    public InfoLogHandler(LogHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handle(LogLevel logLevel,String text) {
        System.out.println("Inside the info log handler");
        this.nextHandler.handle(logLevel,text);


    }
}
