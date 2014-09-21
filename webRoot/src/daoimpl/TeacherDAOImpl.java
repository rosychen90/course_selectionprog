// ����ʵ��DAO�ӿڵ���

package daoimpl ;

// ��Ҫ�������ݿ�
// ��Ҫ��VO�����ݽ��о������֤
import java.sql.* ;

import dao.* ;
import dbc.* ;
import vo.* ;

public class TeacherDAOImpl implements TeacherDAO{
	public boolean isLogin(PersonVo pv)
	{
		boolean flag = false ;
		// ����һ�����ݿ��������
		PreparedStatement pstmt	= null ;
		// ����һ�����������
		ResultSet rs			= null ;
		// ����һ��SQL���������ڱ���SQL���
		String sql				= null ;
		// DataBaseConnectionΪ��������ݿ����Ӽ��رղ�����
		DataBaseConnection dbc	= null ;
		// �������ݿ�
		dbc = new DataBaseConnection() ;

		// ��дSQL���
		sql = "SELECT name FROM teacher WHERE id=? and password=?" ;
		try
		{			
			// ʵ�������ݿ��������
			pstmt = dbc.getConnection().prepareStatement(sql);

			// ����pstmt�����ݣ��ǰ�ID��������֤
			pstmt.setString(1,pv.getId()) ;
			pstmt.setString(2,pv.getPassword()) ;

			// ��ѯ��¼
			rs = pstmt.executeQuery();
			// �ж��Ƿ��м�¼
			if(rs.next())
			{
				// ����м�¼����ִ�д˶δ���
				// �û��ǺϷ��ģ����Ե�½
				flag = true ;
				pv.setName(rs.getString(1)) ;
			}
			// ���ιر�
			rs.close() ;
			pstmt.close() ;
		}
		catch(Exception e)
		{
			System.out.println(e) ;
		}
		finally
		{
			// ���һ��Ҫ��֤���ݿ��ѱ��ر�
			dbc.close() ;
		}
		return flag ;
	}


	public boolean deleCourse(String course_id[]) {
		boolean flag=true;
		PreparedStatement pstmt	= null ;
		PreparedStatement pstmt2	= null ;
		PreparedStatement pstmt3	= null ;
		String sql				= null ;
		String sql2				= null ;
		String sql3				= null ;
		DataBaseConnection dbc	= null ;
		dbc = new DataBaseConnection();
		sql = "DELETE FROM create_cour WHERE course_id=?" ;
		sql2="DELETE FROM course WHERE id=?";
		sql3="DELETE FROM select_info WHERE course_id=?";
		try
		{	
			for(int i=0;i<course_id.length;i++){
				pstmt = dbc.getConnection().prepareStatement(sql) ;
				pstmt2=dbc.getConnection().prepareStatement(sql2) ;
				pstmt3=dbc.getConnection().prepareStatement(sql3) ;
				pstmt.setString(1,course_id[i]) ;
				pstmt2.setString(1,course_id[i]) ;
				pstmt3.setString(1,course_id[i]) ;
				pstmt.executeUpdate();
				pstmt2.executeUpdate();
				pstmt3.executeUpdate();
				
			}
			
			pstmt.close() ;
			pstmt2.close() ;
			pstmt3.close() ;
		}catch (Exception e)
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
	public boolean insertCourse(CourseVo cv) {
		boolean flag = true ;
		PreparedStatement pstmt	= null ;
		PreparedStatement pstmt2	= null ;
		String sql				= null ;
		DataBaseConnection dbc	= null ;
		dbc = new DataBaseConnection();
		//id name teacher_id college_id status time classroom num maxNum
		sql = "INSERT INTO course(id,name,teacher_id,status,time,classroom,num,maxNum) VALUES(?,?,?,?,?,?,?,?)" ;
		String sql2="INSERT INTO create_cour(teacher_id,course_id) VALUES(?,?)";
		try
		{	pstmt2=dbc.getConnection().prepareStatement(sql2);
			pstmt2.setString(1,cv.getTeacher_id());
			pstmt2.setString(2,cv.getId());
			pstmt = dbc.getConnection().prepareStatement(sql) ;
			pstmt.setString(1,cv.getId()) ;
			pstmt.setString(2,cv.getName()) ;
			pstmt.setString(3,cv.getTeacher_id()) ;
			pstmt.setString(4,cv.getStatus()) ;
			pstmt.setString(5,cv.getTime());
			pstmt.setString(6,cv.getClassroom()) ;
			pstmt.setInt(7,cv.getNum());
			pstmt.setInt(8,cv.getMaxNum());
			pstmt.executeUpdate() ;
			pstmt2.executeUpdate() ;
			pstmt.close() ;
			pstmt2.close();
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
	public boolean isTrue(String id) {
		boolean flag = false ;
		PreparedStatement pstmt	= null ;
		ResultSet rs			= null ;
		
		String sql				= null ;
		DataBaseConnection dbc	= null ;
	
		dbc = new DataBaseConnection() ;
		sql = "SELECT name FROM teacher WHERE id=?" ;
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
}
