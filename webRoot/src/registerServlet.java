import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.StudentVo;
import factory.DAOFactory;

public class registerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public registerServlet() {
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
		// ����һ�������࣬���ڱ��������Ϣ
		request.setCharacterEncoding("UTF-8");
		ArrayList<String> errors = new ArrayList<String>();
		// ��ɵ�½��֤���滻��login_conf.jsp
		String path = "register.jsp";
		// 1��������������
		String name = (String) request.getParameter("register_name");
		String password1 = (String) request.getParameter("register_password1");
		String password2 = (String) request.getParameter("register_password2");
		String id = (String) request.getParameter("register_id");
		int sex = Integer.parseInt((String) request.getParameter("register_sex"));
		String college = (String)request.getParameter("college");
		String profession=(String)request.getParameter("profession");
		// 2���������ݺϷ�����֤�������Ƿ�Ϊ�գ������Ƿ������
		// Ҫ�����յ����������ø�PersonVO����
		if (!(password1.equals(password2))) {
			errors.add("��������������벻ͬ������������!");
		} else {
			StudentVo pv = new StudentVo();
			pv.setId(id);
			pv.setPassword(password1);
			pv.setErrors(errors);
			pv.setSex(sex);
			pv.setName(name);
			pv.setCollege(college);
			pv.setProfession(profession);
			if (pv.regist()) {
				if (DAOFactory.getStudentDAOInstance().isTrue(id)){
					errors.add("���û��Ѵ��ڣ�");
				} else {
					if(DAOFactory.getStudentDAOInstance().insertStudent(pv)){
						path = "successRegister.jsp";
					}else{
						errors.add("ע��ʧ�ܣ�");
					}
					
				}
			}
			request.setAttribute("student", pv);
		}
		request.setAttribute("errors", errors);
		
		// response.sendRedirect(path);
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
