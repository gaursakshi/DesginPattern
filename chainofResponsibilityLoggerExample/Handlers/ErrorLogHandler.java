package chainofResponsibilityLoggerExample.Handlers;

import chainofResponsibilityLoggerExample.LogLevel;
import chainofResponsibilityLoggerExample.publisher.Publisher;

public class ErrorLogHandler implements LogHandler{

    private LogHandler nextHandler;

    private Publisher publisher;

    public ErrorLogHandler(LogHandler nextHandler,Publisher publisher) {
        this.nextHandler = nextHandler;
        this.publisher = publisher;
    }
    @Override
    public void handle(LogLevel logLevel,String text) {
        System.out.println("Inside the error log handler");
        if(logLevel.getLevel()==(LogLevel.ERROR.getLevel())) {
            //write in the destination
            this.publisher.notifyAll(LogLevel.ERROR +" "+ text);;
        }
        this.nextHandler.handle(logLevel,text);

    }
}
