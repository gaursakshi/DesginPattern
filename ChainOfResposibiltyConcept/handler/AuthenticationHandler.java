package ChainOfResposibiltyConcept.handler;

import ChainOfResposibiltyConcept.data.Request;
import ChainOfResposibiltyConcept.mangers.TokenManager;

public class AuthenticationHandler implements RequestHandler {

    private final RequestHandler nextHandler;

    private final TokenManager tokenManger;

    public AuthenticationHandler(RequestHandler nextHandler, TokenManager tokenManger) {
        this.nextHandler = nextHandler;
        this.tokenManger = tokenManger;
    }

    @Override
    public void handleRequest(Request request) {
        //  this uusally work with token
        String token = request.getToken();
        String email = this.tokenManger.getEmailFromToken(token);
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Email is invalid");
        }
        System.out.println("authentication successful");
        this.nextHandler.handleRequest(request);

    }

    private boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        return true;

    }
}
