package chainofResponsibilityLoggerExample.subscribers;


public class ConsoleSubscriber implements LogSubscriber {
    @Override
    public void update(String message) {
        System.out.println("writing on to the console");
        System.out.println(message);


    }
}
