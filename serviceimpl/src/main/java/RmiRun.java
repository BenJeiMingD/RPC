import com.msb.service.impl.MyPersionImpl;
import org.apache.zookeeper.*;

import javax.naming.spi.NamingManager;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RmiRun {
    public static void main(String[] args) {
        try {
            MyPersionImpl myPersion = new MyPersionImpl();
            LocateRegistry.createRegistry(8888);
            String url = "rmi://localhost:8888/myPersion";
            Naming.bind(url,myPersion);
            ZooKeeper zooKeeper = new ZooKeeper("192.168.226.128:2181", 100000, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    System.out.println("注册成功");
                }
            });
            String context = zooKeeper.create("/test/myPersion",url.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println("发布成功");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
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
    }
}
