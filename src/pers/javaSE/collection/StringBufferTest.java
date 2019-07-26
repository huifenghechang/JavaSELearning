package pers.javaSE.collection;

public class StringBufferTest {
    public static void main(String[] args){
        StringBuffer sb = new StringBuffer();
        sb.append('a');
        sb.append("HelloWorld");
        System.out.println(sb.toString());

        //
        System.out.println("test some function");
        sb.setLength(50);
        System.out.println(sb.capacity());
        sb.append("fff",2,4);

    }

    public String replaceSpace(StringBuffer str) {
        //基本思路：从后向前移动。
        //第一次遍历，统计字符串中空格的个数。第二遍遍历，将空格转化为%20
        // StringBuffer是线程安全的。其内部，是用数组来实现
        int spaceCount = 0;

        for(int i=0;i<str.length();i++){
            if (str.charAt(i)==' ')
                spaceCount++;
        }

        //设置两个指针，开始遍历，一旦遇到空格，则将%20填充之
        int p1 = str.length()-1;//因为StringBuffer本质上是字符数组实现，所以最后一个下标为长度减去1
        // 设置str的长度。并且从后往前遍历
        str.setLength(str.length()+2*spaceCount);
        int p2 = str.length()-1;

        while (p1>0){
            if (str.charAt(p1)==' '){
                str.setCharAt(p2++,'0');
                str.setCharAt(p2++,'2');
                str.setCharAt(p2++,'%');
                p1++;
            }else {
                str.setCharAt(p2++,str.charAt(p1++));
            }
        }
        return str.toString();
    }
}
