package classloader;

public class MySample {
    /*
        加载MySample时MySample.class在类路径中存在，故系统类加载器加载MySample.class
        当加载MyCat类时使用加载MySample的系统类加载器加载MyCat.class，但是MyCat.class
        从类路径中删除了，故找不到MyCat.class
     */
    public MySample() {
        System.out.println("MySample is loaded by: " + this.getClass().getClassLoader());
        new MyCat();// 在使用MyCat()时如果MyCat类以前没有被加载则使用MySample的类来加载MyCat
    }
}
