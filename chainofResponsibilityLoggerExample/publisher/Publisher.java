package chainofResponsibilityLoggerExample.publisher;

import chainofResponsibilityLoggerExample.subscribers.LogSubscriber;

public interface Publisher {

    public void subscribe(LogSubscriber subscriber);

    public void unsubscribe(LogSubscriber subscriber);

    public void notifyAll(String message);
}
