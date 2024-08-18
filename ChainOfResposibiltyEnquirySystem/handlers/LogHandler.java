package ChainOfResposibiltyEnquirySystem.handlers;

import ChainOfResposibiltyEnquirySystem.data.EnquiryType;


public class LogHandler implements EnquiryHandler {

    EnquiryHandler nextHandler;

    public LogHandler(EnquiryHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
    @Override
    public EnquiryType handleEnquiry(String text) {
        System.out.println(text);
        EnquiryType enquiryType = this.nextHandler.handleEnquiry(text);
        System.out.println("Inside logging handler");
        System.out.println(enquiryType);
        return enquiryType;
    }
}
