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
		// ����һ�������࣬���ڱ��������Ϣ
		ArrayList<String> errors = new ArrayList<String>();
		// ��ɵ�½��֤���滻��login_conf.jsp
		String path = "index.jsp";
		// 1��������������
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String choose= request.getParameter("vip");
		// 2���������ݺϷ�����֤�������Ƿ�Ϊ�գ������Ƿ������
		// Ҫ�����յ����������ø�PersonVO����
		
			PersonVo pv = new PersonVo();
			pv.setId(id);
			pv.setPassword(password);
			pv.setErrors(errors);
			// 3������Ϸ�����������ݿ���֤
			if (pv.invalidate()) {
				// ���ݺϷ������Խ������ݿ���֤
					if(choose.equals("0")){
						if (DAOFactory.getStudentDAOInstance().isLogin(pv)) {
							request.getSession().setAttribute("isLogin", "ok");
							path = "student/student.jsp";
						} else {
							// �û�ID������Ƿ�
							errors.add("������û�ID�����룡");
						}
					}
					if(choose.equals("1")){
						if (DAOFactory.getTeacherDAOInstance().isLogin(pv)) {
							request.getSession().setAttribute("isLogin", "ok");
							path = "teacher/teacher.jsp";
						} else {
							// �û�ID������Ƿ�
							errors.add("������û�ID�����룡");
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
