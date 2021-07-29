package classloader;

public class MyTest16 {
    public static void main(String[] args) throws Exception {
        MyTest15 loader1 = new MyTest15("loader1");
        Class<?> clazz = loader1.loadClass("classloader.MySample");
        System.out.println("class: " + clazz.hashCode());
        // 加上虚拟机参数-XX:+TraceClassLoading查看结果
        Object obj =  clazz.newInstance();
    }
}
