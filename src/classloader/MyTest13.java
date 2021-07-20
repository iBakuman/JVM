package classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class MyTest13 {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader);

        String resourceName = "classloader/MyTest13.class";
        Enumeration<URL> urls = classLoader.getResources(resourceName);
        while (urls.hasMoreElements()){
            URL url = urls.nextElement();
            System.out.println(url);
        }

        System.out.println("------------(1)------------");
        Class<?> clazz= MyTest13.class;
        System.out.println(clazz.getClassLoader());

        System.out.println("------------(2)------------");
        System.out.println(String.class.getClassLoader());
    }
}
