package SingleTonPattern;

import java.util.HashMap;
import java.util.Map;

public class EmployeeIdStore {

    private Map<String,String> employeeMap;


    //EAGER INITALSIATION
 //   private static EmployeeIdStore instance = new EmployeeIdStore();

   private  static EmployeeIdStore instace = null; //lazy insitalsation

    private EmployeeIdStore(){
        employeeMap = new HashMap<>();
        //read DB
        this.employeeMap.put("101", "Bharat");
        this.employeeMap.put("102", "Vivek");
        this.employeeMap.put("112", "Anoop");

    }

    public static EmployeeIdStore getInstance(){
        if(instace == null){
            return instace =  new EmployeeIdStore();
        }
        return instace;
    }

    public String getName(String id) {
        if (!this.employeeMap.containsKey(id))
            throw new IllegalArgumentException("Invalid Id");
        return this.employeeMap.get(id);
    }
}
