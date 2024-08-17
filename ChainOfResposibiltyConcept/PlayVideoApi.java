package ChainOfResposibiltyConcept;

import ChainOfResposibiltyConcept.data.Request;
import ChainOfResposibiltyConcept.data.Response;

public class PlayVideoApi {

    public Response playVideo(Request request) {

        RequestHandlerFactory.getRequestHandler("playVideo").handleRequest(request);
        return null;

    }
}
