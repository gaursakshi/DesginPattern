package chainofResponsibilityLoggerExample.publisher;

import chainofResponsibilityLoggerExample.subscribers.LogSubscriber;

import java.util.ArrayList;
import java.util.List;

public class LogPublisher implements Publisher {

    List<LogSubscriber> subscriberList;


    public LogPublisher() {
        this.subscriberList = new ArrayList<>();
    }

    @Override
    public void subscribe(LogSubscriber subscriber) {
        this.subscriberList.add(subscriber);

    }

    @Override
    public void unsubscribe(LogSubscriber subscriber) {
        this.subscriberList.remove(subscriber);

    }

    @Override
    public void notifyAll(String message) {
        for (LogSubscriber subscriber : subscriberList) {
            subscriber.update(message);
        }

    }
}
