package vo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbc.DataBaseConnection;

public class CourseVo {
	private String id;
	private String name;
	private String teacher_id;
	private String status;
	private String time;
	private String classroom;
	private ArrayList<String> errors;
	private int num;
	private int maxNum;
	private ResultSet rs=null;
	private DataBaseConnection dbc = null ;
	private PreparedStatement pstmt = null ;
	
	public ArrayList<String> getErrors() {
		return errors;
	}
	public void setErrors(ArrayList<String> errors) {
		this.errors = errors;
	}
	public PreparedStatement getPstmt() {
		return pstmt;
	}
	public void setSQL(String sql) throws SQLException{
		pstmt = dbc.getConnection().prepareStatement(sql);
	}
	public CourseVo(){
		
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
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getTeacher_id() {
		return teacher_id;
	}
	public String getStatus() {
		return status;
	}
	public String getTime() {
		return time;
	}
	public String getClassroom() {
		return classroom;
	}
	public int getNum() {
		return num;
	}
	public int getMaxNum() {
		return maxNum;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setTeacher_id(String teacherId) {
		teacher_id = teacherId;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public void setMaxNum(int maxNum) {
		this.maxNum = maxNum;
	}
	public boolean register(){
		boolean flag = true ;
		if(this.id==null||"".equals(this.id))
		{
			flag = false ;
			errors.add("ID不能为空！") ;
		}
		if(this.name==null||"".equals(this.name))
		{
			flag = false ;
			errors.add("课程名不能为空！") ;
		}
		else
		{
			// 进行长度验证：3~10位
			if(this.id.length()<3||this.id.length()>10)
			{
				flag = false ;
				errors.add("ID的长度应为3~10位！") ;
			}
		}
		// 验证密码
		if(this.teacher_id==null||"".equals(this.teacher_id))
		{
			flag = false ;
			errors.add("教师不能为空！") ;
		}
		if(this.maxNum==0)
		{
			flag = false ;
			errors.add("总空位不能为零或者不填") ;
		}
		return flag;
		
	}
}
