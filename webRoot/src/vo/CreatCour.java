package vo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbc.DataBaseConnection;

public class CreatCour {
	private String teacher_id;
	private String course_id;
	private ResultSet rs;
	private DataBaseConnection dbc = null ;
	private PreparedStatement pstmt = null ;
	
	public PreparedStatement getPstmt() {
		return pstmt;
	}
	public void setSQL(String sql) throws SQLException{
		pstmt = dbc.getConnection().prepareStatement(sql);
	}
	public CreatCour(){
		
		dbc = new DataBaseConnection();
	}
	public boolean setResultSet(){
			boolean flag=true;
			try {
				rs = pstmt.executeQuery();
			} catch (SQLException e) {
				flag=false;
				e.printStackTrace();
			}
		return flag;
	}
	public ResultSet getRs() {
		return rs;
	}
	public void close() throws SQLException{
		pstmt.close();
		rs.close();
		dbc.close();
	}
	
	public String getTeacher_id() {
		return teacher_id;
	}
	public String getCourse_id() {
		return course_id;
	}
	public void setTeacher_id(String teacherId) {
		teacher_id = teacherId;
	}
	public void setCourse_id(String courseId) {
		course_id = courseId;
	}
	
}
