package ChainOfResposibiltyEnquirySystem.handlers;

import ChainOfResposibiltyEnquirySystem.data.EnquiryType;

public interface EnquiryHandler {

    public EnquiryType handleEnquiry(String text);
}
