package pers.javaSE.io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class NIOTest {
    public static void main(String[] args){
//        readNIO();
        writeNIO();

    }

    public static void readNIO(){
        String pathName = "C:\\Users\\苏小乐\\Desktop\\autumn\\JavaSELearning\\res\\small.PNG";
        FileInputStream fin = null;
        try {
            fin = new FileInputStream(new File(pathName));
            FileChannel channel = fin.getChannel();

            int capacity = 100;
            ByteBuffer bf = ByteBuffer.allocate(capacity);
            int length = -1;

            while ((length = channel.read(bf)) != -1){
                bf.clear();
                byte[] bytes = bf.array();
                System.out.write(bytes,0,length);
                System.out.println();
            }
            channel.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void writeNIO(){
        String fileName = "out.txt";
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(new File(fileName));
            FileChannel channel = fos.getChannel();
            ByteBuffer src = Charset.forName("utf8").encode("阿里巴巴我来啦45679797946d46g" +
                    "d4679g797r97re9ga79g7re7tge979eg79gbgvcvbc467d97g9eg4b6adfg79er7bh94a6gb46");
            int length = 0;

            while ((length = channel.write(src)) != 0){
                System.out.println("写入长度"+ length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
