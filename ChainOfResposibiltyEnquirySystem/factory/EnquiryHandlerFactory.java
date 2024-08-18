package ChainOfResposibiltyEnquirySystem.factory;

import ChainOfResposibiltyEnquirySystem.handlers.*;

public class EnquiryHandlerFactory {

    private EnquiryHandlerFactory() {
    }

    public static EnquiryHandler getEnquiryHandler(String enquiryType) {
        return new LogHandler(new AcademicHandler(new ProjectEnquiryHandler(new SubscriptionHandler(new IdleHandler()))));
    }
}
