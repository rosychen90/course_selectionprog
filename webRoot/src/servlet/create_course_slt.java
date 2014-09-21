package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.CourseVo;
import factory.DAOFactory;

public class create_course_slt extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public create_course_slt() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// 声明一个集合类，用于保存错误信息
		request.setCharacterEncoding("UTF-8");
		ArrayList<String> errors = new ArrayList<String>();
		String name = (String) request.getParameter("name");
		String id = (String) request.getParameter("id");
		String teacher_id = (String) request.getParameter("teacher_id");
		String status = (String) request.getParameter("status");
		String time = (String) request.getParameter("time");
		String classroom = (String) request.getParameter("classroom");
		int num = 0;
		int maxNum = 0;
		if (request.getParameter("maxNum") != null
				&& request.getParameter("maxNum") != "") {
			try{
				num = Integer.parseInt((String) request.getParameter("maxNum"));
				maxNum = Integer.parseInt((String) request.getParameter("maxNum"));	
			}catch(Exception e){}
		}
		CourseVo cv = new CourseVo();
		cv.setId(id);
		cv.setName(name);
		cv.setTeacher_id(teacher_id);
		cv.setStatus(status);
		cv.setTime(time);
		cv.setClassroom(classroom);
		cv.setNum(num);
		cv.setMaxNum(maxNum);
		cv.setErrors(errors);
		if (cv.register()) {

			if (DAOFactory.getCourseDAOInstance().isCreate(cv)) {
				errors.add("您输入的课程编号重复");
			} else {
				if (DAOFactory.getTeacherDAOInstance().insertCourse(cv)) {
					errors.add("添加成功");
				} else {
					errors.add("添加失败");
				}
			}
		}
		request.getSession().setAttribute("errors_create_course", errors);
		response.sendRedirect("../teacher/create_course.jsp");
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
