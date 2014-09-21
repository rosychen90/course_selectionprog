package dao;

import vo.*;

public interface StudentDAO {
	// 需要一个登陆验证的方法
	public boolean isTrue(String id);///
	public boolean isLogin(PersonVo pv);///
	public boolean insertStudent(StudentVo sv);///
	public boolean deleCourse(String id,String[] courseId); ///
	public boolean addCourse(String id,String[] courseId);///
	
}
