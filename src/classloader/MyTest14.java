package classloader;

/*
    1.数组对象的Class对象，不是由类加载器创建的，而是由Java虚拟机
    根据需要创建的
    Class objects for array classes are not created by class
    loaders, but are created automatically as required by the Java runtime.

    2.The class loader for an array class, as returned by {@link
    Class#getClassLoader()} is the same as the class loader for its element
    type; if the element type is a primitive type, then the array class has no
    class loader.

    3.Applications implement subclasses of <tt>ClassLoader</tt> in order to
    extend(扩展) the manner(方式，方法） in which the Java virtual machine dynamically loads
    classes.

    4.The method defineClass converts an array of bytes into an instance of class Class.
    Instances of this newly defined class can be created using Class.newInstance.
 */
public class MyTest14 {
    public static void main(String[] args) {
        System.out.println("---------(1)--------");
        String[] strings = new String[2];
        System.out.println(strings.getClass().getClassLoader());
        System.out.println("---------(2)--------");
        int[] arr = new int[20];
        System.out.println(arr.getClass().getClassLoader());
        System.out.println("---------(3)--------");
        MyTest14[] arr2 = new MyTest14[20];
        System.out.println(arr2.getClass().getClassLoader());
    }
}

/*
        System.out.println("---------(1)--------");
        System.out.println("---------(2)--------");
        System.out.println("---------(3)--------");
        System.out.println("---------(4)--------");
        System.out.println("---------(5)--------");
        System.out.println("---------(6)--------");
 */
