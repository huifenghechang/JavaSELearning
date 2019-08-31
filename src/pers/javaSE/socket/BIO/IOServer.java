package pers.javaSE.socket.BIO;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class IOServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8000);
        // 1.接收新连接的线程
        new Thread(() -> {
            while (true) {
                try {
                    // （1）阻塞方法获取新的连接
                    Socket socket = serverSocket.accept();
                    // (2)每一个新的连接，都创造一个线程。负责读取数据
                    new Thread(() -> {
                        try {
                            byte[] data = new byte[1024];
                            InputStream inputStream = socket.getInputStream();
                            while (true) {
                                int len;
                                while ((len = inputStream.read(data)) != -1) {
                                    System.out.println(new String(data, 0, len));
                                    System.out.println("The ThreadId is :"+Thread.currentThread().getId());
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }).start();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
}
