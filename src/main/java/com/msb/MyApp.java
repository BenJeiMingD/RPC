package com.msb;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.List;

public class MyApp {
   public static void main(String[] args){
      /**
       * 创建zookeeper对象
       * 参数1：zookeeper ip+端口号  向zookeeper发送的文件
       * 参数2：访问超时设置  发生的内容
       * 参数3：连接成功后的编写信息  权限
       * 参数4：内容的
       */
         try {
            ZooKeeper zooKeeper = new ZooKeeper("192.168.226.128:2181", 100000, new Watcher() {
               @Override
               public void process(WatchedEvent watchedEvent) {
                  System.out.println("已连接zookeeper");
               }
            });
            /**
             * 参数1：向zookeeper发送的文件
             * 参数2：访问超时设置  发生的内容
             * 参数3：连接成功后的编写信息  权限
             * 参数4：内容的模式
             */
            String content =  zooKeeper.create("/demo/rim-address","rmi:localhost:8080/demoService".getBytes(),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
            System.out.println(content);
         } catch (IOException e) {
            e.printStackTrace();
         } catch (InterruptedException e) {
            e.printStackTrace();
         } catch (KeeperException e) {
            e.printStackTrace();
         }

   }

}
