package ObjectPoolDesignPattern;

public class Client {
    public static void main(String[] args) {
       DBConnectionPoolManager connectionPoolManager = DBConnectionPoolManager.getInstance();
        try {
            DBConnection dbConnection = connectionPoolManager.getDBConnection();
            DBConnection dbConnection1 = connectionPoolManager.getDBConnection();
            connectionPoolManager.releaseDBConnection(dbConnection);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
