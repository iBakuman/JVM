package classloader;

// 注意：加载MySample.class与MyCat.class的是同一个类加载器的实例
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
