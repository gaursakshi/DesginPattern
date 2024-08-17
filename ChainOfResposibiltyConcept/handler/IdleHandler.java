package ChainOfResposibiltyConcept.handler;

import ChainOfResposibiltyConcept.data.Request;

public class IdleHandler implements RequestHandler{
    @Override
    public void handleRequest(Request request) {
        System.out.println("IDLE HANDLER");
        System.out.println("All done");

    }
}
