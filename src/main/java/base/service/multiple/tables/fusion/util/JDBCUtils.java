package base.service.multiple.tables.fusion.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class JDBCUtils {

    /**
     * 获取连接
     */
    public static Connection getConnection(String driver, String url, String password, String username) {
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password); //获取连接对象
            return conn;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("数据库驱动类不存在");
        } catch (SQLException e) {
            throw new RuntimeException("数据库连接失败");
        }
    }

    /**
     * 查询数据库中所有列明
     */
    public static ResultSetMetaData getResultSet(Connection connection,String tableName) throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM " + tableName);
        ResultSet rs = pstmt.executeQuery();
        return rs.getMetaData();
    }

    /**
     * 查询表中所有数据
     */
    public static ResultSet getDataFromTable(Connection connection, String tableName) throws SQLException {
        String sql = "select * from " + tableName;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    /**
     * 关闭连接
     */
    public static void close(Connection connection) throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    /**
     * 关闭连接
     */
    public static void close(Connection connection, ResultSet resultSet) throws SQLException {

        if (resultSet != null) {
            resultSet.close();
        }
        close(connection);
    }
    /**
     * 关闭连接
     */
    public static void close(ResultSet resultSet) throws SQLException {

        if (resultSet != null) {
            resultSet.close();
        }
    }

    /**
     * 获取连接数据库得url
     */
    public static String getURL(String urlPattern, String ip, String port, String dataBaseName) {

        System.out.println(ip);
        System.out.println(dataBaseName);
            String url = urlPattern.replace("${ip}", ip)
                .replace("${port}", port)
                .replace("${databasename}", dataBaseName);
        System.out.println(url);
        return url;
    }

    /**
     * @param connection
     * @param tableName
     * @return int 表中总记录数
     */
    public static int findTotalPage(Connection connection, String tableName) {
        String sql = "select count(*) from " + tableName;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        throw new RuntimeException("数据不存在");
    }

}
