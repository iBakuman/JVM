package classloader;

import javafx.scene.Parent;

class Parent2 {
    static int a = 3;

    static {
        System.out.println("Parent2 static block");
    }
}

class Child2 extends Parent2 {
    static int b = 4;

    static {
        System.out.println("Child2 static block");
    }
}

public class MyTest9 {
    static {
        System.out.println("MyTest9 test block");
    }

    public static void main(String[] args) {
        Parent2 parent2;
        System.out.println("--------(1)--------");
        parent2 = new Parent2();
        System.out.println("--------(2)--------");
        System.out.println(parent2.a);
        System.out.println("--------(3)--------");
        System.out.println(Child2.b);
    }
}
