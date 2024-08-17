package ChainOfResposibiltyConcept.handler;

import ChainOfResposibiltyConcept.data.Request;
import ChainOfResposibiltyConcept.mangers.UserManager;


public class AuthorisationHandler implements RequestHandler {

    private final RequestHandler nextHandler;
    private final UserManager userManager;

    public AuthorisationHandler(RequestHandler nextHandler, UserManager userManager) {
        this.userManager = userManager;
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(Request request) {
        String token = request.getToken();
        if (!this.userManager.isSubscribed(token)) {
            throw new RuntimeException("Authorization failed");
        }
        System.out.println("Authorisation passed");

        this.nextHandler.handleRequest(request);

    }
}
