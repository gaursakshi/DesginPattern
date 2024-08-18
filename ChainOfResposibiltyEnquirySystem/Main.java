package ChainOfResposibiltyEnquirySystem;

import ChainOfResposibiltyEnquirySystem.apis.HandleEnquiryAPI;

public class Main {
    public static void main(String[] args) {
        HandleEnquiryAPI handleEnquiryAPI = new HandleEnquiryAPI();
        handleEnquiryAPI.handleEnquiry("I want to take  1 month Upgrade");
    }
}
