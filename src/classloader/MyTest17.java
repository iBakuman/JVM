package classloader;

public class MyTest17 {
    public static void main(String[] args) {
        // 系统类加载器加载的字节码文件的路径
        System.out.println("<---------------------Bootstrap ClassLoader---------------------->");
        String paths = System.getProperty("java.class.path");
        String[] strs = paths.split(";");
        for (String str : strs)
            System.out.println(str);
        // 扩展类加载器加载的字节码文件的路径
        System.out.println("----------------------->Extension ClassLoader--------------------->");
        paths = System.getProperty("java.ext.dirs");
        strs = paths.split(";");
        for (String str : strs)
            System.out.println(str);

        // 系统类加载器加载的字节码文件的路径
        paths = System.getProperty("java.class.path");
        strs = paths.split(";");
        System.out.println("<----------------------System ClassLoader------------------->");
        for (String str : strs)
            System.out.println(str);
    }
}
