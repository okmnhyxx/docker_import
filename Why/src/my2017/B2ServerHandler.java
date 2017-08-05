package my2017;

import java.io.*;
import java.net.Socket;

/**
 * Created by emi on 2017/7/29.
 * http://blog.csdn.net/anxpp/article/details/51512200
 * 传统的BIO编程
 * 客户端消息处理线程ServerHandler源码  用于处理一个客户端的Socket链路
 */
public class B2ServerHandler implements Runnable{

    private Socket socket;
    public B2ServerHandler(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        BufferedReader in = null;
        PrintWriter out = null;
        try{
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(),true);
            String expression;
            String result;
            while(true){
                //通过BufferedReader读取一行
                //如果已经读到输入流尾部，返回null,退出循环
                //如果得到非空值，就尝试计算结果并返回
                if((expression = in.readLine())==null) break;
                System.out.println("服务器收到消息：" + expression);
                try{
                    result = B2Calculator.cal(expression).toString();
                }catch(Exception e){
                    result = "计算错误：" + e.getMessage();
                }
                out.println(result);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            streamSocketClear(in, out, socket);
        }
    }


    /**
     * 一些必要的清理工作
     */
    public static void streamSocketClear(Reader in, Writer out, Socket socket) {
        if(in != null){
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("input流关闭失败");
            }
            in = null;
        }
        if(out != null){
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("out流关闭失败");
            }
            out = null;
        }
        if(socket != null){
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("socket关闭失败");
            }
            socket = null;
        }
    }
}
