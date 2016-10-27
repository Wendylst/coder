package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtil {
	
	public static Connection dbcpConnection(){
		Context initContext;
		Connection conn=null;
		try {
			initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		
	}
	
	
	
    //DB연결
	public static Connection connect(String path){
		Connection conn=null;
		Properties pro = new Properties();
		try {
			pro.load(new FileInputStream(path));
			Class.forName(pro.getProperty("driver"));
			String url=pro.getProperty("url");
			String user= pro.getProperty("user");
			String password=pro.getProperty("password");
		    conn = DriverManager.getConnection(url,
		    		user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("class없음:"+e.getMessage());
		} catch (SQLException e) {
			System.out.println("DB연결실패:"+e.getMessage());
		} catch (FileNotFoundException e) {
			System.out.println("파일경로확인:"+e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public static Connection connect(String path, boolean auto){
		Connection conn=null;
		Properties pro = new Properties();
		try {
			pro.load(new FileInputStream(path));
			Class.forName(pro.getProperty("driver"));
			String url=pro.getProperty("url");
			String user= pro.getProperty("user");
			String password=pro.getProperty("password");
		    conn = DriverManager.getConnection(url,
		    		user, password);
		    conn.setAutoCommit(auto);
		} catch (ClassNotFoundException e) {
			System.out.println("class없음:"+e.getMessage());
		} catch (SQLException e) {
			System.out.println("DB연결실패:"+e.getMessage());
		} catch (FileNotFoundException e) {
			System.out.println("파일경로확인:"+e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	
	//DB해제 ..select,
	public static void disconnect(ResultSet rs, 
			Statement st, Connection conn){		
		try {
			if(rs!=null) rs.close();
			if(st!=null) st.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}	
	//insert,delete,update 
	public static void disconnect(
			Statement st, Connection conn){		
		try {
			if(st!=null) st.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}








