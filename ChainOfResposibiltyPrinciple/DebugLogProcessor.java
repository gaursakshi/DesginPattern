package ChainOfResposibiltyPrinciple;

import sun.rmi.runtime.Log;

 class DebugLogProcessor implements LogProcessor{

    private LogProcessor nextProcessor;


     @Override
     public void handleRequest(ChainOfResposibiltyPrinciple.Log log) {
      if("DEBUG".equals(log.getLevel())){
       System.out.println("debug  is" + log.getMessage());
      }
      else if(nextProcessor!=null){
       nextProcessor.handleRequest(log);
      }

     }

     @Override
     public void setNextHandler(LogProcessor nextHandler) {
      this.nextProcessor = nextHandler;
     }


 }
