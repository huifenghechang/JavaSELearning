package pers.javaSE.thread;


/*


* */
public class SynchronizedTest {
    public void method(){
        synchronized (this){
            System.out.println("synchronized code block");
        }
    }
}
