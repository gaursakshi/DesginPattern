package chainofResponsibilityLoggerExample;

import chainofResponsibilityLoggerExample.Handlers.LogHandler;
import chainofResponsibilityLoggerExample.factory.LoggerFactory;

public class Main {
    public static void main(String[] args) {
        try {
            LogHandler logHandler = LoggerFactory.getLogger();
            logHandler.handle(LogLevel.ERROR,"DB query failed");
            logHandler.handle(LogLevel.DEBUG, "Received an empty response");
        }
        catch (Exception e){
            e.getMessage();
        }
    }
}
