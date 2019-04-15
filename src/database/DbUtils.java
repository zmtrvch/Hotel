package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mysql.fabric.xmlrpc.Client;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DbUtils {
	private DbUtils()
	{		
	}
	
	public static void ExecuteQuery(String query)
	{
		MysqlDataSource ds = getMySQLDataSource();
		try {
			Statement st = ds.getConnection().createStatement();
			st.execute(query);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public static <T> List<T> GetMapped(String query, Class<T> clazz) {
		MysqlDataSource ds = getMySQLDataSource();
		QueryRunner run = new QueryRunner(ds);
		ResultSetHandler<List<T>> h = new BeanListHandler<T>(clazz);
		
		List<T> persons = null;
		try {
			Statement st = ds.getConnection().createStatement();		      
			persons = run.query(query, h);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return persons;
	}
	
	private static MysqlDataSource getMySQLDataSource() {
		Properties props = new Properties();
		MysqlDataSource mysqlDS = null;
		mysqlDS = new MysqlDataSource();
		mysqlDS.setVerifyServerCertificate(false);
		mysqlDS.setURL("jdbc:mysql://localhost:3306/hotel?useSSL=false");
		mysqlDS.setUser("root");
		mysqlDS.setPassword("root");
		return mysqlDS;
	}
	
}
