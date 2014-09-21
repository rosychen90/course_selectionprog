// 具体实现DAO接口的类

package daoimpl ;

// 需要连接数据库
// 需要对VO的内容进行具体的验证
import java.sql.* ;

import dao.* ;
import dbc.* ;
import vo.* ;

public class StudentDAOImpl implements StudentDAO
{
	
	public boolean insertStudent(StudentVo sv){
		boolean flag = true ;
		PreparedStatement pstmt	= null ;
		String sql				= null ;
		DataBaseConnection dbc	= null ;
		dbc = new DataBaseConnection();
		//id password name sex college_id profession email telephone
		sql = "INSERT INTO student(id,password,name,sex,college,profession) VALUES(?,?,?,?,?,?)" ;
		try
		{	
			pstmt = dbc.getConnection().prepareStatement(sql) ;
			pstmt.setString(1,sv.getId()) ;
			pstmt.setString(2,sv.getPassword()) ;
			pstmt.setString(3,sv.getName()) ;
			pstmt.setInt(4,sv.getSex()) ;
			pstmt.setString(5,sv.getCollege()) ;
			pstmt.setString(6,sv.getProfession());
			pstmt.executeUpdate() ;
			pstmt.close() ;
		}
		catch (Exception e)
		{
			flag=false;
			System.out.println(e);
		}
		finally
		{
			dbc.close() ;
		}
		return flag;
	}
	
	
	public boolean isLogin(PersonVo pv)
	{
		boolean flag = false ;
		// 在此处成具体的数据库验证

		// 声明一个数据库操作对象
		PreparedStatement pstmt	= null ;
		// 声明一个结果集对象
		ResultSet rs			= null ;
		// 声明一个SQL变量，用于保存SQL语句
		String sql				= null ;
		// DataBaseConnection为具体的数据库连接及关闭操作类
		DataBaseConnection dbc	= null ;
		// 连接数据库
		dbc = new DataBaseConnection() ;

		// 编写SQL语句
		sql = "SELECT name FROM student WHERE id=? and password=?" ;
		try
		{			
			// 实例化数据库操作对象
			pstmt = dbc.getConnection().prepareStatement(sql);

			// 设置pstmt的内容，是按ID和密码验证
			pstmt.setString(1,pv.getId()) ;
			pstmt.setString(2,pv.getPassword()) ;

			// 查询记录
			rs = pstmt.executeQuery() ;
			// 判断是否有记录
			if(rs.next())
			{
				// 如果有记录，则执行此段代码
				// 用户是合法的，可以登陆
				flag = true ;
				pv.setName(rs.getString(1)) ;
			}
			// 依次关闭
			rs.close() ;
			pstmt.close() ;
		}
		catch(Exception e)
		{
			System.out.println(e) ;
		}
		finally
		{
			// 最后一定要保证数据库已被关闭
			dbc.close() ;
		}
		return flag ;
	}


    public boolean deleCourse(String id,String[] courseId) {
		boolean flag=true;
		PreparedStatement pstmt	= null ;
		DataBaseConnection dbc	= null ;
		ResultSet rs=null;

		String sql=null;
		dbc=new DataBaseConnection();
		try {
			for(int i=0;i<courseId.length;i++){
				sql="DELETE FROM select_info WHERE student_id=?&&course_id=?";
				pstmt = dbc.getConnection().prepareStatement(sql) ;
				pstmt.setString(1,id) ;
				pstmt.setString(2,courseId[i]);
				pstmt.executeUpdate();
				sql = "SELECT num FROM course WHERE id=?";
				pstmt = dbc.getConnection().prepareStatement(sql);
				pstmt.setString(1,courseId[i]);
				rs=pstmt.executeQuery();
				while(rs.next()){
					int num=rs.getInt(1);
					sql = "UPDATE course SET num=? WHERE id=?" ;
					pstmt = dbc.getConnection().prepareStatement(sql);
					pstmt.setString(2,courseId[i]);
					pstmt.setInt(1, num+1);
					pstmt.executeUpdate() ;
				}
			}
			pstmt.close();
		} catch (SQLException e) {
			flag=false;
			e.printStackTrace();
		}
		
		dbc.close();
		return flag;
	}
	public boolean isTrue(String id) {
		boolean flag = false ;
		PreparedStatement pstmt	= null ;
		ResultSet rs			= null ;
		
		String sql				= null ;
		DataBaseConnection dbc	= null ;
	
		dbc = new DataBaseConnection() ;
		sql = "SELECT name FROM student WHERE id=?" ;
		try
		{			

			pstmt = dbc.getConnection().prepareStatement(sql);

			pstmt.setString(1,id) ;

			rs = pstmt.executeQuery() ;
			if(rs.next())
			{
				flag = true ;
			}
			rs.close() ;
			pstmt.close() ;
		}
		catch(Exception e)
		{
			System.out.println(e) ;
		}
		finally
		{
			dbc.close() ;
		}
		return flag ;
	}


	public boolean addCourse(String id, String[] courseId){
		boolean flag=true;
		PreparedStatement pstmt	= null ;
		DataBaseConnection dbc	= null ;
		ResultSet rs=null;

		String sql=null;
		dbc=new DataBaseConnection();
		try {
			for(int i=0;i<courseId.length;i++){
				
				sql="INSERT INTO select_info(student_id,course_id) VALUES (?,?)";
				pstmt = dbc.getConnection().prepareStatement(sql) ;
				pstmt.setString(1,id) ;
				pstmt.setString(2,courseId[i]);
				pstmt.executeUpdate();
				sql = "SELECT num FROM course WHERE id=?";
				pstmt = dbc.getConnection().prepareStatement(sql);
				pstmt.setString(1,courseId[i]);
				rs=pstmt.executeQuery();
				while(rs.next()){
					int num=rs.getInt(1);
					sql = "UPDATE course SET num=? WHERE id=?" ;
					pstmt = dbc.getConnection().prepareStatement(sql);
					pstmt.setString(2,courseId[i]);
					pstmt.setInt(1, num-1);
					pstmt.executeUpdate() ;
				}
			}
			pstmt.close();
		} catch (SQLException e) {
			flag=false;
			e.printStackTrace();
		}
		
		dbc.close();
		return flag;	
	}
}
