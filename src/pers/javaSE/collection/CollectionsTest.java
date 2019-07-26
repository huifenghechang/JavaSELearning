package pers.javaSE.collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class CollectionsTest {
    public static void main(String[] args){
        ArrayListOrVector();
    }

    public static void ConcurrentHashMapOrHashMapOrHashStable(){
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        TreeMap<String,Integer> reaBlackTree = new TreeMap<>(); // 红黑树
    }


    public static void ArrayListOrVector(){
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        System.out.println(vector);
    }

    public static void CollectionsUsed(){
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(-1);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(-5);
        arrayList.add(7);
        arrayList.add(4);
        arrayList.add(-9);
        arrayList.add(-7);
        System.out.println("原始数组:");
        System.out.println(arrayList);

        Collections.reverse(arrayList);
        System.out.println("Collections.reverse(arrayList):");
        System.out.println(arrayList);


        // void sort(List list),按自然排序的升序排序
        Collections.sort(arrayList);
        System.out.println("Collections.sort(arrayList):");
        System.out.println(arrayList);

        Collections.sort(arrayList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println("Collections.sort(arrayList): return o2.compareTo(o1);");
        System.out.println(arrayList);
    }
}
