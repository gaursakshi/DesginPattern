package ChainOfResposibiltyEnquirySystem.handlers;


import ChainOfResposibiltyEnquirySystem.data.EnquiryType;

public class ProjectEnquiryHandler implements EnquiryHandler {

    private final EnquiryHandler nextHandler;

    public ProjectEnquiryHandler(EnquiryHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public EnquiryType handleEnquiry(String enquiry) {
        System.out.println("Inside ProjectEnquiryHandler");
        if (enquiry.contains("Project")) {
            return EnquiryType.PROJECTS;
        }
        return this.nextHandler.handleEnquiry(enquiry);

    }
}
