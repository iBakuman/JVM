package classloader;

import java.lang.reflect.Method;

/*
    1.loader1和loader2都继承系统类加载器
    2.先使用loader1加载MyPerson时由于当前类路径中存在
      MyPerson.class，故系统类加载器加载MyPerson
    3.再使用loader2去加载MyPerson时，由于MyPerson已经
      由系统类加载器加载，故系统类加载器直接将结果给loader2
      故clazz1 = clazz2，因为它们引用内存中的同一个Class对象
    4.系统类加载器时MyPerson类的定义类加载器，loader1则是
      MyPerson的初始类加载器
 */
public class MyTest19 {
    public static void main(String[] args) throws Exception {
        MyTest15 loader1 = new MyTest15("loader1");
        MyTest15 loader2 = new MyTest15("loader2");

        Class<?> clazz1 = loader1.loadClass("classloader.MyPerson");
        Class<?> clazz2 = loader2.loadClass("classloader.MyPerson");

        System.out.println("clazz1 == clazz2 : " + (clazz1 == clazz2));

        Object obj1 = clazz1.newInstance();
        Object obj2 = clazz2.newInstance();

        Method obj1Method = clazz1.getMethod("setMyPerson", Object.class);
        obj1Method.invoke(obj1, obj2);
    }
}
