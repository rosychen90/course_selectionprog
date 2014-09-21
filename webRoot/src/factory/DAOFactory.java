// 取得DAO实例的工厂类

package factory ;

import dao.* ;
import daoimpl.* ;

public class DAOFactory
{
	public static StudentDAO getStudentDAOInstance()
	{
		return new StudentDAOImpl() ;
	}
	public static TeacherDAO getTeacherDAOInstance()
	{
		return new TeacherDAOImpl() ;
	}
	public static CourseDAO getCourseDAOInstance()
	{
		return new CourseDAOImpl() ;
	}
};