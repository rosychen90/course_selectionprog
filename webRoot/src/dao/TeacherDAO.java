package dao;

import vo.*;

public interface TeacherDAO {
	// ��Ҫһ����½��֤�ķ���
	
	public boolean isTrue(String id);///


	public boolean isLogin(PersonVo pv);///
	public boolean insertCourse(CourseVo cla);///
	public boolean deleCourse(String id[]);///
}
