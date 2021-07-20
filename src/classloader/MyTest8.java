package classloader;

public class MyTest8 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> classType = Class.forName("java.lang.String");
        System.out.println(classType.getClassLoader());
        Class<?> cLoader = Class.forName("classloader.C");
        System.out.println(classType.getClassLoader());
    }
}

class C{

}
