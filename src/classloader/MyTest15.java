package classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Objects;

// 自定义类加载器
public class MyTest15 extends ClassLoader {
    private String classloaderName;
    private final String fileExtension = ".class";
    private String path;

    public MyTest15(String classloaderName) {
        super();// Creates a new class loader using the ClassLoader returned by the method getSystemClassLoader() as the parent class loader.
        this.classloaderName = classloaderName;
    }

    public MyTest15(ClassLoader parent, String classloaderName) {
        super(parent);// Creates a new class loader using the specified parent class loader for delegation.
        this.classloaderName = classloaderName;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "MyTest15{" +
                "classloaderName='" + classloaderName + '\'' +
                '}';
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        System.out.println("findClass invoked: " + classloaderName);
        System.out.println("class loader name: " + this.classloaderName);
        // 该方法在loadClass中被调用
        byte[] data = this.loadClassData(className);
        return this.defineClass(className, data, 0, data.length);
    }

    // loadClassData不是重载的方法
    private byte[] loadClassData(String className) {
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;
        try {
            this.classloaderName = this.classloaderName.replace(".", System.getProperty("file.separator"));
            className = className.replace(".", System.getProperty("file.separator"));
            is = new FileInputStream(new File(path + className + this.fileExtension));
            baos = new ByteArrayOutputStream();

            int ch = 0;

            while (-1 != (ch = is.read())) {
                baos.write(ch);
            }
            data = baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) is.close();
                if (baos != null) baos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    public static void test(ClassLoader classLoader) throws Exception {
        /*
            Loads the class with the specified binary name. The default implementation of this method searches for classes in the following order:
                1.Invoke findLoadedClass(String) to check if the class has already been loaded.
                2.Invoke the loadClass method on the parent class loader. If the parent is null the class loader built-in to the virtual machine is used, instead.
                3.Invoke the findClass(String) method to find the class.
         */
        Class<?> clazz = classLoader.loadClass("classloader.MyTest1");
        System.out.println("class: " + clazz.hashCode());
        Object obj = clazz.newInstance();
        System.out.println(obj);
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        System.out.println("classpath: " + MyTest15.class.getResource("").toString());

        // loader1和loader2加载同一个类，且当前类不在类路径。
        String classPath = "F:\\Project\\Java\\JVM\\test\\";
        MyTest15 loader1 = new MyTest15("loader1");
        loader1.setPath(classPath);
        Class<?> clazz = loader1.loadClass("classloader.MyTest1");
        System.out.println("class: " + clazz.hashCode());
        Object obj = clazz.newInstance();
        System.out.println(obj);
        System.out.println();

        loader1 = null;
        clazz = null;
        obj = null;

        System.gc();

        // 演示类的卸载，需要加上虚拟机参数-XX:+TraceClassUnloading
        System.out.println("--------------------------");
        Thread.sleep(100000);
        loader1 = new MyTest15("loader1");
        loader1.setPath(classPath);
        clazz = loader1.loadClass("classloader.MyTest1");
        System.out.println("class: " + clazz.hashCode());
        obj = clazz.newInstance();
        System.out.println(obj);
        System.out.println();
    }
}
