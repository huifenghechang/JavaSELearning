package pers.javaSE.pojo;

import java.io.Serializable;


// 类要序列化，必须要实现该接口
public class User implements Serializable {
    String name;
    String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
