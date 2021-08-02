package classloader;

/*
    如果一个类的字节码文件同时存在于启动类加载器和
    系统类加载器所加载类时搜索的路径，则会优先使用
    存在于启动类加载器搜索路径中的类
 */
public class MyTest17_1 {
    public static void main(String[] args) throws ClassNotFoundException {
        String path = "";
        MyTest15 loader1 = new MyTest15("loader1");
        loader1.setPath(path);
        Class<?> clazz = loader1.loadClass("classloader.MyTest1");

        System.out.println("class: " + clazz.hashCode());
        System.out.println("class loader: " + clazz.getClassLoader());

    }

}
