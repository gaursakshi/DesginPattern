package ChainOfResposibiltyPrinciple;



public class ErrorLogProcessor  implements  LogProcessor{

    private LogProcessor nextlogProcessor;


    @Override
    public void handleRequest(ChainOfResposibiltyPrinciple.Log log) {
        if("ERROR".equals(log.getLevel())){
            System.out.println("Error  is" + log.getMessage());
        }
        else if(nextlogProcessor!=null){
            nextlogProcessor.handleRequest(log);
        }
    }

    @Override
    public void setNextHandler(LogProcessor nextHandler) {
        this.nextlogProcessor = nextHandler;

    }
}
