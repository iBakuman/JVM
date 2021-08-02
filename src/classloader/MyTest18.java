package classloader;

import com.sun.crypto.provider.AESKeyGenerator;

public class MyTest18 {
    public static void main(String[] args) {
        // 使用java -Djava.ext.dirs=./ classloader.MyTest18再运行这个程序
        AESKeyGenerator aesKeyGenerator = new AESKeyGenerator();
        System.out.println(aesKeyGenerator.getClass().getClassLoader());
        System.out.println(MyTest18.class.getClassLoader());
    }
}
