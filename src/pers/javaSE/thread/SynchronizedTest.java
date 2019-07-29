package pers.javaSE.thread;


/*


* */
public class SynchronizedTest {
    public void method(){
        synchronized (this){
            System.out.println("synchronized code block");
        }
    }

    public static void main(String[] args){

        VolatileThread thread = new VolatileThread();
        Thread thread1 = new Thread(thread,"thread1");
        Thread thread2 = new Thread(thread,"thread2");
        thread1.start();
        thread2.start();
        try {
            Thread.sleep(1000);
            System.out.println(thread.num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class VolatileThread implements Runnable{
        volatile int num = 1;
        @Override
        public void run() {
            synchronized (SynchronizedTest.class) {
                try {
                    for (int i = 1; i <= 5; i++) {
                        System.out.println(Thread.currentThread().getName() + "num's value is" + num);
                        Thread.sleep(100);
                        num++;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
