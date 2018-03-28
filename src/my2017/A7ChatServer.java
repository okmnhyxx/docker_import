package my2017;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by emi on 2017/7/21.
 * http://www.jiaxuanshipin.com/58484.html
 * Java socket长连接代码实现
 */
public class A7ChatServer {

    boolean started = false;
    ServerSocket ss = null;
    List<Client> clients = new ArrayList<Client>();

    public static void main(String[] args) {
        new A7ChatServer().start();
    }

    public void start() {
        try {
            ss = new ServerSocket(8888);
            started = true;
            System.out.println("端口已开启,占用8888端口号....");
        } catch (BindException e) {
            System.out.println("端口使用中....");
            System.out.println("请关掉相关程序并重新运行服务器！");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            while (started) {
                //当客户端（ip:192.168.0.70）执行new Socket("192.168.0.117", port)时，
                // 服务端（ip:192.168.0.117）接收到一个socket长连接,该socket为： Socket[addr=/192.168.0.70,port=48377,localport=8888]，server端socket的LocalAddress()为本机Ip117，InetAddress为70
                Socket s = ss.accept();
                System.out.println("localAddress: " + s.getLocalAddress() + "\tiNetAddress: " + s.getInetAddress());
                Client c = new Client(s);
                System.out.println("a client connected!");
                new Thread(c).start();
                clients.add(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    class Client implements Runnable {
        private Socket s;
        private DataInputStream dis = null;
        private DataOutputStream dos = null;
        private boolean bConnected = false;

        public Client(Socket s) {
            this.s = s;
            try {
                dis = new DataInputStream(s.getInputStream());
                dos = new DataOutputStream(s.getOutputStream());
                bConnected = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void send(String str) {
            try {
                dos.writeUTF("来自server端的内容：" + str);
                dos.flush();
            } catch (IOException e) {
                clients.remove(this);
                System.out.println("对方退出了！我从List里面去掉了！");
            }
        }

        public void run() {
            System.out.println("client开始run了");
            try {
                while (bConnected) {
                    System.out.println("while running ......");
                    String str = dis.readUTF();
                    System.out.println("------------来自本地服务器:" + str);
                    for (int i = 0; i < clients.size(); i++) {
                        Client c = clients.get(i);
//                        if (this == c) {
                            c.send(str);
//                        }
                    }
                }
            } catch (EOFException e) {
                e.printStackTrace();
                System.out.println("Client closed!");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (dis != null)
                        dis.close();
                    if (dos != null)
                        dos.close();
                    if (s != null) {
                        s.close();
                    }
                    clients.remove(this);
                    System.out.println(Thread.getAllStackTraces());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }
        }
    }
}
    /**
     * client 和 server 大体流程：
     * server先启动起来
     */
