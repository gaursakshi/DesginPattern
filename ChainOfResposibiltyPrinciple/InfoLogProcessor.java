package ChainOfResposibiltyPrinciple;


public class InfoLogProcessor implements LogProcessor {


    private LogProcessor nextProcessor;


    @Override
    public void handleRequest(Log log) {
        if("INFO".equals(log.getLevel())){
            System.out.println("Info " + log.getMessage());
        }
        else{
            if(nextProcessor!=null){
                nextProcessor.handleRequest(log);
            }
        }

    }

    @Override
    public void setNextHandler(LogProcessor nextHandler) {
        this.nextProcessor = nextHandler;
    }
}
