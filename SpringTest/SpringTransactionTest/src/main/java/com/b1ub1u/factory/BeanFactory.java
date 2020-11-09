package com.b1ub1u.factory;


import com.b1ub1u.service.IAccountService;
import com.b1ub1u.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class BeanFactory {
    private IAccountService accountService;

    private TransactionManager tsManager;


    public void setTsManager(TransactionManager tsManager) {
        this.tsManager = tsManager;
    }

    public final void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    public  IAccountService getAccountService(){
         return (IAccountService)Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     *
                     * @param proxy
                     * @param method
                     * @param args
                     * @return
                     * @throws Throwable
                     */

                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object rtValue;
                        try{
                            tsManager.beginTransaction();

                            rtValue = method.invoke(accountService, args);

                            tsManager.commit();

                            return rtValue;
                        }catch(Exception e){
                            tsManager.rollback();
                            throw new RuntimeException(e);

                        }finally {
                            tsManager.release();

                        }
                    }
                });
    }

}
