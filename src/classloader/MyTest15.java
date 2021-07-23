package classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

// 自定义类加载器
public class MyTest15 extends ClassLoader {
    private String classloaderName;
    private final String fileExtension = ".class";

    public MyTest15(String classloaderName) {
        super();// Creates a new class loader using the ClassLoader returned by the method getSystemClassLoader() as the parent class loader.
        this.classloaderName = classloaderName;
    }

    public MyTest15(ClassLoader parent, String classloaderName) {
        super(parent);// Creates a new class loader using the specified parent class loader for delegation.
        this.classloaderName = classloaderName;
    }

    @Override
    public String toString() {
        return "MyTest15{" +
                "classloaderName='" + classloaderName + '\'' +
                '}';
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // 该方法在loadClass中被调用
        byte[] data = this.loadClassData(name);
        return this.defineClass(name, data, 0, data.length);
    }

    private byte[] loadClassData(String name) {
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;
        try {
            this.classloaderName = this.classloaderName.replace(".", System.getProperty("file.separator"));
            is = new FileInputStream(new File(name + this.fileExtension));
            baos = new ByteArrayOutputStream();

            int ch = 0;

            while(-1 != (ch = is.read())){
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
        Class<?> clazz = classLoader.loadClass("classloader.MyTest1");
        Object obj = clazz.newInstance();
        System.out.println(obj);
    }

    public static void main(String[] args) throws Exception {
        MyTest15 loader1 = new MyTest15("loader1");
        test(loader1);
    }
}
