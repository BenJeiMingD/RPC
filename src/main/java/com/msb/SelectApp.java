package com.msb;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.List;

public class SelectApp {
    public static void main(String[] args) {
        try {
            ZooKeeper zookeeper = new ZooKeeper("192.168.226.128:2181", 10000, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    System.out.println("获取连接");
                }
            });
            //获取列表
            List<String> list = zookeeper.getChildren("/demo", false);
            for (String child : list) {
                byte[] result = zookeeper.getData("/demo/" + child, false, null);
                System.out.println(new String(result));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
