package ChainOfResposibiltyEnquirySystem.handlers;

import ChainOfResposibiltyEnquirySystem.data.EnquiryType;

public class IdleHandler  implements EnquiryHandler{
    @Override
    public EnquiryType handleEnquiry(String text) {
        System.out.println("Inside IdleHandler");
        System.out.println("all done");
        return EnquiryType.UNKNOWN;
    }
}
