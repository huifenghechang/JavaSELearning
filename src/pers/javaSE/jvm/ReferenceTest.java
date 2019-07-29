package pers.javaSE.jvm;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class ReferenceTest {
    public static void main(String[] args){
        weakReferenceTest();
    }

    public static void softReferenceTest(){
        //        如果内存空间不足了，就会回收这些对象的内存。
//        只要垃圾回收器没有回收它，该对象就可以被程序使用。
//        软引用可用来实现内存敏感的高速缓存。
        ReferenceQueue<String> referenceQueue = new
                ReferenceQueue<>();

        String strongRef = new String("abc");

        SoftReference<String> softRef1 = new SoftReference<>(strongRef
                ,referenceQueue);

        System.out.println(softRef1.get());

        strongRef = null;
        System.gc();

        Reference<? extends String> reference = referenceQueue.poll();
        System.out.println(reference);
        System.out.println(softRef1);
        System.out.println(softRef1.get());
    }

    public static void weakReferenceTest(){
        //强引用
        String str = "abcdefg";
        // 设置弱引用及其相关队列
        ReferenceQueue<String> referenceQueue = new ReferenceQueue<>();
        WeakReference<String> weakReference =
                new WeakReference<>(str);
        System.out.println("before gc weekReference  ;-->"+weakReference.get());
        // 将弱引用的对象置为null
        str = null;
        System.gc();
        System.out.println("after gc weekReference  ;-->"+weakReference.get());
//        System.out.println("after gc weekReference  Queue;-->"+referenceQueue.poll());

    }
}
