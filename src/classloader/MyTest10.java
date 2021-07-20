package classloader;

/*
    1.使用(子类.父类静态变量变量名)去使用父类的静态变量并不会导致子类被初始化
    2.使用(子类.父类静态方法名)并不会导致子类被初始化
    3.以上两种情况虽然不会导致子类被初始化，但是子类会被加载
 */
class Parent3 {
    static int a = 3;

    static {
        System.out.println("Parent3 static block");
    }

    static void doSomething() {
        System.out.println("do something");
    }
}

class Child3 extends Parent3 {
    static {
        System.out.println("Child3 static block");
    }
}

public class MyTest10 {
    public static void main(String[] args) {
        System.out.println(Child3.a);
        System.out.println("---------(1)---------");
        Child3.doSomething();
    }
}
