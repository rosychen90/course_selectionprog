package dao;

import vo.*;

public interface TeacherDAO {
	// 需要一个登陆验证的方法
	
	public boolean isTrue(String id);///


	public boolean isLogin(PersonVo pv);///
	public boolean insertCourse(CourseVo cla);///
	public boolean deleCourse(String id[]);///
}
