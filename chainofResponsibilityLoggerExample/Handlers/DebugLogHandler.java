package chainofResponsibilityLoggerExample.Handlers;

import chainofResponsibilityLoggerExample.LogLevel;
import chainofResponsibilityLoggerExample.publisher.Publisher;

public class DebugLogHandler implements LogHandler {

    private final Publisher publisher;
    LogHandler nextHandler;

    public DebugLogHandler(LogHandler nextHandler, Publisher publisher) {
        this.nextHandler = nextHandler;
        this.publisher = publisher;
    }

    @Override
    public void handle(LogLevel logLevel, String text) {
        System.out.println("Inside debug handler");
        if (logLevel == LogLevel.DEBUG) {
            System.out.println("Notification of debug handler");
            this.publisher.notifyAll(LogLevel.DEBUG + " " + text);
        }

        this.nextHandler.handle(logLevel, text);
    }
}
