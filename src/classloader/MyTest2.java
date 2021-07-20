package classloader;

/*
    1.常量在编译阶段会存入到调用到这个常量的方法所在的类的常量池中
    2.本质上，调用类并没有直接引用定义常量的类，因此并不会触发定义
       常量的类的初始化
    3.注意：这里常量存放到了MyTest2的常量池中，之后MyTest2与55MyParent2就没有任何关系了
      我们甚至可以将MyParent2.class删除
    4.助记符：
      1.ldc表示将int，float，或者是String类型的常量值从常量池中推送至栈顶
      2.bipush表示将单字节（-128 ~ 127）的常量值推送至栈顶
      3.sipush表示将一个短整型（-32768 ~ 32767）的常量值推送至栈顶
      4.iconst_1表示将int类型1推送至栈顶（iconst_1 ~ iconst_5），当为6时为bipush
 */
public class MyTest2 {
    public static void main(String[] args) {
        System.out.println(MyParent2.str);
        //System.out.println(MyParent2.a); 注释这句及时删除MyParent.class文件，main函数也能正常执行
        System.out.println(MyParent2.b);
        System.out.println(MyParent2.c);
        System.out.println(MyParent2.d);
    }
}

class MyParent2 {
    //public static String str = "Hello world";
    public static final String str = "Hello world";
    public static int a = 10;
    public static final int b = 20;
    public static final int c = 2000;
    public static final int d = 1;

    static {
        System.out.println("MyParent2 static block");
    }
}
