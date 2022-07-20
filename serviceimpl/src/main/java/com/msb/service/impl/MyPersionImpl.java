package com.msb.service.impl;

import com.msb.MyPersion;
import com.msb.persion;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * 这里的实现类必须继承UnicastRemoteObject方法，并且改成public
 */
public class MyPersionImpl extends UnicastRemoteObject implements MyPersion {
    public MyPersionImpl() throws RemoteException {
    }

    public MyPersionImpl(int port) throws RemoteException {
        super(port);
    }

    public MyPersionImpl(int port, RMIClientSocketFactory csf, RMIServerSocketFactory ssf) throws RemoteException {
        super(port, csf, ssf);
    }

    @Override
    public List<persion> findAll() throws RemoteException {
        List<persion> list = new ArrayList<>();
        list.add(new persion(1,"张三"));
        list.add(new persion(2,"李四"));
        return list;
    }
}
