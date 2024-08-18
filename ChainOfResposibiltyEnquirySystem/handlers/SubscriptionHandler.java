package ChainOfResposibiltyEnquirySystem.handlers;

import ChainOfResposibiltyEnquirySystem.data.EnquiryType;

public class SubscriptionHandler implements EnquiryHandler {

    private EnquiryHandler nextHandler;

    public SubscriptionHandler(EnquiryHandler enquiryHandler) {
        this.nextHandler = nextHandler;
    }


    @Override
    public EnquiryType handleEnquiry(String enquiry) {


        System.out.println("Inside SubscriptionEnquiryHandler");
        if (enquiry.contains("Upgrade") || enquiry.contains("payment")) {
            return EnquiryType.SUBSCRIPTIONS;

        }
        return this.nextHandler.handleEnquiry(enquiry);

    }
}
