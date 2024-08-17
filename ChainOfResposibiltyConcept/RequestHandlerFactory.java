package ChainOfResposibiltyConcept;

import ChainOfResposibiltyConcept.handler.*;
import ChainOfResposibiltyConcept.mangers.TokenManager;
import ChainOfResposibiltyConcept.mangers.UserManager;

public class RequestHandlerFactory {

    private RequestHandlerFactory(){

    };

    public static RequestHandler getRequestHandler(String requestType){
        return new ValidationHandler
                (new AuthenticationHandler(new AuthorisationHandler(new IdleHandler(),new UserManager()), new TokenManager()));

    }
}
