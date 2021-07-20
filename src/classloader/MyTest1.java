package classloader;

/*
    1.类加载的三个阶段：
        1.加载
        2.连接
        3.初始化
    2.对于静态字段来说，只有直接定义了该字段的类才会被初始化
    3.当一个类在初始化时，要求其父类全部都已经初始化完毕了
    4。-XX:TraceClassLoading，用于追踪类的加载信息并打印出来
 */

public class MyTest1 {
    public static void main(String[] args) {
        //System.out.println(MyChild1.str);
        System.out.println(MyChild1.str2);
    }
}

class MyParent1 {
    public static String str = "hello world";

    static {
        System.out.println("MyParent1 static block");
    }
}

class MyChild1 extends MyParent1 {
    public static String str2 = "HELLO WORLD";
    static {
        System.out.println("MyChild1 static block");
    }
}
