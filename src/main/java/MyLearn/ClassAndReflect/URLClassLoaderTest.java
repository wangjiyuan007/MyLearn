package MyLearn.ClassAndReflect;

import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.Driver;
import java.util.Properties;

/**
 * @Title: URLClassLoaderTest
 * @Description: 加载mysql驱动
 * @Company: www.leador.com.cn
 * @Date: 2019-04-23 19:13
 * @author: wangjiyuan
 * @Version: 1.0
 **/

public class URLClassLoaderTest {
    private static Connection conn;
    //定义一个获取数据库连接的方法
    public static Connection getConn(String url,String user,String pass) throws  Exception{
        if (conn == null){
            //创建一个URL数组
            URL[] urls = {new URL("file:mysql-connector-java-5.1.30-bin.jar")};
            //以默认的ClassLoader作为父ClassLoader，创建URLClassLoader
            URLClassLoader myClassLoader = new URLClassLoader(urls);
            //加载mysql的jdbc驱动，并创建默认实例
            Driver driver = (Driver)myClassLoader.loadClass("com.mysql.jdbc.Driver").newInstance();
            //创建一个设置jdbc连接属性的properties对象
            Properties props = new Properties();
            props.setProperty("user",user);
            props.setProperty("password",pass);
            //调用Driver对象的connect方法来取得数据库连接
            conn = driver.connect(url,props);
        }
        return conn;
    }

    public static void main(String[] args) throws Exception{
        System.out.println(getConn("jdbc:mysql://localhost:3306/Test","root","root"));
    }
}
