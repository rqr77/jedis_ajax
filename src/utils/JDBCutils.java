package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

//
public class JDBCutils   {
    private static DataSource ds;
    static {

        try {
            Properties properties = new Properties();
            InputStream is = JDBCutils.class.getClassLoader().getResourceAsStream("properties");
            properties.load(is);
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        //获取连接池对象
    public static DataSource getDs(){
        return ds;
    }
    //获取连接Connection对象
    public static Connection getConnection() throws SQLException{
        return ds.getConnection();
    }

}
