package lld2.singleton.connectionpool.solved;

public class ConnectionPoolImpl implements ConnectionPool {

    private static ConnectionPoolImpl instance = null;
    private static int maxConnection = 0;
    int poolSize = 0;
    private ConnectionPoolImpl(){}

    @Override
    public void initializePool() {

    }

    @Override
    public DatabaseConnection getConnection() {
        return null;
    }

    @Override
    public void releaseConnection(DatabaseConnection connection) {

    }

    @Override
    public int getAvailableConnectionsCount() {
        return 0;
    }

    @Override
    public int getTotalConnectionsCount() {
        return 0;
    }

    public static ConnectionPoolImpl getInstance(int maxConnections) {
        if(instance == null)
            instance = new ConnectionPoolImpl();
        maxConnection = maxConnections;
        return instance;
    }

    public void resetInstance() {
        instance = null;
        maxConnection = 0;
    }
}
