package cn.edu.hdu.utils;

import javax.sql.DataSource;
import java.sql.Connection;

public class ConnectionUtils {


    private ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getConnection(){
        try {
            Connection conn = threadLocal.get();
            if(conn == null){
                conn = dataSource.getConnection();
                threadLocal.set(conn);
            }

            return conn;
        }catch (Exception e){
            throw new RuntimeException(e);
        }


    }

    public void relase(){
        threadLocal.remove();
    }

}
