package daoimpl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import vo.*;
import dao.*;
import dbc.DataBaseConnection;
public class CourseDAOImpl implements CourseDAO{
	public boolean isCreate(CourseVo cla) {
		boolean flag = false ;
		PreparedStatement pstmt	= null ;
		ResultSet rs= null ;
		String sql= null ;
		DataBaseConnection dbc= null ;
		dbc = new DataBaseConnection() ;
		sql = "SELECT name FROM course WHERE id=?" ;
		try
		{	
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1,cla.getId()) ;
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
