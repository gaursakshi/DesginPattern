package chainofResponsibilityLoggerExample.factory;

import chainofResponsibilityLoggerExample.Handlers.*;
import chainofResponsibilityLoggerExample.publisher.LogPublisher;
import chainofResponsibilityLoggerExample.publisher.Publisher;
import chainofResponsibilityLoggerExample.subscribers.ConsoleSubscriber;
import chainofResponsibilityLoggerExample.subscribers.FileSubscriber;

import java.io.IOException;

public class LoggerFactory {

    private LoggerFactory() {
    }

    public static LogHandler getLogger() throws IOException {
        //debug and info publisher
        Publisher debugLevelInfoPublisher = new LogPublisher();
        debugLevelInfoPublisher.subscribe(new ConsoleSubscriber());

        Publisher warnAndAbovePub = new LogPublisher();
        warnAndAbovePub.subscribe(new FileSubscriber("log.txt"));
        warnAndAbovePub.subscribe(new ConsoleSubscriber());

        return new DebugLogHandler(new InfoLogHandler(new ErrorLogHandler(new FatalLogHandler(new IdleLogHandler()), warnAndAbovePub)), debugLevelInfoPublisher);

    }

}
