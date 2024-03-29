package classloader;

import java.util.UUID;

/*
    当一个常量的值并非编译期间可以确定，则其值就不会放到调用类的常量池中，
    这是程序在运行时，会导致主动使用这个常量所在的类，显然辉导致这个类被初始化
 */
public class MyTest3 {
    public static void main(String[] args) {
        System.out.println(MyParent3.str);
    }
}

class MyParent3 {
    public static final String str = UUID.randomUUID().toString();

    static {
        System.out.println("MyParent3 static code");
    }
}
