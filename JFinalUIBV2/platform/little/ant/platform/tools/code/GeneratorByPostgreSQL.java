package little.ant.platform.tools.code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import little.ant.platform.tools.ToolString;

public class GeneratorByPostgreSQL extends GeneratorCodeBase {

	/**
	 * 循环生成文件
	 */
	public static void main(String[] args) {
		try {
			GeneratorCodeBase base = new GeneratorByPostgreSQL();
			for (int i = 0; i < tableArr.length; i++) {
				// 表名
				String tableName = tableArr[i][0]; 
				// 数据源名称
				String dataSource = tableArr[i][1]; 
				// 是否生成Controller相关
				String generController = tableArr[i][2]; 
				// 类名
				String className = tableArr[i][3]; 
				// 类名首字母小写
				String classNameSmall = ToolString.toLowerCaseFirstOne(className); 
				/*
				// 1.生成sql文件
				base.sql(classNameSmall, tableName); 
				// 2.生成model
				base.model(className, classNameSmall, dataSource, tableName); 
				
				// 是否生成Controller相关
				if(generController.equals("0")){
					// 3.生成validator
					base.validator(className, classNameSmall); 
					// 4.生成controller
					base.controller(className, classNameSmall); 
					// 5.生成service
					base.service(className, classNameSmall); 
				}
				*/
				
				// 生成视图文件
				base.form(classNameSmall, tableName);
				base.view(classNameSmall, tableName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.exit(0);
		}
		
//		GeneratorCodeBase base = new GeneratorByPostgreSQL();
//		List<String> list = base.getDesc("blog_link");
//		for (String desc : list) {
//			System.out.println(desc);
//		}
	}

	@Override
	public List<String> getColunm(String tableName) {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (java.lang.ClassNotFoundException e) {
			System.out.print("Class not found exception occur. Message is:");
			System.out.print(e.getMessage());
		}
		
		String url = "jdbc:postgresql://127.0.0.1:5432/jfinaluibv2";
		String user = "postgres";
		String pass = "678789";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		List<String> list = new ArrayList<String>();
		
		try {
			conn = DriverManager.getConnection(url, user, pass);
			stmt = (Statement) conn.createStatement();

			rs = (ResultSet) stmt.executeQuery("select column_name from information_schema.columns where table_name = '"+tableName+"'");
			while (rs.next()) {
				String column_name = rs.getString("column_name");
				list.add(column_name);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return list;
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

	@Override
	public List<String> getDesc(String tableName) {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (java.lang.ClassNotFoundException e) {
			System.out.print("Class not found exception occur. Message is:");
			System.out.print(e.getMessage());
		}
		
		String url = "jdbc:postgresql://127.0.0.1:5432/jfinaluibv2";
		String user = "postgres";
		String pass = "678789";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		List<String> list = new ArrayList<String>();
		
		try {
			conn = DriverManager.getConnection(url, user, pass);
			stmt = (Statement) conn.createStatement();
			
			String sql = " select tbl.tablename, des.objsubid, des.description ";
			sql += " from ";
			sql += "	pg_tables as tbl ";
			sql += "	inner join pg_class c ON tbl.tablename = c.relname";
			sql += "	left join pg_description as des ON c.oid = des.objoid";
			
			sql += " where ";
			sql += "	tbl.schemaname != 'pg_catalog' AND tbl.schemaname != 'information_schema' and tbl.tablename = '"+tableName+"' ";
			
			sql += " order by des.objsubid asc";

			rs = (ResultSet) stmt.executeQuery(sql);
			while (rs.next()) {
				String column_name = rs.getString("description");
				list.add(column_name);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return list;
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

}
