package chainofResponsibilityLoggerExample.Handlers;

import chainofResponsibilityLoggerExample.LogLevel;

public class WarningLogHandler implements LogHandler{

    private LogHandler nextHandler;
    public WarningLogHandler(LogHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
    @Override
    public void handle(LogLevel logLevel,String text) {
        System.out.println("Inside the warning handler");
        this.nextHandler.handle(logLevel,text);

    }
}
