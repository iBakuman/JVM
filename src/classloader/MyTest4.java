package classloader;

/*
    1.对于数组实例来说，其类型时由JVM在运行期动态生成的，表示为[....className
      这种形式
    2.对于数组来说，JavaDoc经常将构成数组的元素为Component,实际上就是将数组降低一个维度后的类型
    3.助记符
      1.anewarray：创建一个引用类型的（如类、接口、数组）的数组，并将其引用压入栈顶
      2.newarray：创建一个指定的原始类型（如int、float、char等）的数组，并将其引用压入栈顶
 */

public class MyTest4 {
    public static void main(String[] args) {
        // Test1
        //MyParent4 myParent4 = new MyParent4();
        //System.out.println("=======");
        //MyParent4 myParent41 = new MyParent4();

        // Test2
        MyParent4[] myParent4s = new MyParent4[1];// 并不是对类的主动使用
        System.out.println(myParent4s.getClass());// class [Lclassloader.MyParent4;一个'['表明是一维数组
        System.out.println(myParent4s.getClass().getSuperclass());
        MyParent4[][] myParent4s1 = new MyParent4[1][1];
        System.out.println(myParent4s1.getClass());// class [[Lclassloader.MyParent4;
        System.out.println(myParent4s1.getClass().getSuperclass());

        // Test3

    }
}

class MyParent4 {
    static {
        System.out.println("MyParent4 static block");
    }
}
