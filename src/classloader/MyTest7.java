package classloader;

public class MyTest7 {
    public static void main(String[] args) {
        System.out.println(MyInterfaceChild.child);
    }
}

class ClassForTestInterface {
    public static int cnt = 0;

    public ClassForTestInterface() {
        System.out.println("new ClassForTestInterface()");
        cnt++;
        System.out.println("cnt = " + cnt);
        System.out.println("-------------");
    }
}

interface MyInterface {
    public static ClassForTestInterface father = new ClassForTestInterface();
}

class MyInterfaceChild implements MyInterface {
    public static ClassForTestInterface child = new ClassForTestInterface();
}