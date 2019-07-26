package pers.javaSE.io;

import pers.javaSE.pojo.User;
import sun.nio.ch.IOUtil;

import java.io.*;

public class BIOTest {

    public static void main(String[] args){


    }

    public  static void writeBIO(){
        User user = new User();
        user.setName("XiaoMing");
        user.setPassword("23333666");

        // 将对象写入文件中
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("userFile"));
            oos.writeObject(user);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            // nothing
        }

    }

    public static void readBIO(){
        // 从文件中读取数据
        File file = new File("userFile");
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            User newUser = null;
            try {
                newUser = (User) ois.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println(newUser + newUser.getName() + newUser.getPassword());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            // nothing
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
