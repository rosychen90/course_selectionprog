// ����ʵ��DAO�ӿڵ���

package daoimpl ;

// ��Ҫ�������ݿ�
// ��Ҫ��VO�����ݽ��о������֤
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
		// �ڴ˴��ɾ�������ݿ���֤

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
		sql = "SELECT name FROM student WHERE id=? and password=?" ;
		try
		{			
			// ʵ�������ݿ��������
			pstmt = dbc.getConnection().prepareStatement(sql);

			// ����pstmt�����ݣ��ǰ�ID��������֤
			pstmt.setString(1,pv.getId()) ;
			pstmt.setString(2,pv.getPassword()) ;

			// ��ѯ��¼
			rs = pstmt.executeQuery() ;
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
