package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mysql.cj.jdbc.MysqlDataSource;



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
	
	  public static int insertAndGetId(String query)
	    {  
		  System.out.println(query);
		  MysqlDataSource ds = getMySQLDataSource();
		  Connection conn;
	       int insertedId = 0;    

			try {
				conn = ds.getConnection();
		        PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	            ps.execute();
		        insertedId = getInsertedId(ps);       

			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	      
	      return insertedId;
	    }

	    private static int getInsertedId(PreparedStatement statement) throws SQLException {
	        ResultSet generatedKeys = statement.getGeneratedKeys();
	        int insertedId = 0;
	        if (generatedKeys.next()) {
	            insertedId = generatedKeys.getInt(1);
	        }
	        return insertedId;
	    }
	
	private static MysqlDataSource getMySQLDataSource() {
		Properties props = new Properties();
		MysqlDataSource mysqlDS = null;
		mysqlDS = new MysqlDataSource();
		try {
			mysqlDS.setVerifyServerCertificate(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mysqlDS.setURL("jdbc:mysql://localhost:3306/hotel?useSSL=false&allowPublicKeyRetrieval=true");
		mysqlDS.setUser("root");
		mysqlDS.setPassword("root");
		return mysqlDS;
	}
	
}
