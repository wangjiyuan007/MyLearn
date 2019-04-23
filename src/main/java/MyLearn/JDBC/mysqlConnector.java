package MyLearn.JDBC;

import java.sql.*;

public class mysqlConnector {
    public static void main(String[] args){
        //声明connection对象
        Connection conn;
        //驱动程序名
        String driver = "com.mysql.cj.jdbc.Driver";
        //url指向要访问的数据库名
        String url = "jdbc:mysql://localhost:3306/my_test";
        //用户名和密码
        String user = "root";
        String password = "root";

        try {
            Class.forName(driver);
            //1.getConnection()方法，连接MySQL数据库！
            conn = DriverManager.getConnection(url,user,password);
            if(!conn.isClosed()){
                System.out.println(url + "数据库连接成功");
            }
            //2.创建statement类对象，用来执行SQL语句！
            Statement statement = conn.createStatement();
            String sql = "select * from emp";

            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println("-----------------");
            System.out.println("执行结果如下所示:");
            System.out.println("-----------------");
            System.out.println("姓名" + "\t" + "职称");
            System.out.println("-----------------");

            String job = null;
            String name = null;
            while (resultSet.next()){
                job = resultSet.getString("job");
                name = resultSet.getString("ename");

                System.out.println(name + "\t" + job);
            }
            resultSet.close();
            conn.close();
        } catch (ClassNotFoundException e){
            //数据库驱动类异常处理
            System.out.println("没有找到驱动！");
            e.printStackTrace();
        }catch (SQLException e){
            //数据库连接失败异常处理
            System.out.println("数据库连接失败！");
            e.printStackTrace();
        }
    }
}
