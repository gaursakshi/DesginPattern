package ChainOfResposibiltyPrinciple;


public  interface LogProcessor {

   //two method
    //one for setting the handling the request
    void handleRequest(Log log);


    // one for setting the next handler
    void setNextHandler(LogProcessor nextHandler);

}
