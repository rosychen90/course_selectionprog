// 本类只用于数据库连接及关闭操作
package dbc ;

import java.sql.* ;
public class DataBaseConnection
{
	// 属性
	// 定义数据库操作的常量、对象
	// 数据库驱动程序
	private final String DBDRIVER	= "com.mysql.jdbc.Driver" ;
	// 数据库连接地址
	private final String DBURL		= "jdbc:mysql://localhost:3306/sqldb?user=root&password=1&useUnicode=true&characterEncoding=utf-8" ;
	// 声明一个数据库连接对象
	private Connection conn			= null ;

	// 在构造方法之中连接数据库
	public DataBaseConnection()
	{
		try
		{
			// 加载驱动程序
			Class.forName(DBDRIVER) ; 
			// 连接数据库
			conn = DriverManager.getConnection(DBURL) ;	
		}
		catch (Exception e)
		{
			System.out.println(e) ;
		}
	}

	// 返回一个数据库连接
	public Connection getConnection()
	{
		/// 返回连接对象
		return this.conn ;
	}

	// 关闭数据库连接
	public void close()
	{
		try
		{
			this.conn.close() ;			
		}
		catch (Exception e)
		{
		}
	}
};
