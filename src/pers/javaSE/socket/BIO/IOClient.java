package pers.javaSE.socket.BIO;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

public class IOClient {
    public static void main(String[] args){
        for(int i=0;i<100;i++){
            new Thread(()->{
                while (true){
                    try {
                        Socket socket = new Socket("127.0.0.1",8000);
                        try {
                            socket.getOutputStream().write((new Date()+
                                    "ThreadId ->:"+Thread.currentThread().getId() +" hello world!").getBytes());
                            socket.getOutputStream().flush();
                            Thread.sleep(2000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            ).start();
        }
    }
}
