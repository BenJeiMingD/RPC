package com.msb;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * 继承Remote抛出RemoteException
 */
public interface MyPersion extends Remote {

    public List<persion> findAll() throws RemoteException;
}
