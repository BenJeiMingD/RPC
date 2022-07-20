package com.msb.service;

import com.msb.MyPersion;
import com.msb.persion;
import com.msb.service.impl.PersionService;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

@Service
public class PersionServiceImpl implements PersionService {
    public List<persion> show(){
        try {
            ZooKeeper zooKeeper = new ZooKeeper("192.168.226.128:2181", 100000, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    System.out.println("获取连接");
                }
            });
            byte[] result = zooKeeper.getData("/rpc/provider",false,null);
            MyPersion myPersion =(MyPersion) Naming.lookup(new String(result));
            return myPersion.findAll();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }

        return null;
    }
}
