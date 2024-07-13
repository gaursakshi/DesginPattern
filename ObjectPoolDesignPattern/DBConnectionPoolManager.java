package ObjectPoolDesignPattern;

import java.util.List;
import java.util.Objects;

class DBConnectionPoolManager {

    private List<DBConnection> freeResourceList;

    private List<DBConnection> usedResourceList;

    private final int initialPoolSize = 3;

    private final int maxPoolSize = 5;


    //singleton class
    private static DBConnectionPoolManager instance;

    public static DBConnectionPoolManager getInstance() {
        if (instance == null) {
            // To make thread safe
            synchronized (DBConnectionPoolManager.class) {
                // check again as multiple threads
                // can reach above step
                if (instance == null) {
                    ///create a new object
                    instance = new DBConnectionPoolManager();
                }
            }
        }
        return instance;
    }


    private DBConnectionPoolManager() {
        for (int i = 0; i < initialPoolSize; i++) {
            freeResourceList.add(new DBConnection());
        }
    }

   public synchronized DBConnection getDBConnection() throws Exception {

        if (freeResourceList.isEmpty() && usedResourceList.size() < maxPoolSize) {
            System.out.println("Creating a new database connection");
            freeResourceList.add(new DBConnection());
        } else if (freeResourceList.isEmpty()) {
            System.out.println("Database connection cannot be created ");
            throw new Exception("Cannot create a new connection ,as the limit is reached");
        }
        DBConnection dbConnection = freeResourceList.get(freeResourceList.size() - 1);
        usedResourceList.add(dbConnection);
        return dbConnection;
    }

    public synchronized void releaseDBConnection(DBConnection dbConnection) {
        if (Objects.nonNull(dbConnection)) {
            usedResourceList.remove(dbConnection);
            System.out.println("Removing connection from the usedpoolsize " + usedResourceList.size());
            freeResourceList.add(dbConnection);
            System.out.println("Adding connection to the freepools " + freeResourceList.size());
        }

    }

}
