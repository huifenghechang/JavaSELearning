package pers.javaSE.designPattern;

/*
* 双重检验锁模式，来实现单例。
*   有两点需要注意：
*      1.使用volatile来修饰引用变量，是为了防止指令重排
*      2.使用第二次判空，是为了在多线程模式下，防止建立多个实例！
* */
public class Singleton {
    public static volatile Singleton uniqueInstance;

    private Singleton(){}

    public static Singleton getInstance(){
        if (uniqueInstance==null){
            synchronized (Singleton.class){
                if (uniqueInstance==null)
                    uniqueInstance = new Singleton();
            }
        }
        return uniqueInstance;
    }
}
