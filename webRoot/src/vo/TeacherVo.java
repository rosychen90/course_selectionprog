package vo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbc.DataBaseConnection;

public class TeacherVo  extends PersonVo{
	private String college;
	private ResultSet rs;
	private DataBaseConnection dbc = null ;
	private PreparedStatement pstmt = null ;
	
	public PreparedStatement getPstmt() {
		return pstmt;
	}
	public void setSQL(String sql) throws SQLException{
		pstmt = dbc.getConnection().prepareStatement(sql);
	}
	public TeacherVo(){
		
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
	

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}
	public boolean regist(){
		boolean flag = true ;
		if(this.id==null||"".equals(this.id))
		{
			flag = false ;
			errors.add("ID����Ϊ�գ�") ;
		}
		if(this.name==null||"".equals(this.name))
		{
			flag = false ;
			errors.add("��������Ϊ�գ�") ;
		}
		else
		{
			// ���г�����֤��3~10λ
			if(this.id.length()<3||this.id.length()>10)
			{
				flag = false ;
				errors.add("ID�ĳ���ӦΪ3~10λ��") ;
			}
		}
		// ��֤����
		if(this.password==null||"".equals(this.password))
		{
			flag = false ;
			errors.add("���벻��Ϊ�գ�") ;
		}
		else
		{
			// ���г�����֤��3~10λ
			if(this.password.length()<3||this.password.length()>10)
			{
				flag = false ;
				errors.add("����ĳ���ӦΪ3~10λ��") ;
			}
		}
		return flag;
	}
	
}
