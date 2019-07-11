package cn.edu.hdu.utils;


public class TransactionManger {

    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    //开启事务
    public void beginTransaction(){
        try {
            connectionUtils.getConnection().setAutoCommit(false);
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
    //事务提交
    public void commit(){
        try {
            connectionUtils.getConnection().commit();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    //事务回滚
    public void rollback(){
        try {
            connectionUtils.getConnection().rollback();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    //释放连接
    public void release(){
        try {
            connectionUtils.getConnection().close();
            connectionUtils.relase();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
