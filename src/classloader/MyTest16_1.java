package classloader;

/*
    MySample由自定义类加载器加载，MyCat是由系统类加载器加载的
    在MyCat类中访问MySample.class是不行的，MySample所处的命名空间
    包含MyCat所处的命名空间，MySample中可以访问MyCat.class，但是
    MyCat中不可以访问MySample.class

    命名空间重要说明
        1.子加载器所加载的类能够访问父加载器所加载的类
        2.父加载器所加载的类无法访问子加载器所加载的类
 */
public class MyTest16_1 {
    public static void main(String[] args) throws Exception{
        MyTest15 loader1 = new MyTest15("loader1");
        loader1.setPath("F:\\Project\\Java\\JVM\\test\\");
        // 加载之前删除classPath中的MySample.class与MyCat.class
        Class<?> clazz = loader1.loadClass("classloader.MySample");
        System.out.println("class: " + clazz.hashCode());
        // 加上虚拟机参数-XX:+TraceClassLoading查看结果
        Object obj =  clazz.newInstance();
    }
}
