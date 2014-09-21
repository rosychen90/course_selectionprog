package vo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbc.DataBaseConnection;

public class SelectInfo {
	private String student_id;
	private String course_id;
	private ResultSet rs=null;;
	private DataBaseConnection dbc = null ;
	private PreparedStatement pstmt = null ;
	
	public PreparedStatement getPstmt() {
		return pstmt;
	}
	public void setSQL(String sql) throws SQLException{
		pstmt = dbc.getConnection().prepareStatement(sql);
	}
	public SelectInfo(){

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
		rs.close();
		pstmt.close();
		dbc.close();
	}
	public String getStudent_id() {
		return student_id;
	}
	public String getCourse_id() {
		return course_id;
	}
	public void setStudent_id(String studentId) {
		student_id = studentId;
	}
	public void setCourse_id(String courseId) {
		course_id = courseId;
	}
	
}
