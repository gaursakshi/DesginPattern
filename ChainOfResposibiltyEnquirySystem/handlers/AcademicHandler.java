package ChainOfResposibiltyEnquirySystem.handlers;

import ChainOfResposibiltyEnquirySystem.data.EnquiryType;

public class AcademicHandler implements EnquiryHandler {

    private EnquiryHandler nextHandler;

    public AcademicHandler(EnquiryHandler nextHandler) {
        this.nextHandler = nextHandler;
    }


    @Override
    public EnquiryType handleEnquiry(String enquiry) {
        System.out.println("inside the academic handler");
        if (enquiry.contains("DS Algo") ||
                enquiry.contains("Design")) {
            return EnquiryType.ACADEMIC;
        }

        return this.nextHandler.handleEnquiry(enquiry);

    }
}
