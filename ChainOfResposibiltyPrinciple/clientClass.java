package ChainOfResposibiltyPrinciple;


public class clientClass {
    public static void main(String[] args) {

        LogProcessor logProcessor = new InfoLogProcessor();
        LogProcessor debugLogProcessor = new DebugLogProcessor();
        LogProcessor errorLogProcessor = new ErrorLogProcessor();


        logProcessor.setNextHandler(debugLogProcessor);
        debugLogProcessor.setNextHandler(errorLogProcessor);


        //Log class
        Log infoLog = new Log("INFO", "Information log");
        Log debugLog = new Log("ERROR", "Error log");
        Log errorLog = new Log("DEBUG", "Debiug log");


        logProcessor.handleRequest(infoLog);
        logProcessor.handleRequest(debugLog);
        logProcessor.handleRequest(errorLog);


    }
}
