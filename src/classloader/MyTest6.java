package classloader;

/*
    1.对静态成员变量的使用不能使用实例对象.静态变量名的方式，只能使用类名.静态变量名的方式
    2.静态变量的加载顺序为从上至下
 */
public class MyTest6 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println("counter1: " + Singleton.counter1);
        System.out.println("counter2: " + Singleton.counter2);
    }
}

/*
class Singleton {
    public static int counter1;
    public static int counter2 = 0;

    private static Singleton singleton = new Singleton();

    private Singleton() {
        counter1++;
        counter2++;
    }

    public static Singleton getInstance() {
        return singleton;
    }
}
 */

class Singleton {
    public static int counter1;
    private static Singleton singleton = new Singleton();

    private Singleton() {
        counter1++;
        counter2++;// 准备阶段的重要意义***important
        System.out.println(counter1);
        System.out.println(counter2);
    }
    public static int counter2 = 0;// 将代码移动到这个位置

    public static Singleton getInstance() {
        return singleton;
    }
}
