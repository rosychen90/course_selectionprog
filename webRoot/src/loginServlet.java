import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.*;
import factory.DAOFactory;

public class loginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public loginServlet() {
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
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
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
		ArrayList<String> errors = new ArrayList<String>();
		// 完成登陆验证，替换掉login_conf.jsp
		String path = "index.jsp";
		// 1、接收请求内容
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String choose= request.getParameter("vip");
		// 2、进行数据合法性验证，包括是否为空，长度是否满足等
		// 要将接收到的内容设置给PersonVO对象
		
			PersonVo pv = new PersonVo();
			pv.setId(id);
			pv.setPassword(password);
			pv.setErrors(errors);
			// 3、如果合法，则进行数据库验证
			if (pv.invalidate()) {
				// 数据合法，可以进行数据库验证
					if(choose.equals("0")){
						if (DAOFactory.getStudentDAOInstance().isLogin(pv)) {
							request.getSession().setAttribute("isLogin", "ok");
							path = "student/student.jsp";
						} else {
							// 用户ID、密码非法
							errors.add("错误的用户ID及密码！");
						}
					}
					if(choose.equals("1")){
						if (DAOFactory.getTeacherDAOInstance().isLogin(pv)) {
							request.getSession().setAttribute("isLogin", "ok");
							path = "teacher/teacher.jsp";
						} else {
							// 用户ID、密码非法
							errors.add("错误的用户ID及密码！");
						}
					}
			}	
		request.setAttribute("errors", errors);
		request.getSession().setAttribute("name", pv.getName());
		request.getSession().setAttribute("id", pv.getId());
		request.getRequestDispatcher(path).forward(request, response);
		
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
