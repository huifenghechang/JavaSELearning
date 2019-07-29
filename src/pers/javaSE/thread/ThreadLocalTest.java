package pers.javaSE.thread;

import java.text.SimpleDateFormat;
import java.util.Random;

public class ThreadLocalTest {
    private static final ThreadLocal<SimpleDateFormat> formatter =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd HHmm"));

    public static void main(String[] args){
        ThdLocalThread localThread = new ThdLocalThread();
        for(int i=1;i < 10;i++){
            Thread t = new Thread(localThread," "+i);
            try {
                Thread.sleep(new Random().nextInt(1000));
                t.start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    static class ThdLocalThread implements Runnable{

        @Override
        public void run() {
            System.out.println("thread id"+Thread.currentThread().getName()
                    +  "default Formatter = "+formatter.get().toPattern());

            try {
                Thread.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            formatter.set(new SimpleDateFormat());
            System.out.println("Thread Name= "+Thread.currentThread().getName()+
                    " formatter = "+formatter.get().toPattern());
        }


    }
}
