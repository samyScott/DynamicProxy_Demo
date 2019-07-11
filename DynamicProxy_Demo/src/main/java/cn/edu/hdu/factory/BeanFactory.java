package cn.edu.hdu.factory;

import cn.edu.hdu.service.IAccountService;
import cn.edu.hdu.utils.TransactionManger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BeanFactory {

    private IAccountService iAccountService;
    private TransactionManger tx;

    public final void setiAccountService(IAccountService iAccountService) {
        this.iAccountService = iAccountService;
    }

    public void setTx(TransactionManger tx) {
        this.tx = tx;
    }

    public IAccountService getProxyBean(){

        IAccountService accountService = (IAccountService) Proxy.newProxyInstance(iAccountService.getClass().getClassLoader(), iAccountService.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                try {
                    Object returnValue = null;
                    tx.beginTransaction();
                    returnValue = method.invoke(iAccountService, args);
                    tx.commit();
                    return returnValue;
                }catch (Exception e){
                    tx.rollback();
                    throw new RuntimeException();
                }finally {
                    tx.release();
                }
            }
        });

        return accountService;
    }
}
