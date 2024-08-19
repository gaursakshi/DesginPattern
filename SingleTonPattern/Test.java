package SingleTonPattern;

public class Test {
    public static void main(String[] args) {
        EmployeeIdStore employeeIdStore = EmployeeIdStore.getInstance();
        System.out.println(employeeIdStore.getName("101"));
        EmployeeIdStore employeeIdStore2 ,employeeIdStore3;
        employeeIdStore2 = EmployeeIdStore.getInstance();
        employeeIdStore3 = EmployeeIdStore.getInstance();

        //check both the instance should return the same addrtess
        System.out.println(employeeIdStore2 == employeeIdStore3);



    }
}
