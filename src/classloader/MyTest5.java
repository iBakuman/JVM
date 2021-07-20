package classloader;

import java.util.Random;

/*
    1.当一个接口在初始化时，并不要求其父接口先完成初始化（但是并不意味着父接口不会被加载）
    2.接口中的变量自动为public static final
    3.当使用子接口中编译期不能确定的常量时，父接口会优于子接口被加载（注意，并不会初始化）
 */
public interface MyTest5 {
    public static void main(String[] args) {
        // 当取1时，编译一次后删除MyParent5.class和MyChild5.class也能正常运行
        System.out.println(MyChild5.b);
        //MyParent5.a = 10;// error
    }
}

interface MyParent5{
    // 1
    //public static int a = 5;
    // 2
    //public static int a = new Random().nextInt();
    // 3
    //public static int a = new Random().nextInt();
    // 4
    public static int a = 5;
}

class MyChild5 implements MyParent5{
    // 1
    //public static int b = 6;
    // 2
    //public static int b = new Random().nextInt();
    // 3
    //public static int b = 6;
    // 4
    public static int b = new Random().nextInt();
}
