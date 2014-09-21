// ����ֻ�������ݿ����Ӽ��رղ���
package dbc ;

import java.sql.* ;
public class DataBaseConnection
{
	// ����
	// �������ݿ�����ĳ���������
	// ���ݿ���������
	private final String DBDRIVER	= "com.mysql.jdbc.Driver" ;
	// ���ݿ����ӵ�ַ
	private final String DBURL		= "jdbc:mysql://localhost:3306/sqldb?user=root&password=1&useUnicode=true&characterEncoding=utf-8" ;
	// ����һ�����ݿ����Ӷ���
	private Connection conn			= null ;

	// �ڹ��췽��֮���������ݿ�
	public DataBaseConnection()
	{
		try
		{
			// ������������
			Class.forName(DBDRIVER) ; 
			// �������ݿ�
			conn = DriverManager.getConnection(DBURL) ;	
		}
		catch (Exception e)
		{
			System.out.println(e) ;
		}
	}

	// ����һ�����ݿ�����
	public Connection getConnection()
	{
		/// �������Ӷ���
		return this.conn ;
	}

	// �ر����ݿ�����
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
