package ChainOfResposibiltyEnquirySystem.apis;

import ChainOfResposibiltyEnquirySystem.data.Response;
import ChainOfResposibiltyEnquirySystem.factory.EnquiryHandlerFactory;

public class HandleEnquiryAPI {

    public Response handleEnquiry(String text) {

        EnquiryHandlerFactory.getEnquiryHandler("enquiry").handleEnquiry(text);
        return null;

    }
}
